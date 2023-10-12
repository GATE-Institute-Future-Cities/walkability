function isCheckedOneOne() {
    let questionOne = document.getElementById('A21');
    let questionTwo = document.getElementById('A22');
    let questionThree = document.getElementById('A23');
    let questionFour = document.getElementById('A24');
    let questionFive = document.getElementById('A25');
    let questionSix = document.getElementById('A26');
    let questionSeven= document.getElementById('A27');
    questionOne.checked = false;
    questionTwo.checked = false;
    questionThree.checked = false;
    questionFour.checked = false;
    questionFive.checked = false;
    questionSix.checked = false;
    questionSeven.value = "";
}

function isCheckedOneTwo() {
    let questionOne = document.getElementById('A11');
    let questionTwo = document.getElementById('A12');
    let questionThree = document.getElementById('A13');
    let questionFour = document.getElementById('A14');
    let questionFive = document.getElementById('A15');
    let questionSix = document.getElementById('A16');
    let questionSeven= document.getElementById('A17');
    questionOne.checked = false;
    questionTwo.checked = false;
    questionThree.checked = false;
    questionFour.checked = false;
    questionFive.checked = false;
    questionSix.checked = false;
    questionSeven.value = "";
}

function isCheckedOneThree() {
    isCheckedOneOne();
    isCheckedOneTwo();
}

function isCheckedTwo() {
    let questionOne = document.getElementById('B11');
    let questionTwo = document.getElementById('B12');
    let questionThree = document.getElementById('B13');
    let questionFour = document.getElementById('B14');
    questionOne.checked = false;
    questionTwo.checked = false;
    questionThree.checked = false;
    questionFour.value = "";
}

function isCheckedThreeOne() {
    let questionOne = document.getElementById('C21');
    let questionTwo = document.getElementById('C22');
    let questionThree = document.getElementById('C23');
    let questionFour = document.getElementById('C24');
    let questionFive= document.getElementById('C25');
    questionOne.checked = false;
    questionTwo.checked = false;
    questionThree.checked = false;
    questionFour.checked = false;
    questionFive.value = "";
}

function isCheckedThreeTwo() {
    let questionOne = document.getElementById('C11');
    let questionTwo = document.getElementById('C12');
    let questionThree = document.getElementById('C13');
    let questionFour = document.getElementById('C14');
    let questionFive= document.getElementById('C15');
    questionOne.checked = false;
    questionTwo.checked = false;
    questionThree.checked = false;
    questionFour.checked = false;
    questionFive.value = "";
}

function isCheckedThreeThree() {
    isCheckedThreeOne();
    isCheckedThreeTwo();
}