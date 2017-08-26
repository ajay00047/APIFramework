package com.pola.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pola.api.beans.GenericResponseBean;
import com.pola.api.beans.VerifyOTPRequestBean;
import com.pola.api.constants.Constants;
import com.pola.api.processor.VerifyOTPProcessor;
import com.pola.api.validator.VerifyOTPValidator;

@RestController
public class VerifyOTPController extends BaseController {
	
	@Autowired
	private VerifyOTPValidator verifyOTPValidator;
	@Autowired
	private VerifyOTPProcessor verifyOTPProcessor;

	@RequestMapping(value = Constants.verifyOTPUrl, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public GenericResponseBean processRequest(@Valid @RequestBody VerifyOTPRequestBean requestBean) throws Exception {

		return executeRequest(requestBean,verifyOTPValidator,verifyOTPProcessor);
		
	}

}
