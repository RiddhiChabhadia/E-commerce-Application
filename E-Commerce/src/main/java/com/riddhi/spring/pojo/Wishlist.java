package com.riddhi.spring.pojo;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="wishList")

public class Wishlist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="wishListId", unique = true, nullable = false)
	 int id;
	
	@Column(name="wquantity")
	private int wquantity;
	
	@Column(name="totalPrice")
	private double totalPrice;
	
	@OneToOne
	private Customer customer;
	
	
	
	@ManyToMany
	private Collection<Product> productWishList=new ArrayList<Product>();
	
	
}
