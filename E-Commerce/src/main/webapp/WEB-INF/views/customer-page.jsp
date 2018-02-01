<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script>
(function($){

  $.fn.endlessScroll = function(options) {

    var defaults = {
      bottomPixels: 50,
      fireOnce: true,
      fireDelay: 150,
      loader: "<br />Loading...<br />",
      data: "",
      insertAfter: "div:last",
      resetCounter: function() { return false; },
      callback: function() { return true; },
      ceaseFire: function() { return false; }
    };

    var options = $.extend({}, defaults, options);

    var firing       = true;
    var fired        = false;
    var fireSequence = 0;

    if (options.ceaseFire.apply(this) === true) {
      firing = false;
    }

    if (firing === true) {
      $(this).scroll(function() {
        if (options.ceaseFire.apply(this) === true) {
          firing = false;
          return; // Scroll will still get called, but nothing will happen
        }

        if (this == document || this == window) {
          var is_scrollable = $(document).height() - $(window).height() <= $(window).scrollTop() + options.bottomPixels;
        } else {
          // calculates the actual height of the scrolling container
          var inner_wrap = $(".endless_scroll_inner_wrap", this);
          if (inner_wrap.length == 0) {
            inner_wrap = $(this).wrapInner("<div class=\"endless_scroll_inner_wrap\" />").find(".endless_scroll_inner_wrap");
          }
          var is_scrollable = inner_wrap.length > 0 &&
            (inner_wrap.height() - $(this).height() <= $(this).scrollTop() + options.bottomPixels);
        }

        if (is_scrollable && (options.fireOnce == false || (options.fireOnce == true && fired != true))) {
          if (options.resetCounter.apply(this) === true) fireSequence = 0;

          fired = true;
          fireSequence++;

          $(options.insertAfter).after("<div id=\"endless_scroll_loader\">" + options.loader + "</div>");

          data = typeof options.data == 'function' ? options.data.apply(this, [fireSequence]) : options.data;

          if (data !== false) {
            $(options.insertAfter).after("<div id=\"endless_scroll_data\">" + data + "</div>");
            $("div#endless_scroll_data").hide().fadeIn();
            $("div#endless_scroll_data").removeAttr("id");

            options.callback.apply(this, [fireSequence]);

            if (options.fireDelay !== false || options.fireDelay !== 0) {
              $("body").after("<div id=\"endless_scroll_marker\"></div>");
              // slight delay for preventing event firing twice
              $("div#endless_scroll_marker").fadeTo(options.fireDelay, 1, function() {
                $(this).remove();
                fired = false;
              });
            }
            else {
              fired = false;
            }
          }

          $("div#endless_scroll_loader").remove();
        }
      });
    }
  };

})(jQuery);


// Script
$(document).ready(function() {
    $(document).endlessScroll({
        inflowPixels: 300,
        callback: function() {
      
      var $img = $('#images li:nth-last-child(7)').clone();
     
      $('#images').append($img);
        }
    });
});
 </script>
<!--  <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script> -->
<script>
    function getCity(object) {
        console.log("inside getCity");
        var value = $('#searchterm').val();
        alert(value);
        $.post("search/list.htm", {
            value : value
        }).done(function(data) {
            alert(data);
            $("#showlist").load(location.href + " #showlist>*", "");
             //var json = jQuery.parseJSON(data);
         //   $('#city').empty(); 
            //$.each(json, function(i, item) {
                
              //  var newOption = $('<p>' + item + '</p>');
               // $('#city').append(newOption);
            //});
        });
       
    }
</script> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body> 
<jsp:include page="customer-header.jsp" />

Welcome to the Customer Page
<%--  <c:set var="contextPath" value="${pageContext.request.contextPath}" />
<a href="${contextPath}/cust/register" >Register New customer</a> <br />
<a href="${contextPath}/log" >Login</a> <br /> --%>
<form method="post">
<input id="searchterm" class="searchterm" type="text" /> <button id="search" class=search onclick="getCity(this)">search</button>
</form>

<div id="city">

</div>
  
	  
	
	<!-- 	<tr>
			<td><b>Product Name</b></td>
			<td><b>Availability</b></td>
			<td><b>Model No</b></td>
			<td><b>Price</b></td>
		
			<td><b>Description</b></td>
			<td><b>Supplier</b></td>
			
		</tr>
		 -->
<%-- 	<ul id="images">
		
		<c:forEach var="product" items="${products}">
		
		 <li>
		<table border="1" cellpadding="5" cellspacing="5">
			<tr data-id="${product.productId}">
		<td><a href="<c:url value='/customer/view/${product.productId}' />" >view</a></td>
		            <td>${product.productName}</td>
		            <td>${product.productAvailability}</td>
		            <td>${product.modelNo}</td>
		            <td>${product.price}</td>
		            <td>${product.description}</td>
		            <td>${product.supplier.firstName}</td>
		             <c:forEach var="photo" items="${product.proPhotos}">
                    <td>   <img height="150" width="150" src="http://localhost:8080/controller/resources/${photo.filename}" />
                    </td> 
                    </c:forEach>
                        
		            
			</tr>
				</table>
			 	 </li>
		</c:forEach>
	
		   </ul> --%>
 
 
 
 <div id="showlist">
   <ul id="images">
      <c:forEach var="product" items="${sessionScope.products}">
            <li>
            <table border="1" cellpadding="5" cellspacing="5">

		          	<tr data-id="${product.productId}">
		<td><a href="<c:url value='/customer/view/${product.productId}' />" >view</a></td>
		            <td>${product.productName}</td>
		            <td>${product.productAvailability}</td>
		            <td>${product.modelNo}</td>
		            <td>${product.price}</td>
		            <td>${product.description}</td>
		            <td>${product.supplier.firstName}</td>
		             <c:forEach var="photo" items="${product.proPhotos}">
                    <td>   <img height="150" width="150"  src="http://localhost:8080/controller/resources/${photo.filename}" />
                    </td> 
                    </c:forEach> 
                        
		            
			</tr>
			</table>
		        
                          </li>
                          </c:forEach>
            </ul>
 </div>
 
</body>
</html>