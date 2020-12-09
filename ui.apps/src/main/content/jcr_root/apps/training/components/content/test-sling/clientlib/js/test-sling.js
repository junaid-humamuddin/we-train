$(document)
		.ready(
				function() {
    
				//alert("Test Sling Alert");
                $.ajax({
                url: '/bin/getTestCongiguration',
                type: "GET",
                async : false,
                cache : false,
                dataType : "text",
                success: function(result) {
                    //bootbox.alert(result);
                    alert(result);
                }
            });
});