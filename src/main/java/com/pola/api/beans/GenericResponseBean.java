package com.pola.api.beans;

import com.pola.api.delegate.DataBean;

public class GenericResponseBean {

	private int status;
	private String errorCode;
	private String errorDescription;
	private DataBean dataBean;

	public DataBean getDataBean() {
		return dataBean;
	}

	public void setDataBean(DataBean dataBean) {
		this.dataBean = dataBean;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int success) {
		this.status = success;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

}
