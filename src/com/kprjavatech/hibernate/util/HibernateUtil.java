package com.kprjavatech.hibernate.util;


import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	 private static SessionFactory sessionFactory;
     
	    public static SessionFactory getSessionFactory() {
	        if (sessionFactory == null) {
	            // loads configuration and mappings
	        	 ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
	        	    Metadata meta = new MetadataSources(serviceRegistry).getMetadataBuilder().build(); 
	        	    
	        	    //getting SessionFactory object
	        	    sessionFactory=  meta.getSessionFactoryBuilder().build();  
	        }
	         
	        return sessionFactory;
	    }
}
