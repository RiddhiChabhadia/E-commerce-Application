


package com.riddhi.spring.pojo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="Supplier")
public class Supplier {
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "supplierID", unique=true, nullable = false)
	private long supplierID;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name ="lastName")
	private String lastName;
	
	@OneToMany(mappedBy="supplier")
	private Collection<Address> supplierAddress= new ArrayList<Address>();
	
	
	@Column(name = "username",unique=true)
	private String username;

	@Column(name = "password",unique=true)
	private String password;
	
	
	@OneToMany(mappedBy="supplier")
	private Collection<Product> supplierProductList=new ArrayList<Product>();
	
	
	@Column(name="activated")
	private boolean activated;
		
	public Supplier(){}

	
	

	public Supplier(String firstName, String lastName, Collection<Address> supplierAddress, String username,
			String password, Collection<Product> supplierProductList) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.supplierAddress = supplierAddress;
		this.username = username;
		this.password = password;
		this.supplierProductList = supplierProductList;
	}




	public boolean isActivated() {
		return activated;
	}




	public void setActivated(boolean activated) {
		this.activated = activated;
	}




	public long getSupplierID() {
		return supplierID;
	}




	public void setSupplierID(long supplierID) {
		this.supplierID = supplierID;
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


	public Collection<Address> getSupplierAddress() {
		return supplierAddress;
	}


	public void setSupplierAddress(Collection<Address> supplierAddress) {
		this.supplierAddress = supplierAddress;
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


	public Collection<Product> getSupplierProductList() {
		return supplierProductList;
	}


	public void setSupplierProductList(Collection<Product> supplierProductList) {
		this.supplierProductList = supplierProductList;
	}
	
	

	
	

	
	
	
	
	
}
