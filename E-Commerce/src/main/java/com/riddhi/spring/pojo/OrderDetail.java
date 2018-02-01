package com.riddhi.spring.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "OrderDetail")
public class OrderDetail implements Serializable{
	
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "orderId", nullable = false)
	private int orderId;
	
	
	 @Id
	   @ManyToOne
	   @JoinColumn(name="customerID")
	   private Customer customer;
	   
	  @Id
	   @ManyToOne
	   @JoinColumn(name="productId")
	   private Product product;
	  
	   @Column(name="quantity")
	   private int quantity;
	   
	   @Column(name="orderDate")
	   private Date orderDate;
	   
	   private int total;
	   
	   
	   public OrderDetail(){}


	   
	   
	   
	   
	public int getTotal() {
		return total;
	}






	public void setTotal(int total) {
		this.total = total;
	}






	public Date getOrderDate() {
		return orderDate;
	}






	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}






	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	   
	   
	   
}
