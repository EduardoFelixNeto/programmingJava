var start = null;
var hide = null;

function uploadStart(){
  var fileinput = document.getElementById("finput");
  var filename = fileinput.value;
  start = new SimpleImage(fileinput);
  startclone = new SimpleImage(fileinput);
  var canvas = document.getElementById("can");
  start.drawTo(canvas);
}
function uploadHide(){
  var fileinput = document.getElementById("binput");
  var filename = fileinput.value;
  hide = new SimpleImage(fileinput);
  var canvas1 = document.getElementById("can1");
  hide.drawTo(canvas1)
}
//stehanography
function clearbits(colorval){
  //compute the same color value whith the low bits zeroed
  var x = Math.floor(colorval/16)*16;
  return x;
}
function chop2hide(){
  //for each pixel in the image
  for(var px of start.values()){
    //clear the low bits of red
    px.setRed(clearbits(px.getRed()));
    //clear the low bits of green
    px.setGreen(clearbits(px.getGreen()));
    //clear the low bits of blue
    px.setBlue(clearbits(px.getBlue()));
  }
  //after doing each pixel return the image as the answer
  var canvas3 = document.getElementById("can3");
  start.drawTo(canvas3);
}
function shift(){
  //for each pixel in the image
  for(var px of hide.values()){
    //shift the red bits over
    px.setRed(px.getRed()/16);
    //shift the green bits over
    px.setGreen(px.getGreen()/16);
    //shift the blue bits over
    px.setBlue(px.getRed()/16);
  }
  //after doing each pixel return the image as the answer
  var canvas4 = document.getElementById("can4");
  hide.drawTo(canvas4);
}
function combine(){
  //make a new image the same size as show
  var answer = new SimpleImage(start.getWidth(), start.getHeight());
  //for each pixel in answer
  for(var px of answer.values()){
    //get the x and y of that pixel
    var x = px.getX();
    var y = px.getY();
    //get the pixel in the same place from show
    var showPixel = start.getPixel(x,y);
    //get the pixel in the same place from hide
    var hidePixel = hide.getPixel(x,y);
    //set the red of px to the sum of showPixel's red + hidePixel's red
  px.setRed(showPixel.getRed() + hidePixel.getRed());
    //set the red of px to the sum of showPixel's green + hidePixel's green
  px.setGreen(showPixel.getGreen() + hidePixel.getGreen());
    //set the red of px to the sum of showPixel's blue + hidePixel's blue
  px.setBlue(showPixel.getBlue() + hidePixel.getBlue());
  }
  var canvas2 = document.getElementById("can2");
  answer.drawTo(canvas2)
}
//var start = new SimpleImage("usain.jpg");
//var hide = new SimpleImage("skyline.jpg");
//
//start = chop2hide(start);
//hide = shift(hide);
//var ans = combine(start,hide);
//print(ans);