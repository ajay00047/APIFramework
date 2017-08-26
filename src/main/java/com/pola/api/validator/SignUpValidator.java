package com.pola.api.validator;

import org.springframework.stereotype.Component;

import com.pola.api.beans.SignUpRequestBean;
import com.pola.api.delegate.CustomValidator;
import com.pola.api.exception.MissingParameterException;
import com.pola.api.util.StringUtils;

@Component
public class SignUpValidator implements CustomValidator{

	@Override
	public void validate(Object obj) throws Exception {
		SignUpRequestBean bean = (SignUpRequestBean)obj;
		
		if(StringUtils.isNullOrBlank(bean.getFirstName()))
			throw new MissingParameterException();
		if(StringUtils.isNullOrBlank(bean.getLastName()))
			throw new MissingParameterException();
		if(StringUtils.isNullOrBlank(bean.getMobile()))
			throw new MissingParameterException();
	}

}
