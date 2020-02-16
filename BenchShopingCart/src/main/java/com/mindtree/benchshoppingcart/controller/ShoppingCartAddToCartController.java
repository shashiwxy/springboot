package com.mindtree.benchshoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.benchshoppingcart.dtos.UserIdAndProductId;
import com.mindtree.benchshoppingcart.exception.ShoppingCartException;
import com.mindtree.benchshoppingcart.service.ShoppingCartAddToCartService;
import com.mindtree.benchshoppingcart.util.ShoppingCartConstants;
import com.mindtree.benchshoppingcart.util.ShoppingCartURLs;

@RestController
public class ShoppingCartAddToCartController {

	@Autowired
	ShoppingCartAddToCartService addToCartService;

	@RequestMapping(value = ShoppingCartURLs.ADD_PRODUCT_TO_CART)

	public String addProductToCart(@RequestBody final UserIdAndProductId userAndProductId) {
		try {
			addToCartService.addProductToCart(userAndProductId);
			return ShoppingCartConstants.ADDED;
		} catch (ShoppingCartException shoppingCartException) {
			return shoppingCartException.getMessage();
		}
	}
}
