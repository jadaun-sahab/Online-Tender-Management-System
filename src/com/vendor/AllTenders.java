package com.vendor;

import java.util.List;

import com.exception.BidException;
import com.exception.CredentialException;
import com.exception.TenderException;
import com.method.Methods;
import com.method.Methods_Impl;
import com.models.Tender;




public class AllTenders {
	public void getTenders(int id) throws TenderException, CredentialException{
		System.out.println(":------------------------------: All Tenders");
		Methods methods_implemen=new Methods_Impl();
		List<Tender> list=methods_implemen.AllTendersOfVendor(id);
		for(Tender i:list) {
			System.out.println("Tender ID       : "+i.getId());
			System.out.println("Tendor Name     : "+i.getName());
			System.out.println("tender Type     : "+i.getType());
			System.out.println("Tender MinAmount: "+i.getAmount());
			System.out.println("Tender BidPrice : "+i.getBidPrice());
			System.out.println(":------------------------------------------:");
		}
		if(list.size()==0) {
			throw new BidException("Error: No Tenders Available!");
		}
		VendorMenu Vendor_Menu=new VendorMenu();
		Vendor_Menu.Vmenu(id);
		
	}
}
