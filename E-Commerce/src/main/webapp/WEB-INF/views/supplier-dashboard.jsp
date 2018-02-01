<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Hi, ${supplier.firstName}</h1>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
 <a href="${contextPath}/logout">Logout</a>
<a href="${contextPath}/supplier/addProduct.htm" >Add new Product</a> <br />
<a href="${contextPath}/supplier/product/update.htm" >Update Product</a> <br/>
<a href="${contextPath}/suppl" >Home</a> <br />

</body>
