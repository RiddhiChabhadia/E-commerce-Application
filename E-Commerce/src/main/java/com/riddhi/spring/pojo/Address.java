package com.riddhi.spring.pojo;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="AddressId", unique = true, nullable = false)	
private	int id;
	@Column(name="addressLine1")
private	String addressLine1;
	@Column(name="addressLine2")
private	String addressLine2;
	@Column(name="city")
private	String city;
	@Column(name="state")
private	String state;
	@Column(name="country")
private	String country;
	@Column(name="postalCode")
private	int postalCode;
	@Column(name="addressType")
	private String addressType;
	
	
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="supplierid_fk")
	private Supplier supplier;
	

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="customerid_fk")
	private Customer customer;
	


public Address(){}


public Address(String addressLine1, String addressLine2, String city, String state, String country, int postalCode,
		String addressType, Supplier supplier, Customer customer) {
	super();
	this.addressLine1 = addressLine1;
	this.addressLine2 = addressLine2;
	this.city = city;
	this.state = state;
	this.country = country;
	this.postalCode = postalCode;
	this.addressType = addressType;
	this.supplier = supplier;
	this.customer = customer;
}











public Customer getCustomer() {
	return customer;
}











public void setCustomer(Customer customer) {
	this.customer = customer;
}











public Supplier getSupplier() {
	return supplier;
}





public void setSupplier(Supplier supplier) {
	this.supplier = supplier;
}





public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}






public String getAddressType() {
	return addressType;
}





public void setAddressType(String addressType) {
	this.addressType = addressType;
}





public String getAddressLine1() {
	return addressLine1;
}

public void setAddressLine1(String addressLine1) {
	this.addressLine1 = addressLine1;
}

public String getAddressLine2() {
	return addressLine2;
}

public void setAddressLine2(String addressLine2) {
	this.addressLine2 = addressLine2;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}

public int getPostalCode() {
	return postalCode;
}

public void setPostalCode(int postalCode) {
	this.postalCode = postalCode;
}







}
