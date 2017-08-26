package com.pola.api.exception;

import com.pola.api.constants.Constants;

public class DBTransactionException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DBTransactionException(){
		super(Constants.DB_ERROR+"[Unable to perform DB Operation]");
	}

}
