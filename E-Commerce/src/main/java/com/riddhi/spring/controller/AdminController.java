package com.riddhi.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.riddhi.spring.dao.SupplierDAO;
import com.riddhi.spring.exception.SupplierException;
import com.riddhi.spring.pojo.CustomerAddress;
import com.riddhi.spring.pojo.Supplier;


@Controller
public class AdminController {
	@Autowired
	@Qualifier("supplierDAO")
	SupplierDAO supplierDAO;
	
	
	
	


	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView supplierlist(HttpServletRequest request) {
	
        
        List<Supplier> suppliers = null;
		try {
			suppliers = supplierDAO.list();
		} catch (SupplierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return new ModelAndView("admin", "suppliers", suppliers);
	}



}
