package com.mindtree.benchshoppingcart.service;

import com.mindtree.benchshoppingcart.entities.Product;
import com.mindtree.benchshoppingcart.exception.ShoppingCartException;

public interface ShoppingCartAddProductService {

	public void addProucts(final Product book) throws ShoppingCartException;
}
