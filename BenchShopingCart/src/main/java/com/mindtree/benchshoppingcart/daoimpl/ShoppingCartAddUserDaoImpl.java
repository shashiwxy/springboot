package com.mindtree.benchshoppingcart.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.benchshoppingcart.dao.ShoppingCartAddUserDao;
import com.mindtree.benchshoppingcart.entities.Cart;
import com.mindtree.benchshoppingcart.entities.User;
import com.mindtree.benchshoppingcart.jparepository.ShoppingCartUserJPARepo;

@Service
public class ShoppingCartAddUserDaoImpl implements ShoppingCartAddUserDao {

	@Autowired
	ShoppingCartUserJPARepo cartUserJpaRepo;

	@Override
	public void addUser(final String username) {
		User entity = new User();
		entity.setUsername(username);
		entity.setCart(new Cart());
		System.out.println(entity.getUsername());
		cartUserJpaRepo.saveAndFlush(entity);
	}

}
