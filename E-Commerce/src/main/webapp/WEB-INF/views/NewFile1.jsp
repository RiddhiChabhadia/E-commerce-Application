<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>
<link rel="stylesheet" href="css/style.css" type="text/css" media="screen" title="default" />
</head>

<body>
  
<div class="login">
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
  <header class="login-header"><span class="text">LOGIN</span><span class="loader"></span></header>
  <form class="login-form" action="${contextPath}/login" method="post">
    <input class="login-input" type="text" placeholder="Username" name="username" size="30" pattern="^[_A-z0-9]{1,}$" maxlength="15"/>
    <input class="login-input" type="password" placeholder="Password" name="password" size="30" data-minlength="6" pattern="[_A-z0-9]{1,}$"/>
    <table>
<tr>
<td>Room Type:</td>
                <td>
                <%-- <form:select path="room_type" items="${roomType}" /> --%>
                
               <select id="user" name="user">
   <option value="Supplier">Seller</option>
   <option value="Customer">Customer</option>
   <option value="Admin">Admin</option>
                </td>
                
                </tr>
                </table>
   
  <button class="login-btn" type="submit">login</button>
   	<!-- 	<select id="user" name="user">
   <option value="Supplier">Seller</option>
   <option value="Customer">Customer</option>
   <option value="Admin">Admin</option>
</select> -->
  </form>
</div>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

   <script src="js/index.js"></script>

</body>
</html>
