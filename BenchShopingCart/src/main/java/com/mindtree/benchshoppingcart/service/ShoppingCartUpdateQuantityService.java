package com.mindtree.benchshoppingcart.service;

import com.mindtree.benchshoppingcart.dtos.UserIdAndProductQuantity;
import com.mindtree.benchshoppingcart.exception.ShoppingCartException;

public interface ShoppingCartUpdateQuantityService {

	void updateQuantity(final UserIdAndProductQuantity userIdProductQuantity) throws ShoppingCartException;

}
