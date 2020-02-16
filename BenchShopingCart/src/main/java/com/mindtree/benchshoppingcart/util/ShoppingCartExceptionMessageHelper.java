package com.mindtree.benchshoppingcart.util;

public class ShoppingCartExceptionMessageHelper {

	public static String getExceptionMessage(final String methodName, final Exception exception) {
		return ShoppingCartConstants.SOMETHING_WENT_WRONG + ShoppingCartConstants.SPACE + methodName
				+ ShoppingCartConstants.METHOD_SYMBOL + ShoppingCartConstants.SPACE + exception;
	}

	public static String getMessageForInvalidId(final String type) {
		return ShoppingCartConstants.INVALID + ShoppingCartConstants.SPACE + type + ShoppingCartConstants.SPACE
				+ ShoppingCartConstants.TRY_AGAIN;
	}
}
