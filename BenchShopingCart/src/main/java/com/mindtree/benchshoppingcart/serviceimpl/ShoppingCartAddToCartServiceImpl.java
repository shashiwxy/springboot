package com.mindtree.benchshoppingcart.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.benchshoppingcart.dao.ShoppingCartAddToCartDao;
import com.mindtree.benchshoppingcart.dao.ShoppingCartSearchProductDao;
import com.mindtree.benchshoppingcart.dtos.UserIdAndProductId;
import com.mindtree.benchshoppingcart.entities.Cart;
import com.mindtree.benchshoppingcart.entities.CartItem;
import com.mindtree.benchshoppingcart.entities.Product;
import com.mindtree.benchshoppingcart.entities.User;
import com.mindtree.benchshoppingcart.exception.ShoppingCartException;
import com.mindtree.benchshoppingcart.service.ShoppingCartAddToCartService;
import com.mindtree.benchshoppingcart.util.ShoppingCartConstants;
import com.mindtree.benchshoppingcart.util.ShoppingCartExceptionMessageHelper;

@Service
public class ShoppingCartAddToCartServiceImpl implements ShoppingCartAddToCartService {

	private static Logger LOGGER = LoggerFactory.getLogger(ShoppingCartAddToCartServiceImpl.class);

	@Autowired
	ShoppingCartSearchProductDao searchProductDao;

	@Autowired
	ShoppingCartAddToCartDao addToCartDao;

	@Override
	public void addProductToCart(final UserIdAndProductId userAndProductId) throws ShoppingCartException {

		LOGGER.info("Entering in addProductToCart() with UserIdAndProductId : " + userAndProductId);
		Product product = searchProductDao.showProductsById(userAndProductId.getProductId());
		if (product == null) {
			throw new ShoppingCartException(ShoppingCartExceptionMessageHelper.getMessageForInvalidId("Product Id"));
		}
		User user = addToCartDao.getUserForUserId(userAndProductId.getUserId());
		if (user == null) {
			throw new ShoppingCartException(ShoppingCartExceptionMessageHelper.getMessageForInvalidId("User Id"));
		}
		try {

			Cart cartDetails = addToCartDao.getCartForCartId(user.getCart().getCartId());

			List<CartItem> cartItems = cartDetails.getCartItems();
			if (!cartItems.isEmpty() && product != null) {
				addCartItem(cartItems, product);
			} else {
				addNewCartItem(cartItems, product);
			}

			addCartToCartItems(cartItems, cartDetails);
			addProductsToCart(product, cartDetails);

			addToCartDao.addProductToCart(cartDetails);

		}  catch (Exception exception) {
			LOGGER.info(ShoppingCartExceptionMessageHelper.getExceptionMessage("addProductToCart", exception));
			throw new ShoppingCartException(ShoppingCartConstants.NOT_ABLE_PERFORM);
		}
		LOGGER.info("Exiting from addProductToCart()");

	}

	private void addProductsToCart(final Product newProduct, final Cart cartDetails) {
		LOGGER.info(
				"Entering in addProductsToCart() with newProduct : " + newProduct + " cart Details : " + cartDetails);
		List<Product> products = cartDetails.getProducts();
		boolean productExist = false;
		if (products == null) {
			products = new ArrayList<Product>();
		}
		for (Product product : products) {
			if (product.getProductId() == newProduct.getProductId()) {
				productExist = true;
			}
		}
		if (!productExist) {
			products.add(newProduct);
		}
		LOGGER.info("Exiting from addProductsToCart()");
	}

	private void addCartToCartItems(final List<CartItem> cartItems, final Cart cartDetails) {
		LOGGER.info(
				"Entering in addCartToCartItems() with cartItems : " + cartItems + " and cartDetails : " + cartDetails);
		for (CartItem cartItem : cartItems) {
			cartItem.setCart(cartDetails);
		}
		LOGGER.info("Exiting from addCartToCartItems()");
	}

	private void addCartItem(final List<CartItem> cartItems, final Product product) {
		LOGGER.info("Entering in addCartItem() with cartItems : " + cartItems + " and Product : " + product);
		boolean newProduct = true;
		for (CartItem cartItem : cartItems) {
			if (cartItem.getProductId() == product.getProductId()) {
				cartItem.setQuantity(cartItem.getQuantity() + 1);
				newProduct = false;
				break;
			}
		}
		if (newProduct) {
			addNewCartItem(cartItems, product);
		}
		LOGGER.info("Exiting from addCartItem()");
	}

	private void addNewCartItem(final List<CartItem> cartItems, final Product product) {
		LOGGER.info("Entering in addNewCartItem() with cartItems : " + cartItems + " and Product : " + product);
		CartItem cartItem = new CartItem();
		cartItem.setProductId(product.getProductId());
		cartItem.setProductName(product.getProductName());
		cartItem.setProductPrice(product.getProductPrice());
		cartItem.setQuantity(1);

		cartItems.add(cartItem);
		LOGGER.info("Exiting from addNewCartItem()");
	}

}
