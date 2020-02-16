package com.mindtree.benchshoppingcart.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.benchshoppingcart.dao.ShoppingCartAddProductDao;
import com.mindtree.benchshoppingcart.entities.Product;
import com.mindtree.benchshoppingcart.jparepository.ShoppingProductsJPARepo;

@Service
public class ShoppingCartAddProductsDaoImpl implements ShoppingCartAddProductDao {

	@Autowired
	ShoppingProductsJPARepo shoppingProjectJPARepo;

	@Override
	public void addProucts(final Product product) {

		shoppingProjectJPARepo.saveAndFlush(product);
	}
}
