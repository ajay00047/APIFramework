package com.pola.api.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pola.api.beans.BaseRequestBean;
import com.pola.api.beans.SignUpRequestBean;
import com.pola.api.beans.SignUpResponseDataBean;
import com.pola.api.constants.ErrorCodes;
import com.pola.api.dao.UserDAO;
import com.pola.api.delegate.DataBean;
import com.pola.api.delegate.Processor;
import com.pola.api.util.SMSUtils;
import com.pola.api.util.Utils;

@Service
public class SignUpProcessor implements Processor {

	@Autowired
	private SignUpResponseDataBean dataBean;
	@Autowired
	private UserDAO userDAO;

	@Override
	public DataBean process(BaseRequestBean theRequestBean) throws Exception{
		SignUpRequestBean requestBean = (SignUpRequestBean) theRequestBean;
		String otp = Utils.generateOTP(6);

		if (userDAO.mobileAlreadyPresent(requestBean.getMobile())) {
			dataBean.setErrorCode(ErrorCodes.CODE_700);
		} else {
			userDAO.insertUser(requestBean);
			userDAO.updateOTP(otp,requestBean.getMobile());
			dataBean.setErrorCode(ErrorCodes.CODE_702);
			SMSUtils.SendOTP(otp,requestBean.getMobile());
		}

		return dataBean;
	}

}
