$(document).ready(function() {
    $(".menu-icon").on("click", function() {
        $("nav ul").toggleClass("showing");
    });
});


function updateLanguage() {
    var selectElement = document.getElementById("locales");
    var selectedValue = selectElement.value;
    console.log(selectedValue);
    var currentUrl = window.location.href;

    if (currentUrl.includes("?language=")) {
        currentUrl = currentUrl.replace(/(\?language=)[^\&]+/, "$1" + selectedValue);
    } else {

        currentUrl += "?language=" + selectedValue;
    }

    localStorage.setItem("selectedLanguage", selectedValue);

    window.location.href = currentUrl;

    loadLanguage();
}

function loadLanguage() {
    var selectedLanguage = localStorage.getItem("selectedLanguage");
    if (selectedLanguage) {
        document.getElementById("locales").value = selectedLanguage;
    }
}