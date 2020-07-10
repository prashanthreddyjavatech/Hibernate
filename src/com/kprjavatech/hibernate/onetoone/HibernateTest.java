package com.kprjavatech.hibernate.onetoone;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.kprjavatech.hibernate.util.HibernateUtil;

public class HibernateTest {
	
	public static void main(String[] args) {
		 Employee emp=new Employee();    
		    emp.setName("James");    
		    emp.setEmail("james@kprjavatech.com");    
		        
		    Address address1=new Address();    
		    address1.setStreet("14,VIP");    
		    address1.setCity("Hyderabad");    
		    address1.setState("TS");    
		    address1.setCountry("India");    
		    address1.setPincode(500090);    
		        
		    emp.setAddress(address1);   
		    address1.setEmployee(emp);   
		    
			Session sessionObj = HibernateUtil.getSessionFactory().openSession();
		    Transaction transaction=sessionObj.beginTransaction(); 
		    sessionObj.save(emp);
		    transaction.commit();    
		    sessionObj.close();
	}

}
