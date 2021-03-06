package com.pola.api.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

import com.pola.api.beans.BaseRequestBean;
import com.pola.api.beans.GenericResponseBean;
import com.pola.api.constants.Constants;
import com.pola.api.delegate.CustomValidator;
import com.pola.api.delegate.DataBean;
import com.pola.api.delegate.Processor;
import com.pola.api.util.StringUtils;
import com.pola.api.validator.BaseValidator;

public abstract class BaseController {

    @Autowired
    private ApplicationContext context;
    
    @Bean(name = "baseValidator")
    @Scope("prototype")
    BaseValidator baseValidator(boolean passKeyValidation) {
        return new BaseValidator(passKeyValidation);
    }
    
	//Set up logger
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// basic validations
	@InitBinder
	protected void initBinder(HttpServletRequest request,WebDataBinder binder) {
		String path = request.getServletPath();
		boolean passKeyValidation = true;
		//add urls to exclude them from passKey validation
		if(Constants.signUpUrl.equals(path) || Constants.loginUrl.equals(path) || Constants.verifyOTPUrl.equals(path))
			passKeyValidation=false;
		binder.setValidator((BaseValidator)context.getBean("baseValidator", passKeyValidation));
	}
	
	//custom validation
	protected void validate(BaseRequestBean requestBean,CustomValidator validator) throws Exception{
		logger.debug("Processing Request");
		validator.validate(requestBean);
	}

	// Generic response generator
	protected GenericResponseBean generateResponse(DataBean dataBean) {
		GenericResponseBean responseBean = new GenericResponseBean();
		responseBean.setDataBean(dataBean);
		responseBean.setStatus(Constants.SUCCESS);
		responseBean.setErrorCode(Constants.CODE_SUCCESS);
		responseBean.setErrorDescription(Constants.DESC_SUCCESS);

		return responseBean;
	}

	// Generic Exception handling
	@ExceptionHandler(Exception.class)
	protected GenericResponseBean processError(HttpServletRequest request, Exception exception) {
		exception.printStackTrace();
		GenericResponseBean bean = new GenericResponseBean();
		bean.setStatus(Constants.FAILURE);
		bean.setErrorCode(StringUtils.getErrorMessage(exception.getMessage())[0]);
		bean.setErrorDescription(StringUtils.getErrorMessage(exception.getMessage())[1]);
		return bean;
	}
	
	protected GenericResponseBean executeRequest(BaseRequestBean requestBean,CustomValidator validator,Processor processor) throws Exception{
		
		// validate input fields
		validate(requestBean,validator);
		
		//generate response
		return generateResponse(processor.process(requestBean));
	}

}
