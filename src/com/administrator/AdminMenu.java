package com.administrator;

import java.util.Scanner;

import com.start.login;


public class AdminMenu {
	public void Amenu(int id){
		Scanner sc=new Scanner(System.in);
		System.out.println(":------------------------------: Admin Menu");
		System.out.println("1) Register New Vendor");
		System.out.println("2) Get All Vendors");
		System.out.println("3) Create New Tender");
		System.out.println("4) Get All Tenders");
		System.out.println("5) View Bids of Tenders");
		System.out.println("6) Assign a Tender To Vendor(Auto)");
		System.out.println("7) Delete Tender");
		System.out.println("8) Delete Vendor");
		System.out.println("9) LogOut");
		
		System.out.print("Enter Your Choice: ");
		int c=sc.nextInt();
		
		switch(c) {
		case 1:newVendor v=new newVendor();
			v.addNewVendor(id);
			break;
		case 2:AllVendors a=new AllVendors();
			a.getVendors(id);
			break;
		case 3:newTender n=new newTender();
			n.addnewTender(id);
			break;
		case 4:AllTenders t=new AllTenders();
			t.getTenders(id);
			break;
		case 5:AllBids b=new AllBids();
			b.getBids(id);
			break;
		case 6:AutoAssignTender at=new AutoAssignTender();
			at.getMaxBid(id);
			break;
		case 7:deleteTender dt=new deleteTender();
			dt.deletetender(id);
			break;
		case 8:deleteVendor dv=new deleteVendor();
			dv.DeleteVendor(id);
			break;
		case 9:login l=new login();
			l.Login();
			break;
		default:System.out.println("Enter Correct Choice!");
			AdminMenu m=new AdminMenu();
			m.Amenu(id);
		}
	}
}
