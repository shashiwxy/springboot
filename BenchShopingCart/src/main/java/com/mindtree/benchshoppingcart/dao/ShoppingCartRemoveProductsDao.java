package com.mindtree.benchshoppingcart.dao;

public interface ShoppingCartRemoveProductsDao {

	void removeAllProducts(int cartId);

	void removeProductsById(final int cartId, final int productId);

}
