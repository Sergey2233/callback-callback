/* login */
$(document).on('click', '#button-login', function( ) {
	var tokenName =  document.getElementById('token').name;
	var tokenValue =  document.getElementById('token').value;
	console.log("token"+ tokenName);
	var data = $("#formlogin").serialize();
	 modules.loader.start();
	console.log("data "+ data);
	$.ajax({
		   type: "POST",
		   url: "/login",
		   data: data ,
		   success: function(msg){
			   if (msg.value == true){
			       modules.loader.stop();
			   	$("#modal-create-user").dialog('close');
			    $("#modallogin").dialog('open');
			    window.location.reload();
			  }else{
				  modules.loader.stop();
				  console.log(""+ msg.exceptions[0].value)
				  $("#error-login").removeClass('notvisible');
			  }
		   }
	
 });
	})

	/* create user */
	
	$(document).on('click', '#button-create-user', function( ) {
	var tokenName =  document.getElementById('token-create-user').name;
	var tokenValue =  document.getElementById('token-create-user').value;
	console.log("token"+ tokenName);
	var data =$("#form-create-user").serialize();
	 modules.loader.start();
	console.log("data "+ data);
	$.ajax({
		   type: "POST",
		   url: "/callback/create",
		   headers: {'Content-Type': 'application/x-www-form-urlencoded'},
		   data: data ,
		   success: function(msg){
			   if (msg.value == true){
			       modules.loader.stop();
			   	$("#modal-create-user").dialog('close');
			   	$("#modallogin").dialog('open');
			  }else{
				  modules.loader.stop();
				  console.log(""+ msg.exceptions[0].value)
				  $("#error-login").removeClass('notvisible');
			  }
		   },
		   error: function(msg){
			   console.log(msg)
		   }
	
 });
	})