package com.kprjavatech.hibernate.proxyobj.eagernlazy;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

@Entity
@Table(name="CART")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="ITEMS",
	joinColumns = @JoinColumn(name="CART_ASSIGN_NO")
	)
	Collection<Items> listOfItems=new ArrayList<Items>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Items> getListOfItems() {
		return listOfItems;
	}

	public void setListOfItems(Collection<Items> listOfItems) {
		this.listOfItems = listOfItems;
	}


}
