package com.mindtree.benchshoppingcart.dtos;

import java.util.List;

import com.mindtree.benchshoppingcart.entities.CartItem;

public class CartDetails {

	private List<CartItem> cartItems;

	private float totalAmount;

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "CartDetails [cartItems=" + cartItems + ", Total Amount To Be Paid : " + totalAmount + "]";
	}

}
