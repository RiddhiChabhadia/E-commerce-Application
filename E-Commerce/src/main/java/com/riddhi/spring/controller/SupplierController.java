package com.riddhi.spring.controller;



import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.riddhi.spring.dao.AddressDAO;
import com.riddhi.spring.dao.PhotoDAO;
import com.riddhi.spring.dao.ProductDAO;
import com.riddhi.spring.dao.SupplierDAO;
import com.riddhi.spring.exception.AddressException;
import com.riddhi.spring.exception.PhotoException;
import com.riddhi.spring.exception.ProductException;
import com.riddhi.spring.exception.SupplierException;
import com.riddhi.spring.pojo.Address;
import com.riddhi.spring.pojo.Customer;
import com.riddhi.spring.pojo.Product;
import com.riddhi.spring.pojo.Supplier;
import com.riddhi.spring.pojo.SupplierAddress;
import com.riddhi.spring.validator.SupplierRegValidator;


@Controller
public class SupplierController{

	@Autowired
	@Qualifier("supplierDAO")
	SupplierDAO supplierDAO;
	
	@Autowired
	@Qualifier("addressDAO")
	AddressDAO addressDAO;
	


	@Autowired
	@Qualifier("productDAO")
	ProductDAO productDAO;
	
	
	@Autowired
	@Qualifier("supplierRegValidator")
	private SupplierRegValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	@Autowired
	ServletContext servletContext;
	
	
	@RequestMapping(value = "/suppl", method = RequestMethod.GET)
	public ModelAndView supplierlist(HttpServletRequest request) {
	System.out.println("suuuup");
        
	HttpSession session =request.getSession();
	session.invalidate();
        return new ModelAndView("supplier-page");
	}
	
	

	@RequestMapping(value ={"/suuuu/register"}, method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		System.out.println("inside  supplier get");
		//Supplier supplier=new Supplier();// should be AutoWired

		// command object
		model.addAttribute("supplierAddress", new SupplierAddress());
	//	model.addAttribute("address", new Address());

		// return form view
		return "supplier-register";

	}

	
	
	@RequestMapping(value = "/supp/reg", method = RequestMethod.POST)
public String handleUpload(@ModelAttribute("supplierAddress") @Validated SupplierAddress supplierAddress,BindingResult bindingResult,HttpServletRequest request) throws ProductException, PhotoException, SupplierException, AddressException {
	
		HttpSession session = request.getSession();
		try {
		
		System.out.println("inside  sup post");
		if (bindingResult.hasErrors()) {
			//logger.info("Returning empSave.jsp page");
			return "supplier-register";
		}
		Supplier s=new Supplier();
s.setFirstName(supplierAddress.getSupplier().getFirstName());
s.setLastName(supplierAddress.getSupplier().getLastName());
s.setUsername(supplierAddress.getSupplier().getUsername());
s.setPassword(supplierAddress.getSupplier().getPassword());
		s.setActivated(false);
	Address ad=new Address();
	ad.setAddressLine1(supplierAddress.getAddress().getAddressLine1());
	ad.setAddressLine2(supplierAddress.getAddress().getAddressLine2());
	ad.setCity(supplierAddress.getAddress().getCity());
	ad.setState(supplierAddress.getAddress().getState());
	ad.setCountry(supplierAddress.getAddress().getCountry());
	ad.setPostalCode(supplierAddress.getAddress().getPostalCode());
	ad.setAddressType(supplierAddress.getAddress().getAddressType());
		
	s.getSupplierAddress().add(ad);
		ad.setSupplier(s);
		


	supplierDAO.create(s);
	addressDAO.create(ad);
		
					
				//	User u = userDao.register(user);

//				} else {
//					System.out.println("Failed to create directory!");
//				}
//			}

		} catch (SupplierException e) {
			session.setAttribute("errorMessage", "UserName/Password already  exist");
			return "error";
		}
			
		return "home1";
	}
	
	
	
	@RequestMapping(value ={"/supplier/product/update"}, method = RequestMethod.GET)
	public ModelAndView update(HttpServletRequest request) throws ProductException {
		
		HttpSession session = (HttpSession) request.getSession();
		Supplier supplier=(Supplier)session.getAttribute("supplier");
		
		
		List<Product> proList=productDAO.prolist(supplier.getSupplierID());
		System.out.println("supplier pro size"+proList.size());

		return new ModelAndView("supplier-product","proList",proList);

	}

	
}
