package com.pola.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pola.api.beans.GenericResponseBean;
import com.pola.api.beans.SignUpRequestBean;
import com.pola.api.constants.Constants;
import com.pola.api.processor.SignUpProcessor;
import com.pola.api.validator.SignUpValidator;

@RestController
public class SignUpController extends BaseController {
	
	@Autowired
	private SignUpValidator signUpValidator;
	@Autowired
	private SignUpProcessor signUpProcessor;

	@RequestMapping(value = Constants.signUpUrl, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public GenericResponseBean processRequest(@Valid @RequestBody SignUpRequestBean requestBean) throws Exception {

		return executeRequest(requestBean,signUpValidator,signUpProcessor);
		
	}

}
