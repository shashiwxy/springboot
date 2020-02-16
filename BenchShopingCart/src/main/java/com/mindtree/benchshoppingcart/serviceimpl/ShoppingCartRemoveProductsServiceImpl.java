package com.mindtree.benchshoppingcart.serviceimpl;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.benchshoppingcart.dao.ShoppingCartAddToCartDao;
import com.mindtree.benchshoppingcart.dao.ShoppingCartRemoveProductsDao;
import com.mindtree.benchshoppingcart.dtos.UserIdAndProductId;
import com.mindtree.benchshoppingcart.entities.Cart;
import com.mindtree.benchshoppingcart.entities.User;
import com.mindtree.benchshoppingcart.exception.ShoppingCartException;
import com.mindtree.benchshoppingcart.service.ShoppingCartRemoveProductsService;
import com.mindtree.benchshoppingcart.util.ShoppingCartConstants;
import com.mindtree.benchshoppingcart.util.ShoppingCartExceptionMessageHelper;

@Service
@Transactional
public class ShoppingCartRemoveProductsServiceImpl implements ShoppingCartRemoveProductsService {

	private static Logger LOGGER = LoggerFactory.getLogger(ShoppingCartRemoveProductsServiceImpl.class);

	@Autowired
	ShoppingCartRemoveProductsDao removeProductDao;

	@Autowired
	ShoppingCartAddToCartDao addToCartDao;

	@Override
	public void removeAllProducts(final int userId) throws ShoppingCartException {
		LOGGER.info("Entering in removeAllProducts() with userId : " + userId);
		User user = addToCartDao.getUserForUserId(userId);
		if (user == null) {
			throw new ShoppingCartException(ShoppingCartExceptionMessageHelper.getMessageForInvalidId("User Id"));
		}
		try {

			Cart cart = addToCartDao.getCartForCartId(user.getCart().getCartId());
			removeProductDao.removeAllProducts(cart.getCartId());
		} catch (Exception exception) {
			LOGGER.info(ShoppingCartExceptionMessageHelper.getExceptionMessage("removeAllProducts", exception));
			throw new ShoppingCartException(ShoppingCartConstants.NOT_ABLE_PERFORM);
		}
	}

	@Override
	public void removeProductsById(final UserIdAndProductId userAndProductId) {
		User user = addToCartDao.getUserForUserId(userAndProductId.getUserId());
		Cart cart = addToCartDao.getCartForCartId(user.getCart().getCartId());

		removeProductDao.removeProductsById(cart.getCartId(), userAndProductId.getProductId());

	}

}
