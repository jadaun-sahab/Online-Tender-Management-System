package com.administrator;

import java.util.List;
import java.util.Scanner;

import com.method.Methods;
import com.method.Methods_Impl;
import com.models.tender;



public class deleteVendor {
	public void DeleteVendor(int id){
		System.out.println(":---------------------------: Delete Vendors");
		Methods m=new Methods_Impl();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter VendorID: ");
		int Vid=sc.nextInt();
		List<tender> list=m.AllTendersOfVendor(Vid);
		if(list.size()==0) {
			m.deleteBidByVid(Vid);
			m.deleteVendor(Vid);
		}else {
			System.out.println("Error: Vendor Has Active/Assigned Tenders Can't Delete!");
		}
		AdminMenu a=new AdminMenu();
		a.Amenu(id);
	}
}
