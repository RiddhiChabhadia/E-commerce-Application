<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script
    src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<script src="resources/admin.js">
</script>
</head>
 <a href="${contextPath}/logout">Logout</a>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />



	<table border="1" cellpadding="5" cellspacing="5">
		<tr>
                    <th>First</th>
                    <th>Last</th>
                    <th>Active Status</th>
                    <th>activate it</th>
                   
                </tr>
		<c:forEach var="supplier" items="${suppliers}">
			<tr id="${supplier.supplierID}" data-id="${supplier.supplierID}">
		
		            <td> ${supplier.firstName}</td>
		            <td> ${supplier.lastName}</td>
		            <td>${supplier.activated}</td>
		            <td><input type="button" value="Activate" class="activate" /></td>
		            
			</tr>
		</c:forEach>
	</table>
</body>
</html>
