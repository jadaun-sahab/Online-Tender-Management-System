package com.administrator;

import java.util.List;
import java.util.Scanner;

import com.exception.CredentialException;
import com.exception.TenderException;
import com.method.Methods;
import com.method.Methods_Impl;
import com.models.Bid;

public class AllBids {
//	This Methods is for getting all the bids which were placed by the time you are looking for it
	public void getBids(int id) throws TenderException, CredentialException{
		System.out.println(":---------------------------------: All Bids");
		Methods methods_implemen=new Methods_Impl();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter TenderID: ");
		int Tid=sc.nextInt();
		List<Bid> list=methods_implemen.GetAllBids(Tid);
		System.out.println(":-----------------: All Bids for Tender:"+Tid);
		for(Bid i:list) {
			System.out.println("Tender ID       : "+i.getTid());
			System.out.println("Vendor ID       : "+i.getVid());
			System.out.println("Tender BidPrice : "+i.getBidAmount());
			System.out.println(":------------------------------------------:");
		}
		if(list.size()==0) {
			System.out.println("Error: Bids Not Found for Tender: "+Tid);
		}
		AdminMenu admin_menu=new AdminMenu();
		admin_menu.Amenu(id);
		sc.close();
	}
}
