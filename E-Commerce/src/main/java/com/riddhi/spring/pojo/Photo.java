package com.riddhi.spring.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.commons.CommonsMultipartFile;
@Entity
@Table(name="photo")
public class Photo {

	

	public Photo() {
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "photoId", unique=true, nullable = false)
	private long photoID;
	
	   //for DataBinder to bind <input type="file".../>
										  //will not be mapped for Hibernate as we store the file in the FileSystem
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="productId")
	private Product prod;//file will be placed into this field by DataBinder
										  //file is in the memory. needs to be transferred to the FileSystem using java.io.file
	@Column(name = "filename")
	private String filename;     
	

										  
	public long getPhotoID() {
		return photoID;
	}
	public void setPhotoID(long photoID) {
		this.photoID = photoID;
	}
	
	public Product getProd() {
		return prod;
	}
	public void setProd(Product prod) {
		this.prod = prod;
	}

	

	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	


	
}
