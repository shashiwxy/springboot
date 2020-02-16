package com.mindtree.benchshoppingcart.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.benchshoppingcart.dao.ShoppingCartAddUserDao;
import com.mindtree.benchshoppingcart.exception.ShoppingCartException;
import com.mindtree.benchshoppingcart.service.ShoppingCartAddUserService;
import com.mindtree.benchshoppingcart.util.ShoppingCartConstants;
import com.mindtree.benchshoppingcart.util.ShoppingCartExceptionMessageHelper;

@Service
public class ShoppingCartAddUserServiceImpl implements ShoppingCartAddUserService {

	private static Logger LOGGER = LoggerFactory.getLogger(ShoppingCartAddUserServiceImpl.class);

	@Autowired
	ShoppingCartAddUserDao addUserDao;

	@Override
	public void addUser(final String username) throws ShoppingCartException {
		LOGGER.info("Entering in addUser() with username : " + username);
		try {
			addUserDao.addUser(username);
		} catch (Exception exception) {
			LOGGER.info(ShoppingCartExceptionMessageHelper.getExceptionMessage("addUser", exception));
			throw new ShoppingCartException(ShoppingCartConstants.NOT_ABLE_PERFORM);
		}
		LOGGER.info("Exiting from addUser()");
	}

}
