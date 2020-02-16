package com.mindtree.benchshoppingcart.exception;

public class ShoppingCartException extends Exception {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	public ShoppingCartException() {
		super();
	}

	public ShoppingCartException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ShoppingCartException(String message, Throwable cause) {
		super(message, cause);
	}

	public ShoppingCartException(String message) {
		super(message);
	}

	public ShoppingCartException(Throwable cause) {
		super(cause);
	}
}
