package com.mindtree.benchshoppingcart.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.benchshoppingcart.dao.ShoppingCartSearchProductDao;
import com.mindtree.benchshoppingcart.entities.Product;
import com.mindtree.benchshoppingcart.exception.ShoppingCartException;
import com.mindtree.benchshoppingcart.service.ShoppingCartSearchProductService;
import com.mindtree.benchshoppingcart.util.ShoppingCartConstants;
import com.mindtree.benchshoppingcart.util.ShoppingCartExceptionMessageHelper;

@Service
public class ShoppingCartSearchProductServiceImpl implements ShoppingCartSearchProductService {

	private static Logger LOGGER = LoggerFactory.getLogger(ShoppingCartSearchProductServiceImpl.class);

	@Autowired
	ShoppingCartSearchProductDao shoppingCartDao;

	@Override
	public List<Product> showAllProuducts() throws ShoppingCartException {
		LOGGER.info("Entering in showAllProuducts()");
		List<Product> showAllProducts = null;
		try {
			showAllProducts = shoppingCartDao.showAllProducts();
			if (showAllProducts == null) {
				throw new ShoppingCartException("Oops Cart Is Empty...!!");
			}
		} catch (Exception exception) {
			LOGGER.info(ShoppingCartExceptionMessageHelper.getExceptionMessage("showAllProuducts", exception));
			throw new ShoppingCartException(ShoppingCartConstants.NOT_ABLE_PERFORM);
		}
		LOGGER.info("Exiting from showAllProuducts()");
		return showAllProducts;
	}

	@Override
	public Product showProductsById(final int id) throws ShoppingCartException {
		LOGGER.info("Entering in showProductsById() with Product Id : " + id);
		Product product = null;
		try {
			
			product = shoppingCartDao.showProductsById(id);
			if (product == null) {
				throw new ShoppingCartException(
						ShoppingCartExceptionMessageHelper.getMessageForInvalidId("Product Id"));
			}
		} catch (ShoppingCartException shoppingCartException) {
			
			throw new ShoppingCartException(shoppingCartException.getMessage());
		} catch (Exception exception) {
			LOGGER.info(ShoppingCartExceptionMessageHelper.getExceptionMessage("showProductsById", exception));
			throw new ShoppingCartException(ShoppingCartConstants.NOT_ABLE_PERFORM);
		}
		LOGGER.info("Exiting from showProductsById() with product : " + product);
		return product;
	}

	@Override
	public List<Product> showProductsByName(final String name) throws ShoppingCartException {
		LOGGER.info("Entering in showProductsByName() with Product name : " + name);
		List<Product> showAllProducts = null;
		try {
			showAllProducts = shoppingCartDao.showProductsByName(name.toUpperCase());
			if (showAllProducts == null || showAllProducts.isEmpty()) {
				throw new ShoppingCartException(
						ShoppingCartExceptionMessageHelper.getMessageForInvalidId("Product Name"));
			}
		} catch (ShoppingCartException shoppingCartException) {
			
			throw new ShoppingCartException(shoppingCartException.getMessage());
		} catch (Exception exception) {
			LOGGER.info(ShoppingCartExceptionMessageHelper.getExceptionMessage("showProductsByName", exception));
			throw new ShoppingCartException(ShoppingCartConstants.NOT_ABLE_PERFORM);
		}
		LOGGER.info("Exiting from showProductsByName() with products : " + showAllProducts);
		return showAllProducts;
	}

	@Override
	public List<Product> showProductsByCategory(final String category) throws ShoppingCartException {
		LOGGER.info("Entering in showProductsByCategory() with Product category : " + category);
		String categoryName = getProductCategoryCode(category);
		List<Product> showAllProducts = null;
		try {
			showAllProducts = shoppingCartDao.showProductsByCategory(categoryName);
			if (showAllProducts == null) {
				throw new ShoppingCartException("There Is No Product For The Category : " + category);
			}
		} catch (ShoppingCartException shoppingCartException) {
			
			throw new ShoppingCartException(shoppingCartException.getMessage());
		} catch (Exception exception) {
			LOGGER.info(ShoppingCartExceptionMessageHelper.getExceptionMessage("showProductsByCategory", exception));
			throw new ShoppingCartException(ShoppingCartConstants.NOT_ABLE_PERFORM);
		}
		LOGGER.info("Exiting from showProductsByCategory() with Products : " + showAllProducts);
		return showAllProducts;
	}

	private String getProductCategoryCode(final String category) throws ShoppingCartException {
		LOGGER.info("Entering in getProductCategoryCode() with category : " + category);
		String categoryName = ShoppingCartConstants.EMPTY_STRING;
		if (ShoppingCartConstants.APPAREL.equalsIgnoreCase(category)) {
			categoryName = ShoppingCartConstants.APPAREL_CODE;
		} else if (ShoppingCartConstants.BOOK.equalsIgnoreCase(category)) {
			categoryName = ShoppingCartConstants.BOOK_CODE;
		} else {
			throw new ShoppingCartException(
					ShoppingCartExceptionMessageHelper.getMessageForInvalidId("Product Category"));
		}
		LOGGER.info("Exiting from getProductCategoryCode() with category code : " + categoryName);
		return categoryName;
	}

}
