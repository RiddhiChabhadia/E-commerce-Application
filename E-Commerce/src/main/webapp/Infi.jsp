<html>
<head>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
           <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <style>body {
    margin: 0;
    background-color: #F0F0F0;
    font-family: 'Liberation Sans', Arial, sans-serif;
}

h1 {
    text-align: center;
}

#images {
    margin: 0 auto;
    padding: 0;
    width: 640px;
    list-style-type: none;
}</style>
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
      
      var $img = $('#images li:nth-last-child(5)').clone();
     
      $('#images').append($img);
        }
    });
});
 </script>
</head>
<body>
<h1>Infinite Scrolling</h1>

        <ul id="images">
       <c:forEach var="i" begin="1" end="5">
            <li>
            <table border="1" cellpadding="10" cellspacing="5">

		           <tr id="row-${i}">
	<td>	 <c:out value="${i}"/></td>
		            <td>product.productName</td>
		            <td>product.productAvailability</td>
		            <td>product.modelNo</td>
		            <td>product.price</td>
		            <td>product.modelNo</td>
		            <td>product.supplier.supplierID</td>
		     
		           
		            
			</tr>
			</table>
		        
                          </li>
                          </c:forEach>
            
        </ul>
</body>
</html>