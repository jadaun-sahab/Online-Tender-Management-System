package com.vendor;

import java.util.Scanner;

import com.exception.CredentialException;
import com.exception.TenderException;
import com.method.Methods;
import com.method.Methods_Impl;



public class DeleteBids {
	public void DeleteBids(int id) throws   TenderException, CredentialException{
		System.out.println(":-----------------------------: Open Tenders");
		Methods methods_implemen=new Methods_Impl();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter TenderID  : ");
		int tid=sc.nextInt();
		methods_implemen.DeleteBid(tid, id);
		VendorMenu Vendor_Menu=new VendorMenu();
		Vendor_Menu.Vmenu(id);
		sc.close();
	}
}
