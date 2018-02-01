package com.riddhi.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;

import com.riddhi.spring.exception.OrderException;


import com.riddhi.spring.pojo.OrderDetail;


public class OrderDAO extends DAO {
	
	
	  public OrderDetail create(OrderDetail oh)
	          throws OrderException   {
	     //  try {
	            begin();  
	          
	            getSession().save(oh);     
	            commit();
	            return oh; 
//	        } catch (HibernateException e) {
//	            rollback();
//	            //throw new AdException("Could not create advert", e);
//	            throw new OrderException("Exception while creating Order: " + e.getMessage());
//	        }
	    }

	    public void delete(OrderDetail oh)
	            throws OrderException {
	        try {
	            begin();
	            getSession().delete(oh);
	            commit();
	        } catch (HibernateException e) {
	            rollback();
	            throw new OrderException("Could not delete Order", e);
	        }
	    }
	    
	    
	    public int createId() throws OrderException {
	    	
	    	try {
	            begin();
	            Criteria criteria = getSession()
	            	    .createCriteria(OrderDetail.class)
	            	    .setProjection(Projections.max("orderId"));
	            
	            	Integer max = (Integer)criteria.uniqueResult();
	            	System.out.println("inside id   max value"+max);
	            	if(max==0 || max==null){return 1;}
	           	return max;
	        } catch (HibernateException e) {
	            rollback();
	            throw new OrderException("Could not list the Order");
	        }
	 
	    }
	    
	    	
	  
	    

	    
	    
	    
	    
	    
	    public List<OrderDetail> list() throws OrderException {
	        try {
	            begin();
	            Query q = getSession().createQuery("from OrderDetail ");
	            List<OrderDetail> list = q.list();
	            commit();
	            return list;
	        } catch (HibernateException e) {
	            rollback();
	            throw new OrderException("Could not list the Order", e);
	        }
	    }
	    
	    
	    

	    public List<OrderDetail> get(long customer) throws OrderException {
	        try {
	            begin();
	            Query q=getSession().createQuery("from OrderDetail where customer= :customer");
	            q.setLong("customer",customer);
	            List<OrderDetail> list = q.list(); 
	            commit();
	            return list;
	        } catch (HibernateException e) {
	            rollback();
	            throw new OrderException("Could not obtain the named Order " );
	        }
	    }
	    
	    
	    public List<OrderDetail> getCust(int orderId,long customer) throws OrderException {
	        try {
	            begin();
	            Query q=getSession().createQuery("from OrderDetail where orderId= :orderId");
	            q.setInteger("orderId",orderId);
	            List<OrderDetail> list = q.list(); 
	            commit();
	            return list;
	        } catch (HibernateException e) {
	            rollback();
	            throw new OrderException("Could not obtain the named Order " );
	        }
	    }

}
