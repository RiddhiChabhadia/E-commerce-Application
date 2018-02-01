package com.riddhi.spring.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import com.riddhi.spring.exception.SupplierException;
import com.riddhi.spring.pojo.Product;
import com.riddhi.spring.pojo.Supplier;

public class SupplierDAO extends DAO {
	
	

	
	  public Supplier create(Supplier sup)
	          throws SupplierException   {
	        try {
	            begin();            
	            getSession().save(sup);     
	            commit();
	            return sup;
	        } catch (HibernateException e) {
	            rollback();
	            //throw new AdException("Could not create advert", e);
	            throw new SupplierException("Exception while creating Supplier: " + e.getMessage());
	        }
	    }
	  
	   public List<Supplier> list() throws SupplierException {
	        try {
	            begin();
	            Query q = getSession().createQuery("from Supplier where activated=false");
	            List<Supplier> list = q.list();
	            commit();
	            return list;
	        } catch (HibernateException e) {
	            rollback();
	            throw new SupplierException("Could not list the Supplier", e);
	        }
	    }
	  
	  public Supplier get(String username, String password) throws SupplierException {
			try {
				begin();
				Query q = getSession().createQuery("from Supplier where username = :username and password = :password");
				q.setString("username", username);
				q.setString("password", password);			
				Supplier supplier = (Supplier) q.uniqueResult();
				commit();
				return supplier;
			} catch (HibernateException e) {
				rollback();
				throw new SupplierException("Could not get user " + username, e);
			}
		}
	  
	  
	  
	  
	  public void update(int id) throws SupplierException {
			try {
				begin();
				Query q = getSession().createQuery("update Supplier set activated=:activated where supplierID=:id");
				q.setBoolean("activated",true);
				q.setInteger("id",id);
                q.executeUpdate();
				commit();
				
			} catch (HibernateException e) {
				rollback();
				throw new SupplierException("Could not update supplier " , e);
			}
		}

	    public void delete(Supplier product)
	            throws SupplierException {
	        try {
	            begin();
	            getSession().delete(product);
	            commit();
	        } catch (HibernateException e) {
	            rollback();
	            throw new SupplierException("Could not delete Supplier", e);
	        }
	    }

	    
	    
	 
	    
	    

}
