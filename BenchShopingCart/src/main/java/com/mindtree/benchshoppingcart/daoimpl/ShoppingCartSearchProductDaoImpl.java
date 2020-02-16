package com.mindtree.benchshoppingcart.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.benchshoppingcart.dao.ShoppingCartSearchProductDao;
import com.mindtree.benchshoppingcart.entities.Product;
import com.mindtree.benchshoppingcart.jparepository.ShoppingProductsJPARepo;

@Service
public class ShoppingCartSearchProductDaoImpl implements ShoppingCartSearchProductDao {

	@Autowired
	ShoppingProductsJPARepo shoppingProjectJPARepo;

	@Override
	public List<Product> showAllProducts() {
		List<Product> products = shoppingProjectJPARepo.findAll();
		return products;
	}

	@Override
	public Product showProductsById(final int id) {
		Product product = shoppingProjectJPARepo.findById(id);
		return product;
	}

	@Override
	public List<Product> showProductsByName(final String name) {
		List<Product> products = shoppingProjectJPARepo.showProductsByName(name);
		return products;
	}

	@Override
	public List<Product> showProductsByCategory(final String categoryName) {
		List<Product> products = shoppingProjectJPARepo.showProductsByCategory(categoryName);
		return products;
	}

}
