package com.administrator;

import java.util.Scanner;

import com.method.Methods;
import com.method.Methods_Impl;



public class AutoAssignTender {
	public void getMaxBid(int id){
		System.out.println(":---------------------------: Assign Tender");
		Methods m=new Methods_Impl();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter TenderID: ");
		int Tid=sc.nextInt();
		int[] arr=m.MaxBid(Tid);
		if(arr.length!=0) {
			int Vid=arr[0];
			int BidPrice=arr[1];
			m.assignTender(Tid, Vid, BidPrice);
		}
		AdminMenu a=new AdminMenu();
		a.Amenu(id);
	}
}
