package com.administrator;

import java.util.List;

import com.method.Methods;
import com.method.Methods_Impl;
import com.models.tender;


public class AllTenders {
	public void getTenders(int id){
		System.out.println(":------------------------------: All Tenders");
		Methods m=new Methods_Impl();
		List<tender> list=m.getAllTenders();
		for(tender i:list) {
			System.out.println("Tender ID       : "+i.getId());
			System.out.println("Tendor Name     : "+i.getName());
			System.out.println("tender Type     : "+i.getType());
			System.out.println("Tender MinAmount: "+i.getAmount());
			if(i.getStatus()==1) {
				System.out.println("Tender Status   : Closed");
			}else {
				System.out.println("Tender Status   : Open");
			}
			System.out.println("Tender BidPrice : "+i.getBidPrice());
			System.out.println("Vendor ID       : "+i.getVid());
			System.out.println(":------------------------------------------:");
		}
		AdminMenu a=new AdminMenu();
		a.Amenu(id);
	}
}
