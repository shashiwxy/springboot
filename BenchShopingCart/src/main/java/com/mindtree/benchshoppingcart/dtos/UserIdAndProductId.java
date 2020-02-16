package com.mindtree.benchshoppingcart.dtos;

public class UserIdAndProductId {

	private int userId;

	private int productId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "UserIdAndProductId [userId=" + userId + ", productId=" + productId + "]";
	}

}
