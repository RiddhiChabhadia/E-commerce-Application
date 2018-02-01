<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
    crossorigin="anonymous"></script>
<!-- Latest compiled and minified JavaScript -->
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<%=request.getContextPath()%>/resources/css/new-age.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/css/new-age.min.css" rel="stylesheet">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <a href="${contextPath}/logout">Logout</a>
   <a href="${contextPath}/controller/supplier-dashboard.jsp">home</a>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<table border="1" cellpadding="5" cellspacing="5">

		           <tr>

		            <td>${product.productName}</td>
		            <td>${product.productAvailability}</td>
		            <td>${product.modelNo}</td>
		            <td>${product.price}</td>
		            <td>${product.modelNo}</td>
		            <td>${product.supplier.supplierID}</td>
			</tr>
			</table>
			
			
			<form  action="${contextPath}/product/update" method="post">
Name:<input  type="text" name="productName" pattern="^[_A-z]{1,}$" maxlength="15" required="true" /><br/>
Availability:<input name="productAvailability"  size="30" pattern="^[0-9]{1,}$"  required="true"/><br/>
ModelNo:<input type="text" name="modelNo"  size="30" pattern="^[_A-z0-9]{1,}$" maxlength="10" required="true"/><br/>
Price:<input  name="price"   pattern="^[0-9]{1,}$" maxlength="10"  required="true"/><br/>
Description:<input type="text" name="description" size="30" pattern="^[ _A-z0-9]{1,}$" maxlength="15"required="true"/>
<input type="hidden" name="id" value="${product.productId}">
<input type="submit" value="submit"/>

</form>
		        
</body>
</html>