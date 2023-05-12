package com.vendor;

import java.util.Scanner;

import com.exception.CredentialException;
import com.exception.TenderException;
import com.start.login;


public class VendorMenu {
	public void Vmenu(int id) throws TenderException, CredentialException {
		Scanner sc=new Scanner(System.in);
		System.out.println(":------------------------------: Vendor Menu");
		System.out.println("1) Get All Tenders");
		System.out.println("2) Place Bid For Tenders");
		System.out.println("3) Delete Bid");
		System.out.println("4) View Bid History");
		System.out.println("5) LogOut");
		System.out.print("Enter Your Choice: ");
		int options=sc.nextInt();
		
		switch(options) {
		case 1:
			AllTenders All_Tenders=new AllTenders();
			All_Tenders.getTenders(id);
			break;
		case 2:
			PlaceBid Place_Bid=new PlaceBid();
			Place_Bid.PlaceBid(id);
			break;
		case 3:
			DeleteBids Delete_Bids=new DeleteBids();
			Delete_Bids.DeleteBids(id);
			break;
		case 4:
			AllBidsOfVendor All_Bids_Of_Vendo=new AllBidsOfVendor();
			All_Bids_Of_Vendo.GetAllBids(id);
			break;
		case 5:
			login log_in=new login();
			log_in.Login();
			break;
		default:
			System.out.println("Enter Correct Choice!");
			VendorMenu Vendor_Menu=new VendorMenu();
			Vendor_Menu.Vmenu(id);
			
		}
	}
}
