//Custom JQuery Revolving Gallery. @author ojp5
 var pos = 1;
  function galleryTick() {
    if(pos >= $( ".gallery li").length) {
      $( ".gallery li:nth-child(" + pos + ")" ).fadeOut(function() {
        $( ".gallery li:nth-child(1)" ).fadeIn();
      });
      pos = 1;
    }
    else {
      $( ".gallery li:nth-child(" + pos + ")" ).fadeOut(function() {
        pos++;
        $( ".gallery li:nth-child(" + pos + ")" ).fadeIn();
      });
    }
  }
  setInterval(galleryTick,6000);