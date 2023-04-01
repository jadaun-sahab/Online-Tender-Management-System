package com.administrator;

import java.util.Scanner;

import com.method.Methods;
import com.method.Methods_Impl;


public class deleteTender {
	public void deletetender(int id){
		System.out.println(":---------------------------: Delete Tenders");
		Methods m=new Methods_Impl();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter TenderID: ");
		int Tid=sc.nextInt();
		//List<tender> list=m.AllTendersOfVendor(Vid);
		m.deleteBidByTid(Tid);
		m.deleteTender(Tid);
		AdminMenu a=new AdminMenu();
		a.Amenu(id);
	}
}
