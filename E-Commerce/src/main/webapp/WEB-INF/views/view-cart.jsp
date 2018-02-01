<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
    src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"
    integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
    crossorigin="anonymous"></script>
<script > 
	$(document).ready(function(){
		  $(document).on('click', '.remove', function(e) {
	          e.preventDefault();
	          var aid = $(this).parent().parent().data('id');
	          alert(aid);
	          var row =  $("#"+aid).fadeOut(3000);
	          $.post( "../removeProduct.htm", {aid: aid})
			  .done(function(serverdata) { 
				  
			  });                     
		  });

	 });
</script>
<script > 
	$(document).ready(function(){
		  $(document).on('click', '.increase', function(e) {
	          e.preventDefault();
	          var aid = $(this).parent().parent().data('id');
	          var oldqty = $(this).parent().find('span').text();
	          alert(oldqty);
	         
	          $.post( "../increaseQuantity.htm", {aid: aid})
	   
			  .done(function(response) {
				  alert(response); 
				  oldqty = Math.abs(oldqty)+1;
				  $("#row-"+response).find('.qunatity span').text(oldqty);
			  });                     
		  });

	 });
</script>
<script > 
	$(document).ready(function(){
		  $(document).on('click', '.decrease', function(e) {
	          e.preventDefault();
	          var aid = $(this).parent().parent().data('id');
	          var oldqty = $(this).parent().find('span').text();
	          if(oldqty == 1) {
				alert("Quantity cannot be less than 1");
			  } else {
				  $.post( "../decreaseQuantity.htm", {aid: aid})
				   
				  .done(function(response) { 
					  oldqty = Math.abs(oldqty)-1;
					  $("#row-"+response).find('.qunatity span').text(oldqty);
				  });  
				}                
		  });

	 });
</script>
<title>View Cart</title>
</head>
<body>
<jsp:include page="customer-header.jsp" />
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<form   action="${contextPath}/customer/buy" method="post">

<table>


<tr>
<td><b>Product Id</b></td>
			<td><b>Product Name</b></td>
			<td><b>Description</b></td>
			<td><b>Model No</b></td>
			<td><b>Price</b></td>
			<td><b>Supplier</b></td>
			
		</tr>
		<c:forEach var="cart" items="${cart}">
		<tr id="row-${cart.product.productId}"  data-id="${cart.product.productId}">
		<td><a href="<c:url value='/customer/view/${cart.product.productId}' />" >view</a></td> 
		            <td>${cart.product.productId}</td>
		             <td>${cart.product.productName}</td>
		               <td>${cart.product.description}</td>
		              <td>${cart.product.modelNo}</td>
		               <td>${cart.product.price}</td>
		                <td>${cart.product.supplier.supplierID}</td>
		                 <td class="qunatity"><span>${cart.quantity}</span>
		                 <input type="button" value="+" class="increase" />
		                 <input type="button" value="-" class="decrease" />
		                  </td>     
		            <td>${cart.customer.customerID}</td>
		                <td><input type="button" value="Remove" class="remove" /></td>
		                
		              

		            
			</tr>
		</c:forEach>
		
		
		
	</table>
	
	Total:
	<input type="submit" value="BuyNow"/>
	</form>
</body>
</html>