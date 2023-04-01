package com.administrator;

import java.util.Scanner;

import com.method.Methods;
import com.method.Methods_Impl;
import com.models.tender;


public class newTender {
	public void addnewTender(int id){
		Methods m=new Methods_Impl();
		
		Scanner sc=new Scanner(System.in);
		System.out.println(":---------------------------: Add New Tender");
		System.out.print("Name      : ");
		String name=sc.next();
		System.out.print("type      : ");
		String type=sc.next();
		System.out.print("Amount    : ");
		int amount=sc.nextInt();
		tender t=new tender(0,name,type,amount,0,0,0);
		m.NewTender(t);
		AdminMenu a=new AdminMenu();
		a.Amenu(id);
	}
}
