package com.mindtree.benchshoppingcart.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.benchshoppingcart.entities.Cart;

@Repository
public interface ShoppingCartJPARepo extends JpaRepository<Cart, Integer> {

	Cart findById(final int id);
}
