package com.mindtree.benchshoppingcart.service;

import com.mindtree.benchshoppingcart.exception.ShoppingCartException;

public interface ShoppingCartAddUserService {

	void addUser(final String username) throws ShoppingCartException;

}
