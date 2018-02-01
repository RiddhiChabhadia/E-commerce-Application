package com.riddhi.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.riddhi.spring.dao.CustomerDAO;
import com.riddhi.spring.dao.ProductDAO;
import com.riddhi.spring.dao.SupplierDAO;
import com.riddhi.spring.exception.ProductException;
import com.riddhi.spring.exception.SupplierException;
import com.riddhi.spring.pojo.Customer;
import com.riddhi.spring.pojo.Product;
import com.riddhi.spring.pojo.Supplier;
import com.riddhi.spring.pojo.SupplierAddress;

@Controller
public class LoginController {
	
	
	@Autowired
	@Qualifier("supplierDAO")
	SupplierDAO supplierDAO;
	
	
	@Autowired
	@Qualifier("customerDAO")
	CustomerDAO customerDAO;

	@Autowired
	@Qualifier("productDAO")
	ProductDAO productDAO;
	
	
	@RequestMapping(value ={"/"}, method = RequestMethod.GET)
	public String showForm(ModelMap model,HttpServletRequest request) {
		

		HttpSession session =request.getSession();
		session.invalidate();
		return "home1";

	}
	
	@RequestMapping(value ={"/home"}, method = RequestMethod.GET)
	public String showForm1(ModelMap model,HttpServletRequest request) {
		

		HttpSession session =request.getSession();
		session.invalidate();
		return "home1";

	}
	
	@RequestMapping(value ={"/log"}, method = RequestMethod.GET)
	public String LOG(ModelMap model) {
		
		
		return "NewFile1";

	}
	
	@RequestMapping(value ={"/logout"}, method = RequestMethod.GET)
	public String LOGout(ModelMap model,HttpServletRequest request) {
		
		HttpSession session =request.getSession();
		session.invalidate();
		return "home1";

	}
	
	@RequestMapping(value ={"/login"}, method = RequestMethod.GET)
	public String LOGoIn(ModelMap model,HttpServletRequest request) {
		
		HttpSession session =request.getSession();
		session.invalidate();
		return "NewFile1";

	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	protected ModelAndView loginUser(HttpServletRequest request) throws Exception {

		HttpSession session = (HttpSession) request.getSession();
		
		try {
			
			String type=request.getParameter("user");
			System.out.println(type+"user type");

			System.out.print("loginUser");
if(type.equalsIgnoreCase("Supplier"))
			{Supplier  supplier = supplierDAO.get(request.getParameter("username"), request.getParameter("password"));
			
			if(supplier == null){
				System.out.println("UserName/Password does not exist");
				session.setAttribute("errorMessage", "UserName/Password does not exist");
				return new ModelAndView("error");
			}
			else if(supplier.isActivated()==false){
				
				System.out.println("Supplier not active");
				session.setAttribute("errorMessage", "UserName/Password does not exist");
				return new ModelAndView("error");	
				
				
			}
			
			String role="supplier";
			session.setAttribute("supplier", supplier);
			session.setAttribute("role",role);
			
			return  new ModelAndView("supplier-dashboard");}


else if(type.equalsIgnoreCase("Customer")){
	System.out.println("cust login page if");
	
	
			       
			       
			       
	Customer  customer = customerDAO.get(request.getParameter("username"), request.getParameter("password"));
	 List<Product> products = null;
	
			products = productDAO.list();
			System.out.println(products.size()+"cust login page");
	
	if(customer == null){
		System.out.println("UserName/Password does not exist");
		session.setAttribute("errorMessage", "UserName/Password does not exist");
		return new ModelAndView("error");
	}
	
	session.setAttribute("customer", customer);
	String role="customer";
	session.setAttribute("role",role);
	session.setAttribute( "products", products);
	return new  ModelAndView("customer-page");
}
else if(type.equalsIgnoreCase("admin")){
	
String username=request.getParameter("username");
String password =request.getParameter("password");
if(username.equals("admin") && password.equals("admin")){
	session.setAttribute("role", "admin");
	session.setAttribute("admin", "admin");
	return new ModelAndView("home1");
	
	
	
}
else{System.out.println("UserName/Password does not exist");
session.setAttribute("errorMessage", "UserName/Password does not exist");
return new ModelAndView("error");}
	
	
}
		} catch (SupplierException e) {
			System.out.println("Exception: " + e.getMessage());
			session.setAttribute("errorMessage", " Username/password already used ");
			return new ModelAndView("error");
		}
		
		return null;

	}

}
