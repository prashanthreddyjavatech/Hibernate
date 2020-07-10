package com.kprjavatech.hibernate.collection;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.kprjavatech.hibernate.util.HibernateUtil;

public class HibernateTest {
	
public static void main(String[] args) {
	
	Session sessionObj = HibernateUtil.getSessionFactory().openSession();
    
    Transaction transaction=sessionObj.beginTransaction();  
    
	Set<Items> itemsSet = new HashSet<Items>();
	for(int i=1;i<=20;i++) {
	Items items=new Items();
	items.setItemId(i);
	items.setItemName("item name"+i);
	items.setItemPrice(50*i);
	itemsSet.add(items);
	}
	
	Cart cart=new Cart();
	cart.setId(1);
	cart.setName("cart1");
	cart.setListOfItems(itemsSet);
	
	sessionObj.save(cart);
	
	
    transaction.commit();    
    sessionObj.close();    
    System.out.println("Exceution done successfully");
	
}
}
