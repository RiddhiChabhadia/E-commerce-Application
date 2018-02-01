<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<div class="header-container">
 
    <div class="site-name">Online Shop</div>
     <c:set var="contextPath" value="${pageContext.request.contextPath}" />
    <div class="header-bar">
       <%--  <c:if test="${sessionScope.customer != null}">

           <a href="${contextPath}/home1.jsp">Logout</a>
           
           <a href="${contextPath}/customer/viewPDF/menu.pdf">View History</a>
           
           <a href="${contextPath}/customer/viewCart" >Cart</a> <br />
 
        </c:if>
       <c:if test=" ${sessionScope.customer == null}"> 
       
<a href="${contextPath}/customer/register" >Register New customer f header</a> 

<a href="${contextPath}/log" >Login f header</a>
         </c:if>  --%>
         <c:choose>
  <c:when test="${sessionScope.customer != null}">
    
          
            &nbsp; &nbsp; &nbsp; &nbsp;
           <a href="${contextPath}/customer/viewPDF/menu.pdf">View History</a>
            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
           <a href="${contextPath}/customer/viewCart" >Cart</a> <br />
            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
            <a href="${contextPath}/logout">Logout</a>
            <a href="${contextPath}/custo" >Home</a> <br />
  </c:when>
  <c:otherwise>
       &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
       <br/>  
<a href="${contextPath}/cust/register" >Register New customer</a> 
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
<a href="${contextPath}/log" >Login</a>
<a href="${contextPath}/home" >Home</a> <br />
  </c:otherwise>
</c:choose>
         
         
         
    </div>
</div>