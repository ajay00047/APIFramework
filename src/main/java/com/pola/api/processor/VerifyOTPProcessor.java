package com.pola.api.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pola.api.beans.BaseRequestBean;
import com.pola.api.beans.VerifyOTPRequestBean;
import com.pola.api.beans.VerifyOTPResponseDataBean;
import com.pola.api.constants.ErrorCodes;
import com.pola.api.dao.UserDAO;
import com.pola.api.delegate.DataBean;
import com.pola.api.delegate.Processor;
import com.pola.api.exception.DBTransactionException;
import com.pola.api.util.PassKeyGenerator;

@Service
public class VerifyOTPProcessor implements Processor {

	@Autowired
	private VerifyOTPResponseDataBean dataBean;
	@Autowired
	private UserDAO userDAO;

	@Override
	public DataBean process(BaseRequestBean theRequestBean) throws Exception {
		VerifyOTPRequestBean requestBean = (VerifyOTPRequestBean) theRequestBean;

		if (!userDAO.mobileAlreadyPresent(requestBean.getMobile())) {
			dataBean.setErrorCode(ErrorCodes.CODE_701);
		} else {
			if (userDAO.verifyOTP(requestBean.getOtp(), requestBean.getMobile())) {
				
				String passKey = PassKeyGenerator.generatepassKey(requestBean.getMobile());
				if (userDAO.updatePassKey(passKey, requestBean.getMobile())){
					dataBean.setErrorCode(ErrorCodes.CODE_704);
					dataBean.setPassKey(passKey);
					userDAO.updateOTP(null, requestBean.getMobile());
				}
				else
					throw new DBTransactionException();

			} else
				dataBean.setErrorCode(ErrorCodes.CODE_705);
		}

		return dataBean;
	}

}
