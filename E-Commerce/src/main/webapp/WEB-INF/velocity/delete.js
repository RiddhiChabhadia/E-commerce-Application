
	$(document).ready(function(){
		  $(document).on('click', '.delete', function(e) {
	          e.preventDefault();
	          var aid = $(this).parent().parent().data('id');
	          alert(aid);
	          var row =  $("#"+aid).fadeOut(3000);
	          $.post( "/removeSupplierProduct.htm", {aid: aid})
			  .done(function(serverdata) { 
				  
			  });                     
		  });

	 });
