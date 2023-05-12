package com.models;

public class Tender {
	int id;
	String name;
	String type;
	int amount;
	int bidPrice;
	int status;
	int vid;
	public Tender(int id, String name, String type, int amount, int bidPrice, int status, int vid) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.amount = amount;
		this.bidPrice = bidPrice;
		this.status = status;
		this.vid = vid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(int bidPrice) {
		this.bidPrice = bidPrice;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
}
