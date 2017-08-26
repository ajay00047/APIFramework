package com.pola.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pola.api.beans.GenericResponseBean;
import com.pola.api.beans.LoginRequestBean;
import com.pola.api.constants.Constants;
import com.pola.api.processor.LoginProcessor;
import com.pola.api.validator.LoginValidator;

@RestController
public class LoginController extends BaseController {
	
	@Autowired
	private LoginValidator loginValidator;
	@Autowired
	private LoginProcessor loginProcessor;

	@RequestMapping(value = Constants.loginUrl, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public GenericResponseBean processRequest(@Valid @RequestBody LoginRequestBean requestBean) throws Exception {

		return executeRequest(requestBean,loginValidator,loginProcessor);
		
	}

}
