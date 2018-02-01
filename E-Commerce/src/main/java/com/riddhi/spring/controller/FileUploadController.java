package com.riddhi.spring.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.riddhi.spring.dao.PhotoDAO;
import com.riddhi.spring.dao.ProductDAO;
import com.riddhi.spring.exception.PhotoException;
import com.riddhi.spring.exception.ProductException;
import com.riddhi.spring.pojo.Photo;
import com.riddhi.spring.pojo.Product;
import com.riddhi.spring.pojo.Supplier;



@Controller
public class FileUploadController{
	
	@Autowired
	@Qualifier("productDAO")
	ProductDAO productDAO;
	
	
	@Autowired
	ServletContext servletContext;
	
	
	@RequestMapping(value = "/supplier/addProduct", method = RequestMethod.GET)
	public String showForm(ModelMap model,HttpServletRequest request) {
		System.out.println("inside get");
		Product product=new Product();// should be AutoWired
		if(request.getParameter("home")!=null)
		System.out.println(request.getParameter("home"));
		
		// command object
		model.addAttribute("product", product);

		// return form view
		return "add-product";

	}
	
	
	
	@RequestMapping(value = "supplier/product/upload", method = RequestMethod.POST)
public String handleUpload(@ModelAttribute("product") Product product,HttpServletRequest request) throws ProductException, PhotoException {
	
		HttpSession session = (HttpSession) request.getSession();
		System.out.println("inside post");	
		
Set<Photo> multiphotos = new HashSet<Photo>();
		
		Iterator<CommonsMultipartFile> i = product.getPhoto().iterator();
		while (i.hasNext()) 
				{
			try{

				if (product.getProductName().trim() != "" || product.getProductName() != null) {
					File directory;
					String check = File.separator; 

					String path = null;
					if (check.equalsIgnoreCase("\\")) {
	path = servletContext.getRealPath("").replace("build\\", ""); 

			}

					if (check.equalsIgnoreCase("/")) {
						path = servletContext.getRealPath("").replace("build/", "");
						path += "/"; // Adding trailing slash for Mac systems.
					}
					directory = new File(path + "\\" + product.getProductName());
					boolean temp = directory.exists();
					if (!temp) {
						temp = directory.mkdir();
					}
					if (temp) {
						// We need to transfer to a file
						CommonsMultipartFile photoInMemory = i.next();

						String fileName = photoInMemory.getOriginalFilename();
						// could generate file names as well

						File localFile = new File("/Users/Riddhi/Desktop/SpringProject/Final/src/main/webapp/resources", fileName);

						// move the file from memory to the file

						photoInMemory.transferTo(localFile);
						Photo photos = new Photo();
						
						photos.setFilename(fileName);  //CHANGED HERE
						photos.setProd(product);
						
						Supplier s=(Supplier) session.getAttribute("supplier");
						product.setSupplier(s);
						product.setActive(true);
					productDAO.registerPhotos(photos);
					productDAO.create(product);
						
						multiphotos.add(photos);
						
						
						System.out.println("File is stored at" + localFile.getPath());
						System.out.print("registerNewUser");
						

					} else {
						System.out.println("Failed to create directory!");
					}

				}
}		
			catch (IllegalStateException e) {
				System.out.println("*** IllegalStateException: " + e.getMessage());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("*** IOException: " + e.getMessage());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
}
		
		try{
			
			product.setProPhotos(multiphotos);
				//product.setPhoto(multiphotos);
				//hoteldao.registerHotel(hotel);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return "supplier-dashboard";
	
	}
	
	
	@RequestMapping(value = "/product/update", method = RequestMethod.POST)
	public ModelAndView updateProduct(HttpServletRequest request) throws ProductException {
		HttpSession session = request.getSession();
		int productId=Integer.parseInt(request.getParameter("id"));
		String productName=request.getParameter("productName");
		int  productAvailability=Integer.parseInt(request.getParameter("productAvailability"));
		String modelNo=request.getParameter("modelNo");
		float price=Float.parseFloat(request.getParameter("price"));
		String description=request.getParameter("description");
		
		try{
		productDAO.update(productId, productName, productAvailability, modelNo, price ,description);}
		catch(ProductException e){
			
			
			session.setAttribute("errorMessage", "UserName/Password already  exist");
			return new ModelAndView("error");
		}
		
		
		//HttpSession session = (HttpSession) request.getSession();
		Supplier supplier=(Supplier)session.getAttribute("supplier");
		
		
		List<Product> proList=productDAO.prolist(supplier.getSupplierID());
		System.out.println("supplier pro size"+proList.size());

		return new ModelAndView("supplier-product","proList",proList);

	}
	

	}
