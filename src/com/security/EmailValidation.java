package com.security;

import java.util.regex.Pattern;

public class EmailValidation {

	/*
	 * Method for Email validation
	 */
	public String emailValidation(String email) {
		if(email == null || email.isEmpty()) {
			return "Invalid";
		}
		
		String emailRegex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" +
				"[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
		
		Pattern pattern = Pattern.compile(emailRegex);
		if(pattern.matcher(email).matches()) {
			return "Valid";		
			}else {
				return "Invalid";
			}
		                    
	}
}
