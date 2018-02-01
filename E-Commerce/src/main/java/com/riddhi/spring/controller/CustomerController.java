package com.riddhi.spring.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.SortingFocusTraversalPolicy;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.riddhi.spring.dao.AddressDAO;
import com.riddhi.spring.dao.CartDAO;
import com.riddhi.spring.dao.CustomerDAO;
import com.riddhi.spring.dao.OrderDAO;
import com.riddhi.spring.dao.ProductDAO;
import com.riddhi.spring.dao.SupplierDAO;
import com.riddhi.spring.exception.AddressException;
import com.riddhi.spring.exception.CartException;
import com.riddhi.spring.exception.CustomerException;
import com.riddhi.spring.exception.OrderException;
import com.riddhi.spring.exception.PhotoException;
import com.riddhi.spring.exception.ProductException;
import com.riddhi.spring.exception.SupplierException;
import com.riddhi.spring.pojo.Address;
import com.riddhi.spring.pojo.Cart;
import com.riddhi.spring.pojo.Customer;
import com.riddhi.spring.pojo.CustomerAddress;
import com.riddhi.spring.pojo.OrderDetail;
import com.riddhi.spring.pojo.Product;
import com.riddhi.spring.pojo.Supplier;
import com.riddhi.spring.pojo.SupplierAddress;

@Controller 

public class CustomerController {
	
	public  int a=0;

	@Autowired
	@Qualifier("customerDAO")
	CustomerDAO customerDAO;
	
	@Autowired
	@Qualifier("addressDAO")
	AddressDAO addressDAO;
	
	
	@Autowired
	@Qualifier("orderDAO")
    OrderDAO orderDAO;
	

	@Autowired
	@Qualifier("productDAO")
	ProductDAO productDAO;

	@Autowired
	@Qualifier("cartDAO")
    CartDAO cartDAO;
	
	@RequestMapping(value = "/custo", method = RequestMethod.GET)
	public ModelAndView supplierlist(HttpServletRequest request) throws ProductException {
	System.out.println("cust");
        request.getSession().setAttribute("role", "customer");
	if(request.getSession().getAttribute("products")!=null){
		
		List<Product> products = (List<Product>) request.getSession().getAttribute("products");
		System.out.println("SIZE in get:\t"+products.size());
        return new ModelAndView("customer-page");	
	}
        List<Product> products = null;
		try {
			products = productDAO.list();
		} catch (ProductException e) {
		}
		request.getSession().setAttribute("products", products);
		System.out.println("SIZE in get:\t"+products.size());
        return new ModelAndView("customer-page");
	}
	
	
	
	
	
	@RequestMapping(value = "/custo", method = RequestMethod.POST)
	public ModelAndView supplierlist1(HttpServletRequest request) {
	System.out.println("cust");
	if(request.getSession().getAttribute("products")!=null){
		List<Product> products = (List<Product>) request.getSession().getAttribute("products");
		System.out.println("SIZE in post:\t"+products.size());
        return new ModelAndView("customer-page");	
	}
	
	List<Product> products = null;
	try {
		products = productDAO.list();
	} catch (ProductException e) {
	}
	request.getSession().setAttribute("products", products);
	System.out.println("SIZE:\t"+products.size());
        return new ModelAndView("customer-page");
	}
	
	
	@RequestMapping(value = "/customer/view/{id}", method = RequestMethod.GET)
	public ModelAndView viewProduct(@PathVariable int id, HttpServletRequest request,HttpServletResponse response) throws ProductException, IOException {
	System.out.println("cust prod ");
	HttpSession session = request.getSession();
	Customer customer=(Customer) request.getAttribute("customer");
//	if(customer== null){
//		System.out.println("cust null in cart");
//		
//		response.sendRedirect("../../NewFile1.jsp");
//	}
	 Product pr = productDAO.get(id); 
	 if(pr==null){
			 
			 System.out.println("product null");}

//		try {
//		//	 Product pr = productDAO.get(id); 
//		} catch (ProductException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        return new ModelAndView("view-product", "product", pr);
	}
	
	
	
	
	
