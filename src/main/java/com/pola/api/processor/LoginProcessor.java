package com.pola.api.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pola.api.beans.BaseRequestBean;
import com.pola.api.beans.LoginRequestBean;
import com.pola.api.beans.LoginResponseDataBean;
import com.pola.api.constants.ErrorCodes;
import com.pola.api.dao.UserDAO;
import com.pola.api.delegate.DataBean;
import com.pola.api.delegate.Processor;
import com.pola.api.util.SMSUtils;
import com.pola.api.util.Utils;

@Service
public class LoginProcessor implements Processor {

	@Autowired
	private LoginResponseDataBean dataBean;
	@Autowired
	private UserDAO userDAO;

	@Override
	public DataBean process(BaseRequestBean theRequestBean) throws Exception{
		LoginRequestBean requestBean = (LoginRequestBean) theRequestBean;
		String otp = Utils.generateOTP(6);
		
		if (!userDAO.mobileAlreadyPresent(requestBean.getMobile())) {
			dataBean.setErrorCode(ErrorCodes.CODE_701);
		} else {
			userDAO.updateOTP(otp,requestBean.getMobile());
			dataBean.setErrorCode(ErrorCodes.CODE_703);
			SMSUtils.SendOTP(otp,requestBean.getMobile());
		}

		return dataBean;
	}

}
