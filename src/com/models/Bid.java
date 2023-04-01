package com.models;

public class Bid {
	int Tid;
	int Vid;
	int bidAmount;
	public Bid(int tid, int vid, int bidAmount) {
		super();
		Tid = tid;
		Vid = vid;
		this.bidAmount = bidAmount;
	}
	public int getTid() {
		return Tid;
	}
	public void setTid(int tid) {
		Tid = tid;
	}
	public int getVid() {
		return Vid;
	}
	public void setVid(int vid) {
		Vid = vid;
	}
	public int getBidAmount() {
		return bidAmount;
	}
	public void setBidAmount(int bidAmount) {
		this.bidAmount = bidAmount;
	}
}
