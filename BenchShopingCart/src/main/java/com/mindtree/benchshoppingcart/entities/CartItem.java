package com.mindtree.benchshoppingcart.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@NamedQueries({ @NamedQuery(name = CartItem.DELETE_PRODUCT, query = CartItem.DELETE_PRODUCT_QUERY),
		@NamedQuery(name = CartItem.DELETE_ALL_PRODUCT, query = CartItem.DELETE_ALL_PRODUCT_QUERY) })
public class CartItem {

	public static final String DELETE_PRODUCT = "CartItem.deleteProduct";
	static final String DELETE_PRODUCT_QUERY = "delete from CartItem  where cart_cart_id =:cartId and  product_Id =:productId";

	public static final String DELETE_ALL_PRODUCT = "CartItem.deleteAllProduct";
	static final String DELETE_ALL_PRODUCT_QUERY = "delete from CartItem  where cart_cart_id =:cartId";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private int productId;

	private String productName;

	@Column(name = "PRICE_PER_PRODUCT")
	private float productPrice;

	private int quantity;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private Cart cart;

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartItem [id=" + id + ", productId=" + productId + ", productName=" + productName + ", productPrice="
				+ productPrice + ", quantity=" + quantity + ", cart=" + cart + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cart == null) ? 0 : cart.hashCode());
		result = prime * result + id;
		result = prime * result + productId;
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + Float.floatToIntBits(productPrice);
		result = prime * result + quantity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartItem other = (CartItem) obj;
		if (cart == null) {
			if (other.cart != null)
				return false;
		} else if (!cart.equals(other.cart))
			return false;
		if (id != other.id)
			return false;
		if (productId != other.productId)
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (Float.floatToIntBits(productPrice) != Float.floatToIntBits(other.productPrice))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

}
