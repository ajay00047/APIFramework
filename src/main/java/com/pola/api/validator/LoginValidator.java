package com.pola.api.validator;

import org.springframework.stereotype.Component;

import com.pola.api.beans.LoginRequestBean;
import com.pola.api.delegate.CustomValidator;
import com.pola.api.exception.MissingParameterException;
import com.pola.api.util.StringUtils;

@Component
public class LoginValidator implements CustomValidator{

	@Override
	public void validate(Object obj) throws Exception {
		LoginRequestBean bean = (LoginRequestBean)obj;
		
		if(StringUtils.isNullOrBlank(bean.getMobile()))
			throw new MissingParameterException();
	}

}
