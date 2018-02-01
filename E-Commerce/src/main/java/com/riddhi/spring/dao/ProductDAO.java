package com.riddhi.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.riddhi.spring.exception.CartException;
import com.riddhi.spring.exception.ProductException;
import com.riddhi.spring.exception.SupplierException;
import com.riddhi.spring.pojo.Cart;
import com.riddhi.spring.pojo.Photo;
import com.riddhi.spring.pojo.Product;
import com.riddhi.spring.pojo.Supplier;



public class ProductDAO extends DAO{
	
	
	public List<Product> testLike(String ser) throws Exception {
		 System.out.println("product dao");
//		 Product product=new Product();
//		  address.setCountryISO2Code("US");
//		  address.setCity("AT%");
//		  Example addressExample = Example.create(address).enableLike();
		  Criteria criteria = getSession().createCriteria(Product.class);
		  Criterion  name=Restrictions.ilike("productName", ser, MatchMode.ANYWHERE);
		  Criterion tablet = Restrictions.ilike("description", ser, MatchMode.ANYWHERE);
		 // Criterion price=Restrictions.ge("price", ser);
		  Disjunction disjunction = Restrictions.disjunction();
		  //disjunction.add(price);
		  disjunction.add(name);
		  disjunction.add(tablet);
		  criteria.add(disjunction);
		  List<Product> result=criteria.list();
		  return result;
		  
		}
	
	
	
	
	   public Product create(Product product)
	          throws ProductException   {
	        try {
	            begin();            
	            getSession().save(product);     
	            commit();
	            return product;
	        } catch (HibernateException e) {
	            rollback();
	            //throw new AdException("Could not create advert", e);
	            throw new ProductException("Exception while creating product: " + e.getMessage());
	        }
	    }

	   
	   
	   public List<Product> list() throws ProductException {
	        try {
	            begin();
	            System.out.println("product dao list method");
	            Query q = getSession().createQuery("from Product where active=:active ");
	            q.setBoolean("active", true);
	            List<Product> list = q.list();
//	            Criteria crit=getSession().createCriteria(Product.class);
//	            Product product=new Product();
//	            product.setActive(true);
//	            crit.add(Example.create(product));
//	            List<Product> list = crit.list();
//	            System.out.println("inside dao list size"+list.size());
	            commit();
	            return list;
	        } catch (HibernateException e) {
	            rollback();
	            throw new ProductException("Could not list the Product", e);
	        }
	    }
	  
	   
	
	   
	   
	   
	   public List<Product> prolist(Long supplier) throws ProductException {
	        try {
	            begin();
	            Query q = getSession().createQuery("from Product where supplier=:supplier and active=:active");
	            q.setLong("supplier", supplier);
	            q.setBoolean("active", true);
	            List<Product> list = q.list();
	            commit();
	            return list;
	        } catch (HibernateException e) {
	            rollback();
	            throw new ProductException("Could not list the Product", e);
	        }
	    }
	  
	   
	   
	    public void delete(Product product)
	            throws ProductException {
	        try {
	            begin();
	            getSession().delete(product);
	            commit();
	        } catch (HibernateException e) {
	            rollback();
	            throw new ProductException("Could not delete product", e);
	        }
	    }
	
	    
	    public void softdelete(int productId)
	            throws ProductException {
	   //     try {
	        	System.out.println("inside soft delete");
	            begin();
	            Query q=getSession().createQuery("update Product set active=:active where productId= :productId ");
	            q.setBoolean("active", false);
	            q.setInteger("productId", productId);
	            q.executeUpdate();
	            commit();
//	        } catch (HibernateException e) {
//	            rollback();
//	            throw new ProductException("Could not delete product", e);
//	        }
	    }

	    
	    

	    public Product get(int productId) throws ProductException {
	        try {
	            begin();
	            Query q=getSession().createQuery("from Product where productId= :productId and active=:active  ");
	            q.setInteger("productId",productId);
	            q.setBoolean("active", true);
	            Product category=(Product)q.uniqueResult();
	            commit();
	            return category;
	        } catch (HibernateException e) {
	            rollback();
	            throw new ProductException("Could not obtain the named Product " );
	        }
	    }
	    

		    
	    
		public Photo registerPhotos(Photo photo) throws Exception{
			
			try {
				begin();
				System.out.println("inside Hotel_PhotosDAO");
				getSession().save(photo);
				commit();
				return photo;
			} catch (HibernateException e) {
				rollback();
				throw new Exception("Exception while creating user: " + e.getMessage());
			}
		}

		 public void update(int productId,String productName,int productAvailability,String modelNo,float price,String description) throws ProductException {
		       // try {
		            begin();
		            System.out.println("product dao");
		            Query q = getSession().createQuery("update Product set productName=:productName,productAvailability=:productAvailability, modelNo=:modelNo, price=:price ,description= :description where productId= :productId ");
		           q.setInteger("productId", productId);
		           q.setString("productName", productName);
		           q.setInteger("productAvailability", productAvailability);
		           q.setString("modelNo", modelNo);
		           q.setFloat("price", price);
		           q.setString("description", description);
		           q.executeUpdate();
		            commit();
//		        } catch (HibernateException e) {
//		            rollback();
//		            throw new ProductException("Could not save the Product", e);
//		        }
		    }   
		
		
}
