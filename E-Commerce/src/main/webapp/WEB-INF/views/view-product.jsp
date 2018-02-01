<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product page</title>
</head>
<body>
<jsp:include page="customer-header.jsp" />
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<table border="1" cellpadding="5" cellspacing="5">

		           <tr data-id="${product.productId}">
		<td><a href="<c:url value='/customer/cart/${product.productId}' />" >AddToCart</a></td>
		            <td>${product.productName}</td>
		            <td>${product.productAvailability}</td>
		            <td>${product.modelNo}</td>
		            <td>${product.price}</td>
		            <td>${product.modelNo}</td>
		            <td>${product.supplier.supplierID}</td>
		    <c:forEach var="photo" items="${product.proPhotos}">
                    <td>   <img height="150" width="150" src="http://localhost:8080/controller/resources/${photo.filename}" />
                    </td></c:forEach>
                       
		           
		            
			</tr>
			</table>
		        
</body>
</html>