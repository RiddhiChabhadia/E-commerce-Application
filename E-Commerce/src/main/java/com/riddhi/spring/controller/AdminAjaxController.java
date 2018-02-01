package com.riddhi.spring.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.riddhi.spring.dao.CartDAO;
import com.riddhi.spring.dao.CustomerDAO;
import com.riddhi.spring.dao.ProductDAO;
import com.riddhi.spring.dao.SupplierDAO;
import com.riddhi.spring.exception.CartException;
import com.riddhi.spring.exception.ProductException;
import com.riddhi.spring.exception.SupplierException;
import com.riddhi.spring.pojo.Cart;
import com.riddhi.spring.pojo.Customer;
import com.riddhi.spring.pojo.Product;
import com.riddhi.spring.pojo.Supplier;

@Controller
public class AdminAjaxController {
	@Autowired
	@Qualifier("supplierDAO")
	SupplierDAO supplierDAO;
	
	@Autowired
	@Qualifier("cartDAO")
    CartDAO cartDAO;

	@Autowired
	@Qualifier("customerDAO")
	CustomerDAO customerDAO;
	
	
	@Autowired
	@Qualifier("productDAO")
	ProductDAO productDAO;
	
    @RequestMapping(value = "/activateSupplier.htm", method=RequestMethod.POST)
@ResponseBody
public String getAttr(HttpServletRequest request) throws SupplierException{
    	System.out.print("inside ajax controller");
    	
	
    	int supplierId = Integer.parseInt(request.getParameter("aid"));
    	supplierDAO.update(supplierId);
    	
    	return "admin";  	
    }
	
    
    @RequestMapping(value = "/removeProduct.htm", method=RequestMethod.POST)
    @ResponseBody
    public void removePro(HttpServletRequest request) throws SupplierException, CartException{
        	System.out.print("inside ajax controller");
        	HttpSession session = (HttpSession) request.getSession();
    		Customer customer=(Customer)session.getAttribute("customer");
        	int productId=Integer.parseInt(request.getParameter("aid"));
        	
        	cartDAO.delete(productId, customer.getCustomerID()); 	
        }
    
    @RequestMapping(value = "/increaseQuantity.htm", method=RequestMethod.POST)
    @ResponseBody
    public String increaseQuantity(HttpServletRequest request) throws SupplierException, CartException{
        
    	String str="";
    	System.out.print("inside ajax controller");
        	HttpSession session = (HttpSession) request.getSession();
    		Customer customer=(Customer)session.getAttribute("customer");
        	int productId=Integer.parseInt(request.getParameter("aid"));
        	Cart c=cartDAO.get1(customer.getCustomerID(),productId); 
        	int a=c.getQuantity();
        	System.out.print("a ka value is"+a);
        	a=a+1;
        	
        	c.setQuantity(a);
        	str=String.valueOf(productId);
        	System.out.println(str);
        	cartDAO.update(customer.getCustomerID(), a, productId);
        	return str;
        }
	
    @RequestMapping(value = "/decreaseQuantity.htm", method=RequestMethod.POST)
    @ResponseBody
    public String decreaseQuantity(HttpServletRequest request) throws SupplierException, CartException{
    	String str="";
    		System.out.print("inside ajax controller");
        	HttpSession session = (HttpSession) request.getSession();
    		Customer customer=(Customer)session.getAttribute("customer");
        	int productId=Integer.parseInt(request.getParameter("aid"));
        	Cart c=cartDAO.get1(customer.getCustomerID(),productId); 
        	int a=c.getQuantity();
        	System.out.print("a ka value is"+a);
        	a=a-1;
        	c.setQuantity(a);
        	str=String.valueOf(productId);
        	System.out.println(str);
        	cartDAO.update(customer.getCustomerID(), a, productId);
        return str;	
        }  
    
    
    @RequestMapping(value = "/removeSupplierProduct.htm", method=RequestMethod.POST)
    @ResponseBody
    public void removesuoPro(HttpServletRequest request) throws SupplierException, CartException, ProductException{
        	System.out.print("inside remove pro ajax controller");
        	HttpSession session = (HttpSession) request.getSession();
    		Supplier supplier=(Supplier)session.getAttribute("supplier");
    		System.out.println(supplier.getFirstName());
        	int productId=Integer.parseInt(request.getParameter("aid"));
        	System.out.println(productId);
        	productDAO.softdelete(productId);
        		
        }
    
    
    @RequestMapping(value = "/search/list.htm", method=RequestMethod.POST)
    @ResponseBody
    public String search(HttpServletRequest request) throws Exception{
        	System.out.print("inside search controller");
//        	HttpSession session = (HttpSession) request.getSession();
//    		Supplier supplier=(Supplier)session.getAttribute("supplier");
//    		System.out.println(supplier.getFirstName());
//        	int productId=Integer.parseInt(request.getParameter("aid"));
//        	System.out.println(productId);
//        	productDAO.softdelete(productId);
        	
        	 String value=request.getParameter("value");
             System.out.println(value);
             List<Product> pro=productDAO.testLike(value);
           //  ObjectMapper mapper = new ObjectMapper();
            // mapper.writeValue(new File("c:\\user.json"), pro);

           //Object to JSON in String
           //String prolist = mapper.writeValueAsString(pro);
             //System.out.println(prolist);
             System.out.println("Size in ajax:\t"+pro.size());
             request.getSession().setAttribute("products", pro);
             System.out.println("set products in ajax!");
             String prolist ="xxx";
             System.out.println(prolist);
             return prolist;
        		
        }
}
