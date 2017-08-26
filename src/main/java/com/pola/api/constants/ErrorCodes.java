package com.pola.api.constants;

public enum ErrorCodes {

	CODE_700 {
		public String getErrorMessage() {
			return "Mobile Already Present. Please Relogin";
		}
	},
	
	CODE_701 {
		public String getErrorMessage() {
			return "Mobile Not Present. Please SignUp";
		}
	},
	
	CODE_702 {
		public String getErrorMessage() {
			return "SignUp Successful! OTP sent to your mobile number.";
		}
	},
	
	CODE_703 {
		public String getErrorMessage() {
			return "OTP sent to your mobile number.";
		}
	},
	
	CODE_704 {
		public String getErrorMessage() {
			return "OTP verified successfully.";
		}
	},
	
	CODE_705 {
		public String getErrorMessage() {
			return "Wrong OTP! Please try again.";
		}
	},
	
	CODE_707 {
		public String getErrorMessage() {
			return "Login Expired! Please relogin.";
		}
	}
	
	;

	public String getErrorMessage() {
		return "Error Mesage";
	}

}
