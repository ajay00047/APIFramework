package com.pola.api.beans;

import org.springframework.stereotype.Component;

import com.pola.api.constants.ErrorCodes;

@Component
public class GenericErrorResponseBean {

	public ErrorCodes errorCode;
	public String errorMessage;
	private String passKey;
	
	public String getPassKey() {
		return passKey;
	}

	public void setPassKey(String passKey) {
		this.passKey = passKey;
	}

	public ErrorCodes getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ErrorCodes errorCode) {
		this.errorCode = errorCode;
		this.errorMessage = errorCode.getErrorMessage();
	}
}
