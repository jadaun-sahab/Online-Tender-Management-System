package com.administrator;

import java.util.List;
import java.util.Scanner;

import com.exception.CredentialException;
import com.exception.TenderException;
import com.method.Methods;
import com.method.Methods_Impl;
import com.models.Tender;



public class DeleteVendor {
//	This Method is for deleting the venders by id

	public void DeleteVendor(int id) throws TenderException, CredentialException{
		System.out.println(":---------------------------: Delete Vendors");
		Methods methods_implemen=new Methods_Impl();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter VendorID: ");
		int Vid=sc.nextInt();
		List<Tender> list=methods_implemen.AllTendersOfVendor(Vid);
		if(list.size()==0) {
			methods_implemen.DeleteBidByVid(Vid);
			methods_implemen.DeleteVendor(Vid);
		}else {
			System.out.println("Error: Vendor Has Active/Assigned Tenders Can't Delete!");
		}
		AdminMenu admin_menu=new AdminMenu();
		admin_menu.Amenu(id);
		sc.close();
	}
}
