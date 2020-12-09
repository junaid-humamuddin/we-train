$(window).adaptTo("foundation-registry").register("foundation.validation.validator", {
  selector: "[data-should-contain]",
  validate: function(el) {
    var shouldContain = el.getAttribute("data-should-contain");  //aem

    console.log('validating text contains aem');
    console.log('input should contain ' + shouldContain);

    var input = el.value;  //input added by author

    if (input.indexOf(shouldContain) === -1 ) {
      return "The field should contain " + shouldContain + ". It's current value is " + el.value + ".";
    }
  }
});