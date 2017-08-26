package com.pola.api.validator;

import org.springframework.stereotype.Component;

import com.pola.api.beans.VerifyOTPRequestBean;
import com.pola.api.delegate.CustomValidator;
import com.pola.api.exception.MissingParameterException;
import com.pola.api.util.StringUtils;

@Component
public class VerifyOTPValidator implements CustomValidator{

	@Override
	public void validate(Object obj) throws Exception {
		VerifyOTPRequestBean bean = (VerifyOTPRequestBean)obj;
		
		if(StringUtils.isNullOrBlank(bean.getMobile()))
			throw new MissingParameterException();
		
		if(StringUtils.isNullOrBlank(bean.getOtp()))
			throw new MissingParameterException();
	}

}
