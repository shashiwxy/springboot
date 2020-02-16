package com.mindtree.benchshoppingcart.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.benchshoppingcart.dao.ShoppingCartAddToCartDao;
import com.mindtree.benchshoppingcart.dao.ShoppingCartRemoveProductsDao;
import com.mindtree.benchshoppingcart.dao.ShoppingCartSearchProductDao;
import com.mindtree.benchshoppingcart.dtos.UserIdAndProductQuantity;
import com.mindtree.benchshoppingcart.entities.Cart;
import com.mindtree.benchshoppingcart.entities.CartItem;
import com.mindtree.benchshoppingcart.entities.User;
import com.mindtree.benchshoppingcart.exception.ShoppingCartException;
import com.mindtree.benchshoppingcart.service.ShoppingCartUpdateQuantityService;
import com.mindtree.benchshoppingcart.util.ShoppingCartConstants;
import com.mindtree.benchshoppingcart.util.ShoppingCartExceptionMessageHelper;

@Service
@Transactional
public class ShoppingCartUpdateQuantityServiceImpl implements ShoppingCartUpdateQuantityService {

	private static Logger LOGGER = LoggerFactory.getLogger(ShoppingCartUpdateQuantityServiceImpl.class);

	@Autowired
	ShoppingCartSearchProductDao searchProductDao;

	@Autowired
	ShoppingCartAddToCartDao addToCartDao;

	@Autowired
	ShoppingCartRemoveProductsDao removeProductDao;

	@Override
	public void updateQuantity(final UserIdAndProductQuantity userIdProductQuantity) throws ShoppingCartException {

		LOGGER.info("Entering in updateQuantity() with userIdProductQuantity : " + userIdProductQuantity);
		User user = addToCartDao.getUserForUserId(userIdProductQuantity.getUserId());
		if (user == null) {
			throw new ShoppingCartException(ShoppingCartExceptionMessageHelper.getMessageForInvalidId("User Id"));
		}
		try {

			Cart cartDetails = addToCartDao.getCartForCartId(user.getCart().getCartId());
			List<CartItem> cartItems = cartDetails.getCartItems();
			if (!cartItems.isEmpty()) {
				updateQuantity(cartItems, user.getCart().getCartId(), userIdProductQuantity.getProductId(),
						userIdProductQuantity.getProductQuantity());
			}
			addToCartDao.addProductToCart(cartDetails);

		} catch (ShoppingCartException shoppingCartException) {
			
			throw new ShoppingCartException(shoppingCartException.getMessage());
		} catch (Exception exception) {
			LOGGER.info(ShoppingCartExceptionMessageHelper.getExceptionMessage("updateQuantity", exception));
			throw new ShoppingCartException(ShoppingCartConstants.NOT_ABLE_PERFORM);
		}
		LOGGER.info("Exiting from updateQuantity()");
	}

	private void updateQuantity(final List<CartItem> cartItems, final int cartId, final int productId,
			final int productQuantity) throws ShoppingCartException {

		LOGGER.info("Entering in updateQuantity() with cartItems : " + cartItems + "cart Id : " + cartId
				+ "Product Id : " + productId + "Quantity : " + productQuantity);
		boolean validProductId = false;
		for (CartItem cartItem : cartItems) {
			if (cartItem.getProductId() == productId) {
				validProductId = true;
				if (productQuantity > 0) {
					cartItem.setQuantity(productQuantity);
				} else if (productQuantity == 0) {
					removeProductDao.removeProductsById(cartId, productId);
				} else {
					throw new ShoppingCartException("Product Quantity Can't Be Less Than Zero...!!");
				}
			}
		}
		if(!validProductId) {
			throw new ShoppingCartException(ShoppingCartExceptionMessageHelper.getMessageForInvalidId("Product Id"));
		}
		LOGGER.info("Exiting from updateQuantity()");
	}

}
