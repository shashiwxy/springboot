package com.mindtree.benchshoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.benchshoppingcart.dtos.UserIdAndProductId;
import com.mindtree.benchshoppingcart.exception.ShoppingCartException;
import com.mindtree.benchshoppingcart.service.ShoppingCartRemoveProductsService;
import com.mindtree.benchshoppingcart.util.ShoppingCartConstants;
import com.mindtree.benchshoppingcart.util.ShoppingCartURLs;

@RestController
public class ShoppingCartRemoveProductsController {

	@Autowired
	ShoppingCartRemoveProductsService removeAllProductService;

	@RequestMapping(value = ShoppingCartURLs.REMOVE_ALL_PRODUCTS)

	public String removeAllProducts(@PathVariable int userId) {
		String response = null;
		try {
			removeAllProductService.removeAllProducts(userId);
			response = ShoppingCartConstants.REMOVED;
		} catch (ShoppingCartException shoppingCartException) {
			response = shoppingCartException.getMessage();
		}
		return response;
	}

	@RequestMapping(value = ShoppingCartURLs.REMOVE_PRODUCTS_BY_ID)

	public String removeProductsById(@RequestBody final UserIdAndProductId userAndProductId) {
		String response = null;
		try {
			removeAllProductService.removeProductsById(userAndProductId);
			response = ShoppingCartConstants.REMOVED;
		} catch (ShoppingCartException shoppingCartException) {
			response = shoppingCartException.getMessage();
		}
		return response;
	}
}
