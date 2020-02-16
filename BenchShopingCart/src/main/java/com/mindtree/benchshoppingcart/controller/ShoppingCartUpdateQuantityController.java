package com.mindtree.benchshoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.benchshoppingcart.dtos.UserIdAndProductQuantity;
import com.mindtree.benchshoppingcart.exception.ShoppingCartException;
import com.mindtree.benchshoppingcart.service.ShoppingCartUpdateQuantityService;
import com.mindtree.benchshoppingcart.util.ShoppingCartConstants;
import com.mindtree.benchshoppingcart.util.ShoppingCartURLs;

@RestController
public class ShoppingCartUpdateQuantityController {

	@Autowired
	ShoppingCartUpdateQuantityService updateQuantityService;

	@RequestMapping(value = ShoppingCartURLs.UPDATE_QUANTITY_IN_CART)

	public String updateQuantity(@RequestBody final UserIdAndProductQuantity userIdProductQuantity) {
		try {
			updateQuantityService.updateQuantity(userIdProductQuantity);
			return ShoppingCartConstants.UPDATED;
		} catch (ShoppingCartException shoppingCartException) {
			return shoppingCartException.getMessage();
		}
	}

}
