package com.pola.api.constants;

public class Query {
	
	public static final String COUNT_USERS_MOBILE="select count(1) from users where mobile=?";
	public static final String INSERT_USER="insert into users(first_name,last_name,mobile) VALUES(?,?,?)";
	public static final String UPDATE_USER_OTP="update users set otp=? where mobile=?";
	public static final String VERIFY_OTP="select count(1) from users where otp=? and mobile=?";
	public static final String UPDATE_PASS_KEY="update users set pass_key=? where mobile=?";

}
