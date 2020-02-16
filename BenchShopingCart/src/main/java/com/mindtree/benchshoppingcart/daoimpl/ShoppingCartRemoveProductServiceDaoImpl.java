package com.mindtree.benchshoppingcart.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.benchshoppingcart.dao.ShoppingCartRemoveProductsDao;
import com.mindtree.benchshoppingcart.jparepository.ShoppingCartCartItemsJPARepo;

@Service
public class ShoppingCartRemoveProductServiceDaoImpl implements ShoppingCartRemoveProductsDao {

	@Autowired
	ShoppingCartCartItemsJPARepo cartItemJPARepo;

	@Override
	public void removeAllProducts(final int cartId) {
		cartItemJPARepo.deleteAllProduct(cartId);
	}

	@Override
	public void removeProductsById(final int cartId, final int productId) {
		cartItemJPARepo.deleteProduct(cartId, productId);
	}

}
