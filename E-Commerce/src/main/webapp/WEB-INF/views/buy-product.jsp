<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<h>Thank you for placing your Order</h>
<br/>
<jsp:include page="customer-header.jsp" />
<table>
		<c:forEach var="cart" items="${order}">
		<tr>
		
		            <td>${cart.product.productId}</td>
		             <td>${cart.product.productName}</td>
		              <td>${cart.product.modelNo}</td>
		               <td>${cart.product.price}</td>
		                <td>${cart.product.supplier.supplierID}</td>
		                 <td>${cart.quantity}</td>
		                 
		                 
		                 
		                 <br/>
		                 <h3>Shipping Addess:</h3>
		               <c:forEach var="address" items="${customer.customerAddress}">  
		               
		               
		               
		                 
		                 
		             <td>${address.id}</td>
		             <td>${address.addressLine1}</td>
		             <td>${address.addressLine2}</td>
		             <td>${address.city}</td>
		             
		             </c:forEach>
         </tr>
			
		</c:forEach>
			</table>
		
		
Total: ${cart.total}


	
</body>
</html>