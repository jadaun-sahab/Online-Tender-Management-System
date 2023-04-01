package Vendor;

import java.util.List;
import java.util.Scanner;

import com.method.Methods;
import com.method.Methods_Impl;
import com.models.tender;



public class placeBid {
	public void PlaceBid(int id){
		System.out.println(":-----------------------------: Open Tenders");
		Methods m=new Methods_Impl();
		List<tender> list=m.openTenders();
		for(tender i:list) {
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
			m.placeBid(tid, id, amount);
		}else {
			System.out.println("Open Tenders Not Available At This Moment!");
			
		}
		VendorMenu vm=new VendorMenu();
		vm.Vmenu(id);
	}
}
