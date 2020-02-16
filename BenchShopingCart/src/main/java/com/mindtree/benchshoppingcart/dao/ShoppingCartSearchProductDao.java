package com.mindtree.benchshoppingcart.dao;

import java.util.List;

import com.mindtree.benchshoppingcart.entities.Product;

public interface ShoppingCartSearchProductDao {

	public List<Product> showAllProducts();

	public Product showProductsById(final int id);

	public List<Product> showProductsByName(final String name);

	public List<Product> showProductsByCategory(final String categoryName);

}
