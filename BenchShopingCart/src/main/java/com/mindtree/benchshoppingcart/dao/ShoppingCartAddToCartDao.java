package com.mindtree.benchshoppingcart.dao;

import com.mindtree.benchshoppingcart.entities.Cart;
import com.mindtree.benchshoppingcart.entities.User;

public interface ShoppingCartAddToCartDao {

	public void addProductToCart(final Cart cart);

	public Cart getCartForCartId(final int cartId);

	public User getUserForUserId(final int userId);
}
