package com.pola.api.beans;

public class BaseRequestBean {

	private String passKey;
	private String appPassCode;
	
	public String getAppPassCode() {
		return appPassCode;
	}

	public void setAppPassCode(String appPassCode) {
		this.appPassCode = appPassCode;
	}

	public String getPassKey() {
		return passKey;
	}

	public void setPassKey(String passKey) {
		this.passKey = passKey;
	}

}
