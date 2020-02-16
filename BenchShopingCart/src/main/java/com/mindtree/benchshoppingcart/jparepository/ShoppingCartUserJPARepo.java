package com.mindtree.benchshoppingcart.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.benchshoppingcart.entities.User;

@Repository
public interface ShoppingCartUserJPARepo extends JpaRepository<User, Integer> {

	User findById(final int id);
}
