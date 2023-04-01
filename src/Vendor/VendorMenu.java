package Vendor;

import java.util.Scanner;

import com.start.login;


public class VendorMenu {
	public void Vmenu(int id){
		Scanner sc=new Scanner(System.in);
		System.out.println(":------------------------------: Vendor Menu");
		System.out.println("1) Get All Tenders");
		System.out.println("2) Place Bid For Tenders");
		System.out.println("3) Delete Bid");
		System.out.println("4) View Bid History");
		System.out.println("5) LogOut");
		System.out.print("Enter Your Choice: ");
		int c=sc.nextInt();
		
		switch(c) {
		case 1:AllTenders at=new AllTenders();
			at.getTenders(id);
			break;
		case 2:placeBid pb=new placeBid();
			pb.PlaceBid(id);
			break;
		case 3:deleteBids db=new deleteBids();
			db.DeleteBids(id);
			break;
		case 4:AllBidsOfVendor abv=new AllBidsOfVendor();
			abv.getAllBids(id);
			break;
		case 5:login l=new login();
			l.Login();
			break;
		default:System.out.println("Enter Correct Choice!");
			VendorMenu vm=new VendorMenu();
			vm.Vmenu(id);
		}
	}
}
