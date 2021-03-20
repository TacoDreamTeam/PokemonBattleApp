package com.revature.models;

import org.hibernate.Session;

import com.revature.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {
		System.out.println("starting session");
		Session ses1=HibernateUtil.getSession();

		
	}

}
