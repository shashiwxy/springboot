package com.mindtree.benchshoppingcart.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.benchshoppingcart.dao.ShoppingCartAddProductDao;
import com.mindtree.benchshoppingcart.entities.Product;
import com.mindtree.benchshoppingcart.exception.ShoppingCartException;
import com.mindtree.benchshoppingcart.service.ShoppingCartAddProductService;
import com.mindtree.benchshoppingcart.util.ShoppingCartConstants;
import com.mindtree.benchshoppingcart.util.ShoppingCartExceptionMessageHelper;

@Service
public class ShoppingCartAddProductServiceImpl implements ShoppingCartAddProductService {

	private static Logger LOGGER = LoggerFactory.getLogger(ShoppingCartAddProductServiceImpl.class);

	@Autowired
	ShoppingCartAddProductDao addProductDao;

	@Override
	public void addProucts(final Product product) throws ShoppingCartException {
		LOGGER.info("Entering in addProucts() with Product : " + product);
		try {
			addProductDao.addProucts(product);
		} catch (Exception exception) {
			LOGGER.info(ShoppingCartExceptionMessageHelper.getExceptionMessage("addProucts", exception));
			throw new ShoppingCartException(ShoppingCartConstants.NOT_ABLE_PERFORM);
		}
		LOGGER.info("Exiting from addProducts()");
	}
}
