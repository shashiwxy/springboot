package com.mindtree.benchshoppingcart.service;

import com.mindtree.benchshoppingcart.dtos.UserIdAndProductId;
import com.mindtree.benchshoppingcart.exception.ShoppingCartException;

public interface ShoppingCartRemoveProductsService {

	void removeAllProducts(final int userId) throws ShoppingCartException;

	void removeProductsById(final UserIdAndProductId userAndProductId) throws ShoppingCartException;

}
