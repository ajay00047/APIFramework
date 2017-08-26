package com.pola.api.util;

public final class PassKeyGenerator {
	public static String generatepassKey(String mobile) throws Exception {

		return Utils.generateRandomString(16);
		
	}
}
