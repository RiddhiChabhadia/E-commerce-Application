<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">// <![CDATA[
      $("#searchterm").keyup(function(e){
        var q = $("#searchterm").val();
        $.getJSON("http://en.wikipedia.org/w/api.php?callback=?",
        {
          srsearch: q,
          action: "query",
          list: "search",
          format: "json"
        },
        function(data) {
          $("#results").empty();
          $("#results").append(" Results for <b>'+ q +'</b> ");
          $.each(data.query.search, function(i,item){
            $("#results").append("<div><a href='http://en.wikipedia.org/wiki/" + encodeURIComponent(item.title) + "'>" + item.title + "</a>" + item.snippet + "</div>");
          });
        });
      });
 
// ]]></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<input id="searchterm" type="text" /> <button id="search">search</button>
</body>
</html>