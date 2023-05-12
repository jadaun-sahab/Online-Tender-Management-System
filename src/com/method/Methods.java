package com.method;

import java.util.List;

import com.exception.CredentialException;
import com.exception.TenderException;
import com.models.Bid;
import com.models.Tender;
import com.models.User;

public interface Methods {
	public void login(String username,String password) throws TenderException,CredentialException;
	public void NewVendor(User User)throws CredentialException;
	public List<User> GetAllVendors();
	public void NewTender(Tender t);
	public List<Tender> GetAllTenders();
	public List<Bid> GetAllBids(int id);
	public int[] MaxBid(int id);
	public void AssignTender(int Tid,int Vid,int bidPrice);
	public void DeleteBidByTid(int tid);
	public void DeleteBidByVid(int vid);
	public void DeleteBid(int tid,int vid);
	public void DeleteTender(int Tid);
	public void DeleteVendor(int Vid);
	public List<Tender> OpenTenders();
	public void PlaceBid(int tid,int vid,int amount);
	public List<Bid> AllBidsOfVendor(int tid,int vid);
	public List<Tender> AllTendersOfVendor(int id);
}