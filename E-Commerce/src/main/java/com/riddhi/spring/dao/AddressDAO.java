package com.riddhi.spring.dao;

import org.hibernate.HibernateException;

import com.riddhi.spring.exception.AddressException;
import com.riddhi.spring.pojo.Address;


public class AddressDAO extends DAO{
	

	  public Address create(Address address)
	          throws AddressException   {
	        try {
	            begin();  
	          
	            getSession().save(address);     
	            commit();
	            return address;
	        } catch (HibernateException e) {
	            rollback();
	            //throw new AdException("Could not create advert", e);
	            throw new AddressException("Exception while creating Address: " + e.getMessage());
	        }
	    }

	    public void delete(Address address)
	            throws AddressException {
	        try {
	            begin();
	            getSession().delete(address);
	            commit();
	        } catch (HibernateException e) {
	            rollback();
	            throw new AddressException("Could not delete Address", e);
	        }
	    }


}
