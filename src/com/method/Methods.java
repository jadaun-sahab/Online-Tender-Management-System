package com.method;

import java.util.List;

import com.models.Bid;
import com.models.tender;
import com.models.user;

public interface Methods {
	public void login(String username,String password);
	public void NewVendor(user User);
	public List<user> getAllVendors();
	public void NewTender(tender t);
	public List<tender> getAllTenders();
	public List<Bid> getAllBids(int id);
	public int[] MaxBid(int id);
	public void assignTender(int Tid,int Vid,int bidPrice);
	public void deleteBidByTid(int tid);
	public void deleteBidByVid(int vid);
	public void deleteBid(int tid,int vid);
	public void deleteTender(int Tid);
	public void deleteVendor(int Vid);
	public List<tender> openTenders();
	public void placeBid(int tid,int vid,int amount);
	public List<Bid> AllBidsOfVendor(int tid,int vid);
	public List<tender> AllTendersOfVendor(int id);
}
