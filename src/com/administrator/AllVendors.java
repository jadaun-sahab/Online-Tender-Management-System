package com.administrator;

import java.util.List;

import com.method.Methods;
import com.method.Methods_Impl;
import com.models.user;


public class AllVendors {
	public void getVendors(int id){
		System.out.println(":------------------------------: All Vendors");
		Methods m=new Methods_Impl();
		List<user> list=m.getAllVendors();
		for(user i:list) {
			System.out.println("Vendor ID      : "+i.getId());
			System.out.println("Vendor Name    : "+i.getUsername());
			System.out.println("Vendor Password: "+i.getPassword());
			System.out.println(":------------------------------------------:");
		}
		AdminMenu a=new AdminMenu();
		a.Amenu(id);
	}
}
