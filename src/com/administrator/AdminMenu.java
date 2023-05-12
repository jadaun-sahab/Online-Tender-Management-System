package com.administrator;

import java.util.Scanner;

import com.exception.CredentialException;
import com.exception.TenderException;
import com.start.login;


public class AdminMenu {
	public void Amenu(int id) throws TenderException, CredentialException{
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
		int options=sc.nextInt();
		
		switch(options) {
		case 1:NewVendor new_vendor=new NewVendor();
			new_vendor.addNewVendor(id);
			break;
		case 2:AllVendors all_vendor=new AllVendors();
			all_vendor.getVendors(id);
			break;
		case 3:NewTender new_tender=new NewTender();
			new_tender.addnewTender(id);
			break;
		case 4:AllTenders all_tender=new AllTenders();
			all_tender.getTenders(id);
			break;
		case 5:AllBids all_bid=new AllBids();
			all_bid.getBids(id);
			break;
		case 6:AutoAssignTender assigning_tender=new AutoAssignTender();
			assigning_tender.getMaxBid(id);
			break;
		case 7:DeleteTender deleting_tendor=new DeleteTender();
			deleting_tendor.deletetender(id);
			break;
		case 8:DeleteVendor deleting_vendor=new DeleteVendor();
			deleting_vendor.DeleteVendor(id);
			break;
		case 9:login log_in=new login();
			log_in.Login();
			break;
		default:System.out.println("Enter Correct Choice!");
			AdminMenu admin_menu=new AdminMenu();
			admin_menu.Amenu(id);
			sc.close();
		}
	}
}
