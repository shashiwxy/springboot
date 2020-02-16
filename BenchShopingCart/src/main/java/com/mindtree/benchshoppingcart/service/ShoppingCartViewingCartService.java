package com.mindtree.benchshoppingcart.service;

import com.mindtree.benchshoppingcart.dtos.CartDetails;
import com.mindtree.benchshoppingcart.exception.ShoppingCartException;

public interface ShoppingCartViewingCartService {

	CartDetails getCartDetails(final int userId) throws ShoppingCartException;

}