	@RequestMapping(value ={"/cust/register"}, method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		System.out.println("inside  customer get");
		//Supplier supplier=new Supplier();// should be AutoWired

		// command object
		model.addAttribute("customerAddress", new CustomerAddress());
	//	model.addAttribute("address", new Address());

		// return form view
		return "customer-register";

	}
	
	
	

	@RequestMapping(value = "/custoo/reg", method = RequestMethod.POST)
public ModelAndView handleUpload(@ModelAttribute("customerAddress") @Validated CustomerAddress customerAddress,BindingResult bindingResult,HttpServletRequest request) throws ProductException, PhotoException, SupplierException, AddressException, CustomerException, EmailException {
	HttpSession session = request.getSession();
		List<Product> products = null; 
		try {
		
		System.out.println("inside cust post");
		if (bindingResult.hasErrors()) {
			//logger.info("Returning empSave.jsp page");
			System.out.println("customer error");
			//List<Product> products = null;
			try {
				products = productDAO.list();
			} catch (ProductException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getSession().setAttribute("products", products);
			 return new ModelAndView("customer-page", "products", products);
		}
		Customer s=new Customer();
s.setFirstName(customerAddress.getCustomer().getFirstName());
s.setLastName(customerAddress.getCustomer().getLastName());
s.setUsername(customerAddress.getCustomer().getUsername());
s.setPassword(customerAddress.getCustomer().getPassword());


Email email = new SimpleEmail();
email.setHostName("smtp.googlemail.com");
email.setSmtpPort(465);
email.setAuthenticator(new DefaultAuthenticator("apurva89.23@gmail.com", "love2dance"));
email.setSSL(true);
email.setFrom("apurva89.23@gmail.com");
email.setSubject("Registeration Confirmation");
email.setMsg("Congratulations you have sucessfully registerd with One stop" );
s.setEmail(customerAddress.getCustomer().getEmail());
email.addTo(s.getEmail());
email.send();
		
	Address ad=new Address();
	ad.setAddressLine1(customerAddress.getAddress().getAddressLine1());
	ad.setAddressLine2(customerAddress.getAddress().getAddressLine2());
	ad.setCity(customerAddress.getAddress().getCity());
	ad.setState(customerAddress.getAddress().getState());
	ad.setCountry(customerAddress.getAddress().getCountry());
	ad.setPostalCode(customerAddress.getAddress().getPostalCode());
	ad.setAddressType(customerAddress.getAddress().getAddressType());
		
	s.getCustomerAddress().add(ad);
		ad.setCustomer(s);
		
		
		try {
			products = productDAO.list();
			System.out.println(products.size()+"product size ");
		} catch (ProductException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		customerDAO.create(s);
	addressDAO.create(ad);

	
		
		
	
		} catch (CustomerException e) {
			session.setAttribute("errorMessage", "UserName/Password already  exist");
			return new ModelAndView("errorc");
		}
			
	 return new  ModelAndView("customer-page", "products", products);
	}
	
	
	
	@RequestMapping(value = "/customer/cart/{id}", method = RequestMethod.GET)
	public ModelAndView addtoCart(@PathVariable int id, HttpServletRequest request) throws ProductException, PhotoException, SupplierException, AddressException, CustomerException, CartException {
		System.out.println("here");
		HttpSession session = (HttpSession) request.getSession();
		session.setAttribute("role", "customer");
		Customer customer=(Customer)session.getAttribute("customer");
		if(customer==null){
			return new ModelAndView("customer-page");
		}
//	if(customer==null){
//			
//			return new ModelAndView("NewFile1");
//	{
			
//		}
		 System.out.println(customer.getCustomerID()+"cart cust id");
		 Product pr = productDAO.get(id); 
		 
		 if(pr==null){
				 
				 System.out.println("product null");}
		
		
		Cart c=cartDAO.get1(customer.getCustomerID(),pr.getProductId());
	if(pr.isActive()){
		
		if(c!=null){
			
			System.out.println("inside else");
			
			 int quantity = c.getQuantity();
			 
            quantity = quantity + 1;
           c.setQuantity(quantity);
			cartDAO.update(customer.getCustomerID(),quantity,pr.getProductId());
			
			
			
		}
		else{
System.out.println("c is null else");
			
            Cart cart1 = new Cart();
            cart1.setCustomer(customer);
            cart1.setProduct(pr);
            cart1.setQuantity(1);
			cartDAO.create(cart1);
			
		}}
		
		 List<Product> products = null;
			try {
				products = productDAO.list();
			} catch (ProductException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return new ModelAndView("customer-page", "products", products);}






@RequestMapping(value ={"/customer/viewCart"}, method = RequestMethod.GET)
public ModelAndView Cart(HttpServletRequest request) throws CartException, CustomerException {
	
	System.out.println("inside viewcart get");
	HttpSession session = (HttpSession) request.getSession();
	Customer customer=(Customer)session.getAttribute("customer");
//	if(customer==null){
//		
//		return new ModelAndView("NewFile1");
//		
//	}
	long a=customer.getCustomerID();
	System.out.println("cust id"+a);
	Customer c=customerDAO.get(customer.getUsername(), customer.getPassword());
	//List<Cart> cart=cartDAO.get(c.getCustomerID());
	List <Cart> cart= (List<Cart>) customer.getCart();
	System.out.println("cart size"+cart.size());
	for(Cart c1:cart){
		System.out.println(" status"+c1.getProduct().isActive());
		if((c1.getProduct().isActive())==false){
			
			cartDAO.delete(c1.getProduct().getProductId(), customer.getCustomerID());
		}
	}
	System.out.println("cart size"+cart.size());
	List<Cart> car=cartDAO.get(customer.getCustomerID());
	return new ModelAndView("view-cart","cart",car);

}


@RequestMapping(value ={"/customer/buy"}, method = RequestMethod.POST)
public ModelAndView checkout(HttpServletRequest request) throws CartException, CustomerException, OrderException {
	System.out.println("inside buy");
	HttpSession session = (HttpSession) request.getSession();
	Customer customer=(Customer)session.getAttribute("customer");
	List<Cart> item= (List<Cart>) customer.getCart();
	System.out.println("cart size"+item.size());
	float total = 0;
	OrderDetail o = null;
	a=orderDAO.createId();
	System.out.println("max id"+a);
	a=a+1;
	List<OrderDetail> orderlist = new ArrayList<OrderDetail>();
		for(Cart c:item){
	total=total+c.getProduct().getPrice();	
	 o=new OrderDetail();
	o.setOrderId(a);

	o.setCustomer(customer);
	o.setProduct(c.getProduct());
	o.setQuantity(c.getQuantity());
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	System.out.println(dateFormat.format(date));
	o.setOrderDate(date);
	
	orderDAO.create(o);
	cartDAO.delete(c.getProduct().getProductId(), customer.getCustomerID());
	o.setTotal((int)total);
	orderlist.add(o);
	}
	
		System.out.println("order total"+total);

	return new ModelAndView("buy-product","order",orderlist);

}

@RequestMapping(value = "/customer/viewPDF/menu.pdf", method = RequestMethod.GET)
protected ModelAndView viewHotelMenu(HttpServletRequest request) throws Exception  {

	HttpSession session = (HttpSession) request.getSession();
	Customer customer=(Customer)session.getAttribute("customer");
	

	
//if(customer==null){
//		
//		return new ModelAndView("NewFile1");
//		
//	}
    View view = new MyView();
    List<OrderDetail> c=orderDAO.get(customer.getCustomerID());
    System.out.println(c.size()+"order list size");

    
    return new ModelAndView(view,"list",c);
}




@RequestMapping(value = "/supplier/product/{id}", method = RequestMethod.GET)
public ModelAndView  supProduct(@PathVariable int id, HttpServletRequest request) throws ProductException {
System.out.println("cust prod ");
    

 Product pr = productDAO.get(id); 
 if(pr==null){
		 
		 System.out.println("product null");}

    return new ModelAndView("update-product", "product", pr);
}



}
