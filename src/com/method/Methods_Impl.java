package com.method;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.administrator.AdminMenu;
import com.connection.DButils;
import com.exception.CredentialException;
import com.exception.TenderException;
import com.models.Bid;
import com.models.Tender;
import com.models.User;
import com.security.EmailValidation;
import com.security.HashingPassword;
import com.start.login;
import com.vendor.VendorMenu;

public class Methods_Impl implements Methods{
	
    HashingPassword hashingPassword = new HashingPassword();
	
	EmailValidation emailValidation =  new EmailValidation();
	
	@Override
	public void login(String username, String password) throws TenderException, CredentialException{
//		With the help of This Method we can login as user or admin
		Connection conn = null;
		try {
			conn = DButils.connectToDatabase();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		if(emailValidation.emailValidation(username)=="Invalid") {
			throw new CredentialException("Wrong email address plese provide right syntax of email.");
		}
		password = hashingPassword.hashingAlgorithem(password);
		try {
			PreparedStatement ps=conn.prepareStatement("select * from user where username = ? and password = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				System.out.println("Welcome "+rs.getString("username"));
				if(rs.getInt("userType")==1) {
					AdminMenu a=new AdminMenu();
					a.Amenu(rs.getInt("ID"));
				}else {
					VendorMenu v=new VendorMenu();
					v.Vmenu(rs.getInt("ID"));
				}
			}else {
				System.out.println("Error: User Not Found!");
			}
		} catch (SQLException e) {
			System.out.println("Error: User Not Found!");
			System.out.println(e.getMessage());
		}
		login l=new login();
		l.Login();
	}

	@Override
	public void NewVendor(User user) throws CredentialException{
//		With the help of This Method we can add  new Vender
		Connection conn = null;
		try {
			conn = DButils.connectToDatabase();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		user.setPassword(hashingPassword.hashingAlgorithem(user.getPassword()));
		if(emailValidation.emailValidation(user.getUsername())=="Invalid") {
			throw new CredentialException("Wrong email address plese provide right syntax of email.");
		}
		try {
			PreparedStatement ps=conn.prepareStatement("Insert into user(username,password,usertype) values(?,?,?)");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setInt(3, user.getUserType());
			ps.executeUpdate();
			System.out.println("New Vendor Added!");
		} catch (SQLException e) {
			System.out.println("Error: Vendor Not Added!");
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<User> GetAllVendors(){
//		This Methods is for getting all the Venders from database
		List<User> list=new ArrayList<>();
		Connection conn = null;
		try {
			conn = DButils.connectToDatabase();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			PreparedStatement ps=conn.prepareStatement("select * from users where user=2");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new User(rs.getInt("userID"),rs.getString("username"),rs.getString("password"),rs.getInt("user")));
			}
			return list;
		} catch (SQLException e) {
			System.out.println("Error: Vendors Not Found!");
			System.out.println(e.getMessage());
		}
		return list;
	}

	@Override
	public void NewTender(Tender t){
//		This Methods is for adding new tender in to the database
		Connection conn = null;
		try {
			conn = DButils.connectToDatabase();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			PreparedStatement ps=conn.prepareStatement("Insert into tenders(name,type,amount,status) values(?,?,?,0)");
			ps.setString(1, t.getName());
			ps.setString(2, t.getType());
			ps.setInt(3, t.getAmount());
			ps.executeUpdate();
			System.out.println("New Tender Added!");
		} catch (SQLException e) {
			System.out.println("Error: New Tender Not Added!");
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<Tender> GetAllTenders(){
//		This Methods is for getting all the tenders from database

		List<Tender> list=new ArrayList<>();
		Connection conn = null;
		try {
			conn = DButils.connectToDatabase();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			PreparedStatement ps=conn.prepareStatement("select * from tenders");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new Tender(rs.getInt("ID"),rs.getString("name"),rs.getString("type"),rs.getInt("amount"),rs.getInt("bidPrice"),rs.getInt("status"),rs.getInt("vendorID")));
			}
			return list;
		} catch (SQLException e) {
			System.out.println("Error: Tenders Not Found!");
			System.out.println(e.getMessage());
			
		}
		return list;
	}

	@Override
	public List<Bid> GetAllBids(int id) {
//		This Methods is for getting all the bids from the database

		List<Bid> list=new ArrayList<>();
		Connection conn = null;
		try {
			conn = DButils.connectToDatabase();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			PreparedStatement ps=conn.prepareStatement("select * from bids where tenderID=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new Bid(rs.getInt("tenderID"),rs.getInt("vendorID"),rs.getInt("bidPrice")));
			}
			return list;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

	@Override
	public int[] MaxBid(int id) {
		int[] arr=new int[2];
		Connection conn = null;
		try {
			conn = DButils.connectToDatabase();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			PreparedStatement ps=conn.prepareStatement("select vendorID,bidPrice from bids where tenderID=? order by bidPrice DESC LIMIT 1");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				arr[0]=rs.getInt("vendorID");
				arr[1]=rs.getInt("bidPrice");
			}
			return arr;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return arr;
	}

	@Override
	public void AssignTender(int Tid, int Vid, int bidPrice) {
//		This Methods is assigning tender to the venders

		Connection conn = null;
		try {
			conn = DButils.connectToDatabase();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try(PreparedStatement ps=conn.prepareStatement("update tenders set vendorID=?,bidPrice=?,status=1 where ID=? AND status=0")) {
			ps.setInt(1, Vid);
			ps.setInt(2, bidPrice);
			ps.setInt(3, Tid);
			int i=ps.executeUpdate();
			if(i==1) {
				System.out.println("Tender "+Tid+" Assigned To Vendor "+Vid+" At Price "+bidPrice);
			}else {
				System.out.println("Error: Tender Not Found");
			}
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
		
	}
	
	
	
	@Override
	public void DeleteTender(int Tid) {
//		This Method is for deleting the Tenders by id

		Connection conn = null;
		try {
			conn = DButils.connectToDatabase();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			PreparedStatement ps=conn.prepareStatement("delete from tenders where ID=? AND status=0");
			ps.setInt(1, Tid);
			int i=ps.executeUpdate();
			if(i==1) {
				System.out.println("Tender Deleted Successfully!");
			}else {
				System.out.println("Error: Tender Not Found/Can't Be Deleted");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void DeleteVendor(int Vid) {
//		This Method is for deleting the Venders by id

		Connection conn = null;
		try {
			conn = DButils.connectToDatabase();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			PreparedStatement ps=conn.prepareStatement("delete from users where userID=? AND user=2");
			ps.setInt(1, Vid);
			int i=ps.executeUpdate();
			if(i==1) {
				System.out.println("Vendor Deleted Successfully!");
			}else {
				System.out.println("Error: Vendor Not Found");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void DeleteBid(int tid, int vid) {
//		This Method is for deleting the Bid

		Connection conn = null;
		try {
			conn = DButils.connectToDatabase();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			PreparedStatement ps=conn.prepareStatement("delete from Bids where vendorID=? AND tenderID=?");
			ps.setInt(1, vid);
			ps.setInt(2, tid);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	@Override
	public void DeleteBidByTid(int tid) {
//		This Method is for deleting the Bid by Tenerid

		Connection conn = null;
		try {
			conn = DButils.connectToDatabase();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			PreparedStatement ps=conn.prepareStatement("delete from Bids where tenderID=?");
			ps.setInt(2, tid);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void DeleteBidByVid(int vid) {
//		This Method is for deleting the Bid by venerid

		Connection conn = null;
		try {
			conn = DButils.connectToDatabase();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			PreparedStatement ps=conn.prepareStatement("delete from Bids where vendorID=?");
			ps.setInt(1, vid);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void PlaceBid(int tid,int vid,int amount) {
//		This Method is for dPLACING the bid for tender

		Connection conn = null;
		try {
			conn = DButils.connectToDatabase();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			PreparedStatement ps=conn.prepareStatement("insert into bids(tenderID,vendorID,bidPrice) values(?,?,?)");
			ps.setInt(1, tid);
			ps.setInt(2, vid);
			ps.setInt(3, amount);
			ps.executeUpdate();
			System.out.println("Bid Placed");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<Tender> OpenTenders() {
//		This Method is for getting tender

		List<Tender> list=new ArrayList<>();
		Connection conn = null;
		try {
			conn = DButils.connectToDatabase();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			PreparedStatement ps=conn.prepareStatement("select * from tenders where status=0");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new Tender(rs.getInt("ID"),rs.getString("name"),rs.getString("type"),rs.getInt("amount"),rs.getInt("bidPrice"),rs.getInt("status"),rs.getInt("vendorID")));
			}
			return list;
		} catch (SQLException e) {
			System.out.println("Error: Tenders Not Found!");
			System.out.println(e.getMessage());
			
		}
		return list;
	}

	@Override
	public List<Bid> AllBidsOfVendor(int tid,int vid) {
//		This Method is for getting all the Bids of vender

		List<Bid> list=new ArrayList<>();
		Connection conn = null;
		try {
			conn = DButils.connectToDatabase();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			PreparedStatement ps=conn.prepareStatement("select * from bids where tenderID=? AND vendorID=?");
			ps.setInt(1, tid);
			ps.setInt(2, vid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new Bid(rs.getInt("tenderID"),rs.getInt("vendorID"),rs.getInt("bidPrice")));
			}
			return list;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

	@Override
	public List<Tender> AllTendersOfVendor(int id) {
//		This Method is for getting all the tenders

		List<Tender> list=new ArrayList<>();
		Connection conn = null;
		try {
			conn = DButils.connectToDatabase();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			PreparedStatement ps=conn.prepareStatement("select * from tenders where vendorID=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new Tender(rs.getInt("ID"),rs.getString("name"),rs.getString("type"),rs.getInt("amount"),rs.getInt("bidPrice"),rs.getInt("status"),rs.getInt("vendorID")));
			}
			return list;
		} catch (SQLException e) {
			System.out.println("Error: Tenders Not Found!");
			System.out.println(e.getMessage());
			
		}
		return list;
	}

}
