package com.administrator;

import java.util.Scanner;

import com.exception.CredentialException;
import com.exception.TenderException;
import com.method.Methods;
import com.method.Methods_Impl;
import com.models.User;


public class NewVendor {
//	This Method is for creating the new Venders
	public void addNewVendor(int id) throws TenderException, CredentialException{
		Methods methods_implemen=new Methods_Impl();
		
		Scanner sc=new Scanner(System.in);
		System.out.println(":----------------------: Register New Vendor");
		System.out.print("UserName: ");
		String name=sc.next();
		System.out.print("Password: ");
		String pass=sc.next();
		
		User user_obj=new User(name,pass,2);
		methods_implemen.NewVendor(user_obj);
		AdminMenu admin_menu=new AdminMenu();
		admin_menu.Amenu(id);
		sc.close();
	}
}
