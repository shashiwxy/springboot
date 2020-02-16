package com.mindtree.benchshoppingcart.dtos;

public class UserIdAndProductQuantity {

	private int productQuantity;

	private int userId;

	private int productId;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UserIdAndProductQuantity [productQuantity=" + productQuantity + ", userId=" + userId + ", productId="
				+ productId + "]";
	}

}
