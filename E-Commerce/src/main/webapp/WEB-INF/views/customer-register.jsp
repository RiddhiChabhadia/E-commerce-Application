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
<jsp:include page="customer-header.jsp" />
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<form:form  action="${contextPath}/custoo/reg"  commandName="customerAddress" method="post" enctype="multipart/form-data">
First Name:<form:input path="customer.firstName" pattern="^[_A-z]{1,}$" maxlength="15" required="true"/><br/>
Last Name:<form:input path="customer.lastName"  pattern="^[_A-z]{1,}$" maxlength="15" required="true" /><br/>
Email:<form:input path="customer.email" size="30" type="email" required="true" /><br/>
AddressLine1:<form:input path="address.addressLine1" required="true"  size="30" pattern="^[ _A-z0-9]{1,}$" maxlength="15"/><br/>
 AddressLine2:<form:input path="address.addressLine2" required="true" size="30" pattern="^[ _A-z0-9]{1,}$" maxlength="15"/><br/>
 City:<form:input type="text" path="address.city" pattern="^[_A-z]{1,}$" maxlength="15" required="true" /><br/>
State:<form:input type="text" path="address.state" pattern="^[_A-z]{1,}$" maxlength="15" required="true"/><br/>
Country:<form:input type="text" path="address.country" pattern="^[_A-z]{1,}$" maxlength="15" required="true"/><br/>
PostalCode:<form:input path="address.postalCode"  pattern="^[0-9]{5}$"  required="true"/> <br/>




Address Type:<form:input type="text" path="address.addressType"  pattern="^[_A-z]{1,}$"  maxlength="15" required="true"/><br/>
Username:<form:input path="customer.username" size="30" pattern="^[_A-z0-9]{1,}$" maxlength="15" required="true"/><br/>

Password:<form:input path="customer.password" size="30" data-minlength="6" pattern="[_A-z0-9]{1,}$" required="true"/><br/>
<input type="submit" value="Upload Button"/><br/>
</form:form>

</body>
</html>