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
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<form:form  action="${contextPath}/supp/reg"  commandName="supplierAddress" method="post" enctype="multipart/form-data">
First Name:<form:input path="supplier.firstName" size="30" pattern="^[_A-z]{1,}$" maxlength="15"/>
<form:errors path="supplier.firstName"/><br/>

Last Name:<form:input path="supplier.lastName" size="30" pattern="^[_A-z]{1,}$" maxlength="15" /><form:errors path="supplier.lastName"/><br/>

AddressLine1:<form:input path="address.addressLine1" size="30" pattern="^[ _A-z0-9]{1,}$" maxlength="15"/><form:errors path="address.addressLine1"/><br/>

 AddressLine2:<form:input path="address.addressLine2" size="30" pattern="^[ _A-z0-9]{1,}$" maxlength="15"/><form:errors path="address.addressLine2"/><br/> 
 
 City:<input type="text" name="address.city"  size="30" pattern="^[_A-z]{1,}$" maxlength="15" /><form:errors path="address.city"/><br/>
 
State:<input type="text" name="address.state"  size="30" pattern="^[_A-z]{1,}$" maxlength="15" /><form:errors path="address.state"/><br/>

Country:<input type="text" name="address.country"   size="30" pattern="^[_A-z]{1,}$" maxlength="15"/><form:errors path="address.country"/><br/>

PostalCode:<input name="address.postalCode"  pattern="^[0-9]{5}$"  data-minlength="5" /><form:errors path="address.postalCode"/><br/>
 
Address Type:<input type="text" name="address.addressType"   size="30" pattern="^[_A-z]{1,}$" maxlength="15"/><form:errors path="address.addressType"/><br/> 

Username:<form:input path="supplier.username" size="30" pattern="^[_A-z0-9]{1,}$" maxlength="15"  /><form:errors path="supplier.username"/><br/>

Password:<form:input path="supplier.password" size="30"  data-minlength="6"  pattern="^[_A-z0-9]{1,}$" maxlength="15"  /><form:errors path="supplier.password"/><br/> 
<input type="submit" value="Upload Button"/>
</form:form>

</body>
</html>