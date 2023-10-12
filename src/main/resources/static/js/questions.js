$(function () {
    IsChecked();
})
$("input[type='radio']").change(function () {
    IsChecked();
})

function IsChecked() {
    if ($("#gridOption2").prop('checked')) {
        $("#checkbox_0").removeAttr("disabled");
        $("#checkbox_1").removeAttr("disabled");

    } else {
        $("#checkbox_0").attr("disabled", "disabled");
        $("#checkbox_1").attr("disabled", "disabled");
    }
}

$('input.submitForm').change(function (t) {
    if ($(t)[0].target.checked) {
        $("#myForm").submit();
    }
});
