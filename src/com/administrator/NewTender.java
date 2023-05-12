package com.administrator;

import java.util.Scanner;

import com.exception.CredentialException;
import com.exception.TenderException;
import com.method.Methods;
import com.method.Methods_Impl;
import com.models.Tender;


public class NewTender {
//	This Method is for creating the new Tenders

	public void addnewTender(int id) throws TenderException, CredentialException{
		Methods methods_implemen=new Methods_Impl();
		
		Scanner sc=new Scanner(System.in);
		System.out.println(":---------------------------: Add New Tender");
		System.out.print("Name      : ");
		String name=sc.next();
		System.out.print("type      : ");
		String type=sc.next();
		System.out.print("Amount    : ");
		int amount=sc.nextInt();
		Tender t=new Tender(0,name,type,amount,0,0,0);
		methods_implemen.NewTender(t);
		AdminMenu admin_menu=new AdminMenu();
		admin_menu.Amenu(id);
		sc.close();
	}
}
