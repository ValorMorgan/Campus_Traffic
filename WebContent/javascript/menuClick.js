/**
 * Run by the header script to enable the ability to click the menu at the top left
 * in order to reveal or hide the login form / logged-in menu. This script assumes
 * that the jquery script has already been run.
 */

var toggleSpeed = 175;

$(function () {
  /* Alter the class of the navigation menu's list. This lets
   * us determine if javascript is running and, if it isn't,
   * css formatting will compensate for being unable to run the script.
   */
  $('#header #nav > ul').toggleClass('no-js js');
  // If the login form exists, it needs to be formatted.
  // If it doesn't, the user must already be logged in, format that menu.
  if(document.getElementById("loginForm") != null){
	  $('#header #nav .js #loginForm').hide();
	  // If the list is clicked, reveal the hidden menu
	  $('#header #nav .js').click(function(e) {
		    $('#header #nav .js #loginForm').slideToggle(toggleSpeed);
		    $('.click').toggleClass('active');
		    e.stopPropagation();
	  });
	  // Dummy click listener to keep the click event from bubbling
	  // up to the document (which would hide the login form).
	  $('#header #nav .js input').click(function(e) {
		    if ($('#header #nav .js #loginForm').is(':visible')) {
		    	e.stopPropagation();
		    }
	  });
	  // If anywhere else in the document is clicked, hide the form.
	  $(document).click(function() {
		    if ($('#header #nav .js #loginForm').is(':visible')) {
		      $('#header #nav .js #loginForm', this).slideUp();
		      $('.click').removeClass('active');
		    }
	  });
  }
  else{
	  $('#header #nav .js ul').hide();
	  // If the list is clicked, reveal the hidden menu
	  $('#header #nav .js').click(function(e) {
	    $('#header #nav .js ul').slideToggle(toggleSpeed);
	    $('.click').toggleClass('active');
	    e.stopPropagation();
	  });
	  // If anywhere else in the document is clicked, hide the form.
	  $(document).click(function() {
	    if ($('#header #nav .js ul').is(':visible')) {
	      $('#header #nav .js ul', this).slideUp();
	      $('.click').removeClass('active');
	    }
	  });
  }
});