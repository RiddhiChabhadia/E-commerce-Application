package com.riddhi.spring.dao;

import org.hibernate.HibernateException;

import com.riddhi.spring.exception.PhotoException;
import com.riddhi.spring.pojo.Photo;




public class PhotoDAO  extends DAO{
	
	
	
	public Photo register(Photo ph)
			throws PhotoException {
		try {
			begin();
			System.out.println("inside DAO");			
			getSession().save(ph);
			commit();
			return ph;

		} catch (HibernateException e) {
			rollback();
			throw new PhotoException("Exception while creating photo: " + e.getMessage());
		}
	}

	public void delete(Photo ph) throws PhotoException {
		try {
			begin();
			getSession().delete(ph);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new PhotoException("Could not delete photo");
		}
	}
	
	

}
