package com.start;
import java.sql.SQLException;

import com.exception.CredentialException;
import com.exception.TenderException;

public class Start {
	public static void main(String[] args) throws SQLException, TenderException, CredentialException{
		login log_in=new login();
		log_in.Login();
	}
}
