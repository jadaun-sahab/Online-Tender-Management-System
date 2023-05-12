package com.vendor;

import java.util.List;
import java.util.Scanner;

import com.exception.BidException;
import com.exception.CredentialException;
import com.exception.TenderException;
import com.method.Methods;
import com.method.Methods_Impl;
import com.models.Bid;

public class AllBidsOfVendor  {
	public void GetAllBids(int id) throws BidException, TenderException, CredentialException{
		System.out.println(":-----------------------------: Bids History");
		Methods methods_implemen=new Methods_Impl();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter TenderID: ");
		int Tid=sc.nextInt();
		List<Bid> list=methods_implemen.AllBidsOfVendor(Tid, id);
		System.out.println(":-----------------: All Bids for Tender:"+Tid);
		int j=1;
		for(Bid i:list) {
			System.out.println(j+") BidPrice : "+i.getBidAmount());
			j++;
		}
		if(list.size()==0) {
			System.out.println("Error: Bids Not Found for Tender: "+Tid);
		}
		System.out.println(":------------------------------------------:");
		VendorMenu Vendor_Menu=new VendorMenu();
		Vendor_Menu.Vmenu(id);
		sc.close();
		
	}
}
