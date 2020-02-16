package com.mindtree.benchshoppingcart.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.benchshoppingcart.dao.ShoppingCartAddToCartDao;
import com.mindtree.benchshoppingcart.entities.Cart;
import com.mindtree.benchshoppingcart.entities.User;
import com.mindtree.benchshoppingcart.jparepository.ShoppingCartJPARepo;
import com.mindtree.benchshoppingcart.jparepository.ShoppingCartUserJPARepo;

@Service
public class ShoppingCartAddToCartDaoImpl implements ShoppingCartAddToCartDao {

	@Autowired
	ShoppingCartJPARepo ShoppingCartJPARepo;

	@Autowired
	ShoppingCartUserJPARepo shoppingCartUserJPARepo;

	@Override
	public void addProductToCart(final Cart cartDetails) {
		ShoppingCartJPARepo.saveAndFlush(cartDetails);
	}

	@Override
	public Cart getCartForCartId(final int cartId) {
		Cart cart = ShoppingCartJPARepo.findById(cartId);
		return cart;
	}

	@Override
	public User getUserForUserId(final int userId) {
		User user = shoppingCartUserJPARepo.findById(userId);
		return user;
	}
}
