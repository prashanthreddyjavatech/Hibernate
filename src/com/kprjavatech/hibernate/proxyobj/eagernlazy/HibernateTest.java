package com.kprjavatech.hibernate.proxyobj.eagernlazy;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.kprjavatech.hibernate.util.HibernateUtil;

public class HibernateTest {
	
public static void main(String[] args) {
	
	Session sessionObj = HibernateUtil.getSessionFactory().openSession();
    
    Transaction transaction=sessionObj.beginTransaction();  
    
	List<Items> listItems = new ArrayList<Items>();
	for(int i=1;i<=20;i++) {
	Items items=new Items();
	items.setItemId(i);
	items.setItemName("item name"+i);
	items.setItemPrice(50*i);
	listItems.add(items);
	}
	
	Cart cart=new Cart();
	cart.setId(1);
	cart.setName("cart1");
	cart.setListOfItems(listItems);
	
	sessionObj.save(cart);
	
	
    transaction.commit();    
    sessionObj.close();    
    System.out.println("Exceution done successfully");
	
    
    // Proxy Objects and Eager and Lazy Fetch Types
    
    sessionObj=HibernateUtil.getSessionFactory().openSession();
     cart=null;
     cart=(Cart)sessionObj.get(Cart.class, 1);
    sessionObj.close(); //org.hibernate.LazyInitializationException occur due to lazy loading through proxy, if we wont mention annotation eager on collection
    System.out.println(cart.getListOfItems().size());
    
    
    
}
}
