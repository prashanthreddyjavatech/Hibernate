package com.kprjavatech.hibernate.manytomany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.kprjavatech.hibernate.util.HibernateUtil;

public class HibernateTest {
	
	public static void main(String[] args) {
		Item item1 = new Item();
		item1.setDescription("samsung"); item1.setPrice(300);
		Item item2 = new Item();
		item2.setDescription("nokia"); item2.setPrice(200);
		Cart cart = new Cart();
		cart.setTotal(500);
		Set<Item> items = new HashSet<Item>();
		items.add(item1); items.add(item2);
		cart.setItems(items);
		
		Session sessionObj = HibernateUtil.getSessionFactory().openSession();
	    Transaction transaction=sessionObj.beginTransaction(); 
	    sessionObj.save(cart);
	    transaction.commit();
	    sessionObj.close();
	}

}
