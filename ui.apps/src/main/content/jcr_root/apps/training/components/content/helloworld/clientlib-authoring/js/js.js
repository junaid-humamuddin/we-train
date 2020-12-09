console.log('Client library called');

$(document).on("foundation-contentloaded", function(e){
    var container = e.target; 
    console.log('foundation-contentloaded was fired');
    console.log(container);
});