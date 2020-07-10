package com.kprjavatech.hibernate.tps;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.kprjavatech.hibernate.util.HibernateUtil;

public class EmployeeTest {
	public static void main(String[] args) {
		Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        
        Transaction transaction=sessionObj.beginTransaction();    
           
           Employee e1=new Employee();    
           e1.setName("John");    
               
           RegularEmployee e2=new RegularEmployee();    
           e2.setName("Jeff");    
           e2.setSalary(100000);    
           e2.setBonus(10);    
               
           ContractEmployee e3=new ContractEmployee();    
           e3.setName("James");    
           e3.setPay_per_hour(5000);    
           e3.setContract_duration("10 hours");    
               
           sessionObj.persist(e1);    
           sessionObj.persist(e2);    
           sessionObj.persist(e3);    
               
           transaction.commit();    
           sessionObj.close();    
           System.out.println("Exceution done successfully");     
	}

}
