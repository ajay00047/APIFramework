package com.pola.api.constants;

public class Constants {
	
	//Webservice Urls
	public final static String loginUrl = "/login";
	public final static String signUpUrl = "/signUp";
	public final static String verifyOTPUrl = "/verifyOTP";
	public final static String errorUrl = "/error";
	
	//Response Constants
	public final static int SUCCESS = 1;
	public final static int FAILURE = 0;
	public final static String CODE_SUCCESS = "200";
	public final static String DESC_SUCCESS = "OK";
	
	//error
	public final static String VALIDATION_ERROR="VALIDATION_ERROR";
	public final static String VALIDATION_FAILED="Validation failed";
	public final static String DB_ERROR="DB_ERROR";
	
	//SMS Template
	public static final String SMS_APPNAME="POLA";
	public static final String SMS_OTP_TEMPLATE="Thanks for using %s. Your OTP is %s. Kindly do not share your OTP with others.";
	
	public static final String SMS_SENDER_ID="TESTIN";
	public static final String SMS_SENDER_USER="ajayrvarma";
	public static final String SMS_SENDER_PASSWORD="549246";
	public static final String SMS_CHANNEL="2";
	public static final String SMS_DCS="0";
	public static final String SMS_ROUTE="1";
	public static final String SMS_FLASHSMS="0";
	public static final String SMS_SchedTime=null;
	public static final String SMS_GroupId=null;
	public static final String SMS_API_CODE="Rj2Ddp1MAkigNDsZdDP2Vw";
	public static final String SMS_REST_URL="https://www.smsgatewayhub.com/RestAPI/MT.svc/mt";
	public static final String SMS_HTTP_URL="https://www.smsgatewayhub.com/api/mt/SendSMS";
}
