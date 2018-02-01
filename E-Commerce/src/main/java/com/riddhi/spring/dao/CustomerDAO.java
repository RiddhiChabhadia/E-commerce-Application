package com.riddhi.spring.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.exception.ConstraintViolationException;

import com.riddhi.spring.exception.CartException;
import com.riddhi.spring.exception.CustomerException;
import com.riddhi.spring.exception.SupplierException;
import com.riddhi.spring.pojo.Cart;
import com.riddhi.spring.pojo.Customer;
import com.riddhi.spring.pojo.Supplier;

public class CustomerDAO extends DAO{
	
	
	
	

	
	  public Customer create(Customer customer)
	          throws CustomerException   {
	      
		  
		 
			  try {
		            begin();            
		            getSession().save(customer);     
		            commit();
		            return customer;
		        }
		       catch (HibernateException e) {
		            rollback();
		            //throw new AdException("Could not create advert", e);
		            throw new CustomerException("Exception while creating customer: " + e.getMessage());
		        }
		  
		  
		 
			
	    }
	  
	  
	  
	  public Customer get(String username, String password) throws CustomerException {
			try {
				begin();
				Query q = getSession().createQuery("from Customer where username = :username and password = :password");
				q.setString("username", username);
				q.setString("password", password);			
				Customer customer = (Customer) q.uniqueResult();
				commit();
				return customer;
			} catch (HibernateException e) {
				rollback();
				throw new CustomerException("Could not get customer " + username, e);
			}
		}

	    public void delete(Customer customer)
	            throws CustomerException {
	        try {
	            begin();
	            getSession().delete(customer);
	            commit();
	        } catch (HibernateException e) {
	            rollback();
	            throw new CustomerException("Could not delete customer", e);
	        }
	    }

	
//	    public User getUser UserCart(long customerID) throws CustomerException {
//		    //    try {
//		    	System.out.println("listcart");
//		            begin();
//		            Query q = getSession().createQuery("from Customer where customerID= :customerID");
//		            q.setLong("customerID", customerID);
//		            List<Cart> list = q.list();
//		            commit();
//		            return list;
////		        } catch (HibernateException e) {
////		            rollback();
////		            throw new CartException("Could not list the Cart", e);
////		        }
//		    }
//		    


}
