package Vendor;

import java.util.List;
import java.util.Scanner;

import com.method.Methods;
import com.method.Methods_Impl;
import com.models.Bid;

public class AllBidsOfVendor {
	public void getAllBids(int id){
		System.out.println(":-----------------------------: Bids History");
		Methods m=new Methods_Impl();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter TenderID: ");
		int Tid=sc.nextInt();
		List<Bid> list=m.AllBidsOfVendor(Tid, id);
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
		VendorMenu vm=new VendorMenu();
		vm.Vmenu(id);
		
	}
}
