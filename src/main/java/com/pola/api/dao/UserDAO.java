package com.pola.api.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pola.api.beans.SignUpRequestBean;
import com.pola.api.constants.Query;

@Repository
@Transactional
public class UserDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean mobileAlreadyPresent(String mobile) {
		int count = jdbcTemplate.queryForObject(Query.COUNT_USERS_MOBILE, new Object[] { mobile }, Integer.class);
		return (count > 0?true:false);			
	}
	
	public boolean insertUser(SignUpRequestBean bean) {
		int count = jdbcTemplate.update(Query.INSERT_USER, new Object[] {bean.getFirstName(),bean.getLastName(),bean.getMobile()});
		return (count > 0?true:false);			
	}
	
	public boolean updateOTP(String otp,String mobile) {
		int count = jdbcTemplate.update(Query.UPDATE_USER_OTP, new Object[] {otp,mobile});
		return (count > 0?true:false);			
	}
	
	public boolean verifyOTP(String otp,String mobile) {
		int count = jdbcTemplate.queryForObject(Query.VERIFY_OTP, new Object[] {otp,mobile},Integer.class);
		return (count > 0?true:false);			
	}
	
	public boolean updatePassKey(String passKey,String mobile) {
		int count = jdbcTemplate.update(Query.UPDATE_PASS_KEY, new Object[] {passKey,mobile});
		return (count > 0?true:false);			
	}

}