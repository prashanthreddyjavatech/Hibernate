package com.kprjavatech.hibernate.cache;

import org.hibernate.Session;

import com.kprjavatech.hibernate.util.HibernateUtil;

public class HibernateTest {
public static void main(String[] args) {
	Session sessionObj1 = HibernateUtil.getSessionFactory().openSession();    
    Employee emp1=(Employee)sessionObj1.load(Employee.class,1);    
    System.out.println(emp1.getId()+" "+emp1.getName()+" "+emp1.getSalary());    
    sessionObj1.close();    
        
    Session sessionObj2 = HibernateUtil.getSessionFactory().openSession();    
    Employee emp2=(Employee)sessionObj2.load(Employee.class,1);    
    System.out.println(emp2.getId()+" "+emp2.getName()+" "+emp2.getSalary());    
    sessionObj2.close(); 
}
}
