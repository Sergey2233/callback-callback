/* loader image*/
var modules = {};
modules.loader = { 
		initialize: function () {
			document.getElementsByTagName('body')[0]
				.insertAdjacentHTML('afterbegin','<div id="overlay-load" style="display:none;"><img src="../images/login/ajax-loader.gif"></div>');
			this.loaderElem = document.getElementById('overlay-load');
			console.log("aad loader ");
		},
		start: function () {
			if (this.loaderElem) {
				this.loaderElem.style.display = 'block';
				console.log("start login");
			}
		},
		stop: function () {
			if (this.loaderElem) {
				this.loaderElem.style.display = 'none';
			}
		}
};


/*initialized  loading image*/
$( document ).ready(function() {
	modules.loader.initialize();
    console.log( "ready!" + ctx  );
});

/* logout button click*/
$(document).on('click', '#logout', function() {
	console.log("add click ");
	$( "#button-form-logout" ).click();

})
/* add logan  modal dialog in title bar new color */
$(function() {
	$("#modallogin").dialog({ autoOpen: false, title: "" })
	.prev(".ui-dialog-titlebar").css("background","#72ada2");
})

/* open login modal dialog */
$(document).on('click', '#login', function() {
	console.log("open login modal ");
	$("#modallogin").dialog('open');

})

/* add  create user modal dialog  in  title bar new color */
$(function() {
	$("#modal-create-user").dialog({ autoOpen: false, title: "" })
	.prev(".ui-dialog-titlebar").css("background","#72ada2");
})




$(document).on('click', '#check-in', function() {	
	console.log("open login modal ");
	$("#modallogin").dialog('close');
	$("#modal-create-user").dialog('open');
     console.log("create - user ");
})
