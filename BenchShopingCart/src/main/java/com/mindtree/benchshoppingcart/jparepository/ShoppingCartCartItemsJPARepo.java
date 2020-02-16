package com.mindtree.benchshoppingcart.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.mindtree.benchshoppingcart.entities.CartItem;

@Repository
public interface ShoppingCartCartItemsJPARepo extends JpaRepository<CartItem, Integer> {

	@Modifying
	void deleteProduct(final int cartId, final int productId);

	@Modifying
	void deleteAllProduct(final int cartId);
}
