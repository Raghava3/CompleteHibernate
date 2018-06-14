package com.rbl.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.raghava.dto.Address;
import com.raghava.dto.UserDetails;

public class Operation {
	
	
	public static void main(String[] args)
	{
//creating user object
		UserDetails details=new UserDetails();

//creating Address object 
		Address homeAddress=new Address();
		homeAddress.setCity("Bengaluru");
		homeAddress.setState("karnataka");
		homeAddress.setStreet("kumravyasroad");
		
//creating Address object
		Address officeAddress=new Address();
		officeAddress.setCity("bengaluru");
		officeAddress.setState("karnatakta");
		officeAddress.setStreet("richmond");
		
//setting user object	
		details.setUserName("SecondUser");
		details.setHomeAddress(homeAddress);
		details.setOfficeAddress(officeAddress);
		
//creating sessionFctory		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();

//open session
		Session session=sessionFactory.openSession();

//begin transaction		
		session.beginTransaction();

//save in to database		
		session.save(details);
        session.getTransaction().commit();
        session.close();
        
        details=null;
        
        session=sessionFactory.openSession();
        session.beginTransaction();
        details=(UserDetails) session.get(UserDetails.class,1);
        System.out.println(details.getUserName()+" "+details.getUserId());
        
		
	}

}
