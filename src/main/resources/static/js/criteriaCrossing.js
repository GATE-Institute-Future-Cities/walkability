var value1 = document.getElementById("h21").innerText;
var style1 = document.getElementById("circle1");

var value2 = document.getElementById("h22").innerText;
var style2 = document.getElementById("circle2");

var stringStyle1="stroke-dashoffset: calc(440 - (440*"+value1+")/100)";
var stringStyle2="stroke-dashoffset: calc(440 - (440*"+value2+")/100)";


style1.style=stringStyle1;
style2.style=stringStyle2;