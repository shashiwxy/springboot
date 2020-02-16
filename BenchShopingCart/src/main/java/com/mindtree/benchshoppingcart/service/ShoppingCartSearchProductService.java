package com.mindtree.benchshoppingcart.service;

import java.util.List;

import com.mindtree.benchshoppingcart.entities.Product;
import com.mindtree.benchshoppingcart.exception.ShoppingCartException;

public interface ShoppingCartSearchProductService {

	public List<Product> showAllProuducts() throws ShoppingCartException;

	public Product showProductsById(final int id) throws ShoppingCartException;

	public List<Product> showProductsByName(final String name) throws ShoppingCartException;

	public List<Product> showProductsByCategory(final String category) throws ShoppingCartException;

}
