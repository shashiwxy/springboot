package com.mindtree.benchshoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mindtree.benchshoppingcart.exception.ShoppingCartException;
import com.mindtree.benchshoppingcart.service.ShoppingCartViewingCartService;
import com.mindtree.benchshoppingcart.util.PrettyFormatJSON;
import com.mindtree.benchshoppingcart.util.ShoppingCartURLs;

@RestController
public class ShoppingCartViewingCartController {

	@Autowired
	ShoppingCartViewingCartService viewCartService;

	@RequestMapping(value = ShoppingCartURLs.VIEW_CART)
	public String viewCartDetails(@PathVariable final int userId) throws JsonProcessingException {

		try {
			return PrettyFormatJSON.getPrettyJSON(viewCartService.getCartDetails(userId));
		} catch (ShoppingCartException shoppingCartException) {
			return shoppingCartException.getMessage();
		}
	}

}
