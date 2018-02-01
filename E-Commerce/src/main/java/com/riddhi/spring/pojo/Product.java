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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.commons.CommonsMultipartFile;



@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="productId", unique = true, nullable = false)
	int productId;

	
	@Column(name="productName")
	String productName;
	
	@Column(name="productAvailability")
	int productAvailability;
	
	@Column(name="modelNo")
	String modelNo;
		
	
	@Column(name="price")
	float price;
	
	
	@Column(name="description")
	String description;
	
	
	@Column(name="active")
	boolean active;
	
	@ManyToOne
	@JoinColumn(name = "supplier_fk")  
     private Supplier supplier;
	 
	@OneToMany(mappedBy = "product")
	   private Collection<Cart> cart = new ArrayList<Cart>();

	
	@OneToMany(mappedBy = "product")
	   private Collection<OrderDetail> order = new ArrayList<OrderDetail>();
	
	@OneToMany(mappedBy="prod", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<Photo> proPhotos=new HashSet<Photo>();

	

	@Transient
	private Set<CommonsMultipartFile> photo = new HashSet<CommonsMultipartFile>();
	

	
	
	
	public Product(){}
	
	
	
	
	
	
	public String getDescription() {
		return description;
	}






	public void setDescription(String description) {
		this.description = description;
	}






	public boolean isActive() {
		return active;
	}




	public void setActive(boolean active) {
		this.active = active;
	}




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



	public Set<CommonsMultipartFile> getPhoto() {
		return photo;
	}

	public void setPhoto(Set<CommonsMultipartFile> photo) {
		this.photo = photo;
	}


	public void setProPhotos(Set<Photo> proPhotos) {
		this.proPhotos = proPhotos;
	}

	public Set<Photo> getProPhotos() {
		return proPhotos;
	}




	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductAvailability() {
		return productAvailability;
	}

	public void setProductAvailability(int productAvailability) {
		this.productAvailability = productAvailability;
	}

	public String getModelNo() {
		return modelNo;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}



}
