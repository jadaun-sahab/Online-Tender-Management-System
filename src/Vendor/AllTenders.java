package Vendor;

import java.util.List;

import com.method.Methods;
import com.method.Methods_Impl;
import com.models.tender;



public class AllTenders {
	public void getTenders(int id){
		System.out.println(":------------------------------: All Tenders");
		Methods m=new Methods_Impl();
		List<tender> list=m.AllTendersOfVendor(id);
		for(tender i:list) {
			System.out.println("Tender ID       : "+i.getId());
			System.out.println("Tendor Name     : "+i.getName());
			System.out.println("tender Type     : "+i.getType());
			System.out.println("Tender MinAmount: "+i.getAmount());
			System.out.println("Tender BidPrice : "+i.getBidPrice());
			System.out.println(":------------------------------------------:");
		}
		if(list.size()==0) {
			System.out.println("Error: No Tenders Available!");
		}
		VendorMenu vm=new VendorMenu();
		vm.Vmenu(id);
		
	}
}
