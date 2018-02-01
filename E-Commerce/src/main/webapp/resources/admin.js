$(document).ready(function(){
	  $(document).on('click', '.activate', function(e) {
          e.preventDefault();
          var aid = $(this).parent().parent().data('id');
          //alert(aid);
          var row =  $("#"+aid).fadeOut(3000);
          $.post( "activateSupplier.htm", {aid: aid})
		  .done(function(serverdata) { 
			  
		  });                     
	  });

});