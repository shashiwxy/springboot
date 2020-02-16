package com.mindtree.benchshoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.benchshoppingcart.exception.ShoppingCartException;
import com.mindtree.benchshoppingcart.service.ShoppingCartAddUserService;
import com.mindtree.benchshoppingcart.util.ShoppingCartConstants;
import com.mindtree.benchshoppingcart.util.ShoppingCartURLs;

@RestController
public class ShoppingCartAddUserController {

	@Autowired
	ShoppingCartAddUserService addUserService;

	@RequestMapping(value = ShoppingCartURLs.ADD_USER)
	public String addUser(@PathVariable final String username) {
		try {
			addUserService.addUser(username);
			return ShoppingCartConstants.ADDED;
		} catch (ShoppingCartException shoppingCartException) {
			return shoppingCartException.getMessage();
		}
	}
}
