package com.mindtree.benchshoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.benchshoppingcart.entities.Apparel;
import com.mindtree.benchshoppingcart.entities.Book;
import com.mindtree.benchshoppingcart.exception.ShoppingCartException;
import com.mindtree.benchshoppingcart.service.ShoppingCartAddProductService;
import com.mindtree.benchshoppingcart.util.ShoppingCartConstants;
import com.mindtree.benchshoppingcart.util.ShoppingCartURLs;

@RestController
public class ShoppingCartAddProductsController {

	@Autowired
	ShoppingCartAddProductService addProductService;

	@RequestMapping(value = ShoppingCartURLs.ADD_BOOK)
	public String addBooks(@RequestBody final Book book) {
		try {
			addProductService.addProucts(book);
			return ShoppingCartConstants.ADDED;
		} catch (ShoppingCartException shoppingCartException) {
			return shoppingCartException.getMessage();
		}
	}

	@RequestMapping(value = ShoppingCartURLs.ADD_APPAREL)
	public String addApparel(@RequestBody final Apparel apparel) {
		try {
			addProductService.addProucts(apparel);
			return ShoppingCartConstants.ADDED;
		} catch (ShoppingCartException shoppingCartException) {
			return shoppingCartException.getMessage();
		}
	}
}
