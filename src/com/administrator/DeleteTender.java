package com.administrator;

import java.util.Scanner;

import com.exception.CredentialException;
import com.exception.TenderException;
import com.method.Methods;
import com.method.Methods_Impl;


public class DeleteTender {
//	This Method is for deleting the Tenders by id

	public void deletetender(int id) throws TenderException, CredentialException{
		System.out.println(":---------------------------: Delete Tenders");
		Methods methods_implemen=new Methods_Impl();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter TenderID: ");
		int Tid=sc.nextInt();
		
		methods_implemen.DeleteBidByTid(Tid);
		methods_implemen.DeleteTender(Tid);
		AdminMenu admin_menu=new AdminMenu();
		admin_menu.Amenu(id);
		sc.close();
	}
}
