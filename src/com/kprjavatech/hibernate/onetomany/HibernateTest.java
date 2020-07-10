package com.kprjavatech.hibernate.onetomany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.kprjavatech.hibernate.util.HibernateUtil;

public class HibernateTest {
	public static void main(String[] args) {
		Cart cart = new Cart();
		cart.setName("MyCart");
		
		Items item1 = new Items("I10", 10, 1, cart);
		Items item2 = new Items("I20", 20, 2, cart);
		Set<Items> itemsSet = new HashSet<Items>();
		itemsSet.add(item1); itemsSet.add(item2);
		
		cart.setItems(itemsSet);
		cart.setTotal(10*1 + 20*2);
		
		Session sessionObj = HibernateUtil.getSessionFactory().openSession();
	    
	    Transaction transaction=sessionObj.beginTransaction(); 
	    
	    sessionObj.save(cart);
	    sessionObj.save(item1);
	    sessionObj.save(item2);
	    
	    transaction.commit();
	    sessionObj.close();
	}

}
