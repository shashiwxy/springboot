package com.mindtree.benchshoppingcart.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.benchshoppingcart.dao.ShoppingCartAddToCartDao;
import com.mindtree.benchshoppingcart.dtos.CartDetails;
import com.mindtree.benchshoppingcart.entities.Cart;
import com.mindtree.benchshoppingcart.entities.CartItem;
import com.mindtree.benchshoppingcart.entities.User;
import com.mindtree.benchshoppingcart.exception.ShoppingCartException;
import com.mindtree.benchshoppingcart.service.ShoppingCartViewingCartService;
import com.mindtree.benchshoppingcart.util.ShoppingCartConstants;
import com.mindtree.benchshoppingcart.util.ShoppingCartExceptionMessageHelper;

@Service
public class ShoppingCartViewingCartServiceImpl implements ShoppingCartViewingCartService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ShoppingCartViewingCartServiceImpl.class);

	@Autowired
	ShoppingCartAddToCartDao addToCartDao;

	@Override
	public CartDetails getCartDetails(final int userId) throws ShoppingCartException {
		LOGGER.info("Entering in getCartDetails with UserID : " + userId);
		User user = addToCartDao.getUserForUserId(userId);
		Cart cart = null;
		CartDetails cartDetails = null;
		if (user == null) {
			throw new ShoppingCartException(ShoppingCartExceptionMessageHelper.getMessageForInvalidId("User Id"));
		}
		try {
			cart = addToCartDao.getCartForCartId(user.getCart().getCartId());
			cartDetails = new CartDetails();
			cartDetails.setCartItems(cart.getCartItems());
			cartDetails.setTotalAmount(getTotalPrictForCart(cart.getCartItems()));
		} catch (Exception exception) {
			LOGGER.info(ShoppingCartExceptionMessageHelper.getExceptionMessage("getCartDetails", exception));
			throw new ShoppingCartException(ShoppingCartConstants.NOT_ABLE_PERFORM);
		}

		LOGGER.info("Exiting from getCartDetails with CartDetials : " + cartDetails);
		return cartDetails;
	}

	private float getTotalPrictForCart(final List<CartItem> cartItems) {
		LOGGER.info("Entering in getTotalPrictForCart with cartItems : " + cartItems);
		float total = 0;
		for (CartItem cartItem : cartItems) {
			total = total + cartItem.getProductPrice() * cartItem.getQuantity();
		}
		LOGGER.info("Exiting from getTotalPrictForCart with total : " + total);
		return total;
	}

}
