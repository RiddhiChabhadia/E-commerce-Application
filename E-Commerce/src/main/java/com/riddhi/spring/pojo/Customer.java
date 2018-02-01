package com.riddhi.spring.pojo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Customer")
public class Customer {
	
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "customerID", unique=true, nullable = false)
	private long customerID;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name ="lastName")
	private String lastName;
	
	@OneToMany(mappedBy="customer",cascade=CascadeType.ALL)
	private Collection<Address> customerAddress= new ArrayList<Address>();
	
	
	@Column(name = "username", unique=true, nullable=false)
	private String username;

	@Column(name = "password" ,unique=true, nullable=false)
	private String password;
	
	
	@Column(name="email")
	private String email;
	
	@Column(name="phoneNo")
	private int phonenNo;
	

	
	
	
	 @OneToMany(mappedBy = "customer" , cascade = CascadeType.ALL)
	   private Collection<Cart> cart = new ArrayList<Cart>();
	
	 @OneToMany(mappedBy = "customer" , cascade = CascadeType.ALL)
	   private Collection<OrderDetail> order = new ArrayList<OrderDetail>();
	
public	Customer(){}




public Collection<OrderDetail> getOrder() {
	return order;
}




public void setOrder(Collection<OrderDetail> order) {
	this.order = order;
}




public Collection<Cart> getCart() {
	return cart;
}




public void setCart(Collection<Cart> cart) {
	this.cart = cart;
}



public long getCustomerID() {
	return customerID;
}


public void setCustomerID(long customerID) {
	this.customerID = customerID;
}


public String getFirstName() {
	return firstName;
}


public void setFirstName(String firstName) {
	this.firstName = firstName;
}


public String getLastName() {
	return lastName;
}


public void setLastName(String lastName) {
	this.lastName = lastName;
}


public Collection<Address> getCustomerAddress() {
	return customerAddress;
}


public void setCustomerAddress(Collection<Address> customerAddress) {
	this.customerAddress = customerAddress;
}


public String getUsername() {
	return username;
}


public void setUsername(String username) {
	this.username = username;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public int getPhonenNo() {
	return phonenNo;
}


public void setPhonenNo(int phonenNo) {
	this.phonenNo = phonenNo;
}









}
