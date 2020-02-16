package com.mindtree.benchshoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.benchshoppingcart.exception.ShoppingCartException;
import com.mindtree.benchshoppingcart.service.ShoppingCartSearchProductService;
import com.mindtree.benchshoppingcart.util.PrettyFormatJSON;
import com.mindtree.benchshoppingcart.util.ShoppingCartURLs;


@RestController
public class ShoppingCartSearchProductController {

	@Autowired
	ShoppingCartSearchProductService showProductService;

	@RequestMapping(value = ShoppingCartURLs.SHOW_ALL_PRODUCTS)

	public String showAllProucts() {
		try {
			return PrettyFormatJSON.getPrettyJSON(showProductService.showAllProuducts());
		} catch (ShoppingCartException shoppingCartException) {
			return shoppingCartException.getMessage();
		}
	}

	@RequestMapping(value = ShoppingCartURLs.SHOW_PRODUCT_BY_ID)

	public String showProductsById(@PathVariable final int id) {
		try {
			return PrettyFormatJSON.getPrettyJSON(showProductService.showProductsById(id));
		} catch (ShoppingCartException shoppingCartException) {
			return shoppingCartException.getMessage();
		}
	}

	@RequestMapping(value = ShoppingCartURLs.SHOW_PRODUCTS_BY_NAME)

	public String showProductsByName(@PathVariable final String name) {
		try {
			return PrettyFormatJSON.getPrettyJSON(showProductService.showProductsByName(name));
		} catch (ShoppingCartException shoppingCartException) {
			return shoppingCartException.getMessage();
		}
	}

	@RequestMapping(value = ShoppingCartURLs.SHOW_PRODUCTS_BY_CATEGORY)

	public String showProductsByCategory(@PathVariable final String category) {
		try {
			return PrettyFormatJSON.getPrettyJSON(showProductService.showProductsByCategory(category));
		} catch (ShoppingCartException shoppingCartException) {
			return shoppingCartException.getMessage();
		}
	}

}
