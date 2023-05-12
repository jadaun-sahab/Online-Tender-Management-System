package com.vendor;

import java.util.List;
import java.util.Scanner;

import com.exception.BidException;
import com.exception.CredentialException;
import com.exception.TenderException;
import com.method.Methods;
import com.method.Methods_Impl;
import com.models.Bid;
import com.models.Tender;



public class PlaceBid {
	public void PlaceBid(int id) throws BidException, TenderException, CredentialException{
		System.out.println(":-----------------------------: Open Tenders");
		Methods methods_implemen=new Methods_Impl();
		List<Tender> list=methods_implemen.OpenTenders();
		for(Tender i:list) {
			System.out.println("Tender ID       : "+i.getId());
			System.out.println("Tendor Name     : "+i.getName());
			System.out.println("tender Type     : "+i.getType());
			System.out.println("Tender MinAmount: "+i.getAmount());
			System.out.println(":------------------------------------------:");
		}
		if(list.size()!=0) {
			Scanner sc=new Scanner(System.in);
			System.out.print("Enter TenderID  : ");
			int tid=sc.nextInt();
			System.out.print("Enter Bid Amount: ");
			int amount=sc.nextInt();
			methods_implemen.PlaceBid(tid, id, amount);
			
		}else {
			throw new BidException("Open Tenders Not Available At This Moment!");
			
		}
		VendorMenu vendor_menu=new VendorMenu();
		vendor_menu.Vmenu(id);
		
	}
}
