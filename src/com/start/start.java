package com.start;

import java.sql.Connection;
import java.sql.SQLException;

import com.connection.DButils;

public class start {
	public static void main(String[] args) throws SQLException{
		login l=new login();
		l.Login();
	}
}
