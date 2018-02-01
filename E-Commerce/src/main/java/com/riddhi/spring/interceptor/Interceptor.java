package com.riddhi.spring.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class Interceptor extends HandlerInterceptorAdapter{

    String errorPage;

    public String getErrorPage() {
        return errorPage;
    }

    public void setErrorPage(String errorPage) {
        this.errorPage = errorPage;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("----------------------");
        HttpSession session = (HttpSession) request.getSession();
        System.out.println("--"+session.getAttribute("role"));
        if(session.getAttribute("role") == null){
            if((request.getRequestURI().contains("supplier/"))||
                    (request.getRequestURI().contains("customer/")) ||  (request.getRequestURI().contains("admin/")))
            {
                System.out.println("in interceptor");
                System.out.println("1 -false");
                response.sendRedirect("../NewFile1.jsp");
                return false;
            }
            System.out.println(session.getAttribute("role"));
            System.out.println("in interceptor");
            return true;
        }

        if(session.getAttribute("role") != null){
        	  System.out.println(request.getRequestURI());
            System.out.println("in interceptor  1.1");
            if((request.getRequestURI().contains("admin") && session.getAttribute("role").equals("admin")) ||
                    (request.getRequestURI().contains("supplier") && session.getAttribute("role").equals("supplier"))||
                    (request.getRequestURI().contains("customer") && session.getAttribute("role").equals("customer"))||
                    (request.getRequestURI().contains("resources") && session.getAttribute("role").equals("admin")) ||
                    (request.getRequestURI().contains("resources") && session.getAttribute("role").equals("supplier"))||
                    (request.getRequestURI().contains("resources") && session.getAttribute("role").equals("customer")))
            {
                System.out.println("in interceptor1.22");
                return true;
            }
          
            if((!request.getRequestURI().contains("admin"))&&
                    (!request.getRequestURI().contains("supplier"))&&
                  (!request.getRequestURI().contains("customer")))
            {
                System.out.println("in interceptor1.23");
                return true;
            }
            
            if(request.getRequestURI().contains("customer")){
            	 System.out.println("1 .24-false");
                return true;
            }
        }

        System.out.println("NOT VALID!!");
        response.sendRedirect("NewFile1.jsp");
        System.out.println("1 -false");
        return false;
    }
}