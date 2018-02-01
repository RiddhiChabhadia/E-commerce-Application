package com.riddhi.spring.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.riddhi.spring.exception.CartException;
import com.riddhi.spring.exception.ProductException;
import com.riddhi.spring.pojo.Address;
import com.riddhi.spring.pojo.Cart;
import com.riddhi.spring.pojo.Product;

public class CartDAO extends DAO{
	

	  public Cart create(Cart cart)
	          throws CartException   {
	        try {
	            begin();  
	          
	            getSession().save(cart);     
	            commit();
	            return cart;
	        } catch (HibernateException e) {
	            rollback();
	            //throw new AdException("Could not create advert", e);
	            throw new CartException("Exception while creating Cart: " + e.getMessage());
	        }
	    }

	    public void delete(int product,long customer)
	            throws CartException {
	        try {
	            begin();
	            Query q=getSession().createQuery("delete Cart where customer= :customer and product=:product");
	            q.setLong("customer",customer);
	            q.setInteger("product", product);
	            q.executeUpdate();
	            commit();
	        } catch (HibernateException e) {
	            rollback();
	            throw new CartException("Could not delete Cart", e);
	        }
	    }

	    
	    public List<Cart> get(long customer) throws  CartException {
	        try {
	            begin();
	            Query q=getSession().createQuery("from Cart where customer= :customer");
	            q.setLong("customer",customer);
	            List<Cart> list = q.list();
	           
	            commit();
	            return list;
	        } catch (HibernateException e) {
	            rollback();
	            throw new CartException("Could not obtain the named Cart " );
	        }
	    }
	    
	    public Cart get1(long customer,int product) throws  CartException {
	        try {
	            begin();
	            Query q=getSession().createQuery("from Cart where customer= :customer and product=:product");
	            q.setLong("customer",customer);
	            q.setInteger("product", product);
	            Cart cart = (Cart) q.uniqueResult();
	           
	            commit();
	            return cart;
	        } catch (HibernateException e) {
	            rollback();
	            throw new CartException("Could not obtain the named Cart " );
	        }
	    }
	    
	    
	    
	    
	    public void update(long customer,int qunatity,int product) throws CartException {
	        try {
	            begin();
	            System.out.println("cart dao");
	            Query q = getSession().createQuery("update Cart set quantity=:quantity where customer=:customer and product=:product");
	            q.setLong("customer", customer);
	            q.setInteger("quantity", qunatity);
	            q.setInteger("product", product);
	           q.executeUpdate();
	            commit();
	        } catch (HibernateException e) {
	            rollback();
	            throw new CartException("Could not save the cart", e);
	        }
	    }   

	    
	    
	    
}
