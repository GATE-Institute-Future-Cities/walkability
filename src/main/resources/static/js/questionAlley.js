function isCheckedTwo() {
    let questionOne = document.getElementById('B21');
    let questionTwo = document.getElementById('B22');
    let questionThree = document.getElementById('B23');
    let questionFour = document.getElementById('B24');
    questionOne.checked = false;
    questionTwo.checked = false;
    questionThree.checked = false;
    questionFour.value = "";
}

function notVisit() {
    let div = document.getElementsByClassName("questionTwoClass");
    div[0].style.display = "none";
}

function Visit() {
    let questionOne = document.getElementById('B1');
    let questionTwo = document.getElementById('B2');
    questionOne.checked=false;
    questionTwo.checked=false;
    isCheckedTwo();
    let div = document.getElementsByClassName("questionTwoClass");
    console.log(div[0])
    div[0].style.display = "inline";
}