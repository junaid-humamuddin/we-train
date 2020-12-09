$(document)
		.ready(
				function() {
    

var userId;


$("#loginButton").click(function(e){
    e.preventDefault();
    userId = $("#userId").val(); 
    
    if(($("#userId").val().length >0) || ($("#inputPassword").val().length >0)){
        $.ajax({type: "POST",
            url: "/content/we-train/en/j_security_check",
            data: { j_username: $("#userId").val(), j_password: $("#inputPassword").val(),j_validate: "true" },
            success:function(data,textStatus,jqXHR ){
            window.location.href = $("#redirectURL").val();
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
            bootbox.alert("Invalid Input or Password");
        }});
    } else{
        bootbox.alert("Invalid Input");
    }
});   
});