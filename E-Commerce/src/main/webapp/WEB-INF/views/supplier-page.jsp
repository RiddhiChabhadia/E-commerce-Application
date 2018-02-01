<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
Welcome to the Supplier Page
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<a href="${contextPath}/suuuu/register" >Register New Supplier</a> <br />
<a href="${contextPath}/log" >Login</a> <br />
<a href="${contextPath}/home" >Home</a> <br />

</body>
</html>