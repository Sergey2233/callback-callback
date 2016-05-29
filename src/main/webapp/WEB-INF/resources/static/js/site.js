
$(document).on('click', '#logout', function() {
	console.log("add click ");
	$( "#button-form-logout" ).click();

})

$(function() {
	$("#modallogin").dialog({ autoOpen: false, title: "" })
	.prev(".ui-dialog-titlebar").css("background","#72ada2");
})


$(document).on('click', '#login', function() {
	console.log("open login modal ");
	$("#modallogin").dialog('open');

})

$(function() {
	$("#modal-create-user").dialog({ autoOpen: false, title: "" })
	.prev(".ui-dialog-titlebar").css("background","#72ada2");
})




$(document).on('click', '#check-in', function() {
	
	console.log("open login modal ");
	$("#modallogin").dialog('close');
	$("#modal-create-user").dialog('open');


})
