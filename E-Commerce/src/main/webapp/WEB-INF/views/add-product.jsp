<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<!-- <script>
$(document).ready(function(){
	$(document).on("click","#home",function(){
		window.location.href="http://localhost:8080/controller/login";
	});
});
</script> -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%--  <a href="${contextPath}/logout">Logout</a>
 <form method="post">
  <input type="button" name="home" id="home" value="HOME"/>
</form> --%>
<h1>${sessionScope.supplier.firstName}</h1>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<form:form commandName="product" method="post" enctype="multipart/form-data" action="${contextPath}/supplier/product/upload">
Name:<form:input path="productName" pattern="^[_A-z]{1,}$" maxlength="15" required="true"/><br/>
Availability:<input  name="productAvailability"   pattern="^[0-9]{1,}$"  required="true"/><br/>
ModelNo:<input type="text" name="modelNo" size="30" pattern="^[_A-z0-9]{1,}$" maxlength="10" required="true" /><br/>
Price:<input  name="price"  size="30" pattern="^[0-9]{1,}$"  required="true"/><br/>
Description:<input type="text" name="description"  pattern="^[ _A-z0-9]{1,}$" maxlength="15" required="true"/><br/>
Select photo:
<form:input path="photo" type="file" size="30"
						required="required" multiple="multiple" /><br/>
<input type="submit" value="Upload Button"/>
</form:form>


</body>
</html>