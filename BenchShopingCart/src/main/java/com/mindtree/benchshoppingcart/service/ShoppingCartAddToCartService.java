package com.mindtree.benchshoppingcart.service;

import com.mindtree.benchshoppingcart.dtos.UserIdAndProductId;
import com.mindtree.benchshoppingcart.exception.ShoppingCartException;

public interface ShoppingCartAddToCartService {

	public void addProductToCart(final UserIdAndProductId userAndProductId) throws ShoppingCartException;
}
