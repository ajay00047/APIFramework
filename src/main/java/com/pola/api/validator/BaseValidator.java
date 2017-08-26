package com.pola.api.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.pola.api.beans.BaseRequestBean;

@SuppressWarnings("rawtypes")
@Component
public class BaseValidator implements Validator {

	private boolean passKeyValidation;

	public BaseValidator() {
		this.passKeyValidation = false;
	}

	@Autowired
	public BaseValidator(boolean passKeyValidation) {
		this.passKeyValidation = passKeyValidation;
	}

	public boolean supports(Class clazz) {
		return BaseRequestBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		BaseRequestBean bean = (BaseRequestBean) target;
		if (null == bean.getAppPassCode() || bean.getAppPassCode().equals("")) {
			errors.reject("Invalid AppPassCode");
		}

		// check pass key
		if (passKeyValidation) {
			if (null == bean.getPassKey() || bean.getPassKey().equals("") || !validatePassKey(bean.getPassKey()))
				errors.reject("Invalid PassKey");

		}
	}

	public boolean validatePassKey(String passkey) {
		return false;
	}

}
