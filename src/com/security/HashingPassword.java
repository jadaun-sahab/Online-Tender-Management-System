package com.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashingPassword {
	/*
	 * Hashing method for password.
	 */
	public String hashingAlgorithem(String password) {
		
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA");
			messageDigest.update(password.getBytes());
			byte[] byteArray = messageDigest.digest();
			StringBuilder sb = new StringBuilder();
			for(byte b:byteArray) {
				sb.append(String.format("%02x", b));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return null;
		
	} 
}
