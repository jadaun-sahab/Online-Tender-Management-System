package com.administrator;

import java.util.Scanner;

import com.method.Methods;
import com.method.Methods_Impl;
import com.models.user;


public class newVendor {
	public void addNewVendor(int id){
		Methods m=new Methods_Impl();
		
		Scanner sc=new Scanner(System.in);
		System.out.println(":----------------------: Register New Vendor");
		System.out.print("UserName: ");
		String name=sc.next();
		System.out.print("Password: ");
		String pass=sc.next();
		
		user u=new user(0,name,pass,2);
		m.NewVendor(u);
		AdminMenu a=new AdminMenu();
		a.Amenu(id);
	}
}
