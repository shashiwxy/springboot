package com.mindtree.benchshoppingcart.jparepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.benchshoppingcart.entities.Product;

@Repository
public interface ShoppingProductsJPARepo extends JpaRepository<Product, Integer> {

	Product findById(final int id);

	@Query(value = "from Product where PRODUCT_NAME =:name")
	List<Product> showProductsByName(String name);

	@Query(value = "from Product where PRODUCT_TYPE =:categoryName")
	List<Product> showProductsByCategory(String categoryName);
}
