package com.administrator;

import java.util.List;

import com.exception.CredentialException;
import com.exception.TenderException;
import com.method.Methods;
import com.method.Methods_Impl;
import com.models.User;


public class AllVendors {
//	This Methods is for getting all the Venders which are available

	public void getVendors(int id) throws TenderException, CredentialException{
		System.out.println(":------------------------------: All Vendors");
		Methods methods_implemen=new Methods_Impl();
		List<User> list=methods_implemen.GetAllVendors();
		for(User i:list) {
			System.out.println("Vendor ID      : "+i.getId());
			System.out.println("Vendor Name    : "+i.getUsername());
			System.out.println("Vendor Password: "+i.getPassword());
			System.out.println(":------------------------------------------:");
		}
		AdminMenu admin_menu=new AdminMenu();
		admin_menu.Amenu(id);
	}
}
