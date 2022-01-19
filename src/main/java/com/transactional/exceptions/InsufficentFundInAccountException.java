package com.transactional.exceptions;

public class InsufficentFundInAccountException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InsufficentFundInAccountException(String msg) {
		super(msg);
	}

}
