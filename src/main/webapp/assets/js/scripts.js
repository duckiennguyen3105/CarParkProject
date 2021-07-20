function showMessageSuccess(message){
    document.querySelector('.update-message').classList.remove('result-hidden');
    const resultTitle = document.querySelector("#message>#resultMessage");
    resultTitle.innerHTML = message;
    sleep(1000).then(() => {
        document.querySelector('.update-message').classList.add('result-hidden');
    });
}

function sleep (time) {
    return new Promise((resolve) => setTimeout(resolve, time));
}

function btnUpdateClick(tag) {
    showMessageSuccess("Update successful!");
    if (document.getElementById(tag)) {
        setTimeout("submitForm()", 1000);
    }
}

function submitForm() {
    document.getElementById("myForm").submit();
}

function resetForm(tag){
    showMessageSuccess("Reset successful!");
    document.getElementById(tag).reset();
}


function btnAddContentClick(tag) {
    showMessageSuccess("Add successful!");
    if (document.getElementById(tag)) {
        setTimeout("submitFormContent()", 1000);
    }
}

function submitFormContent() {
    document.getElementById("formContent").submit();
}

function btnUpdateContentClick(tag) {
    showMessageSuccess("Update successful!");
    if (document.getElementById(tag)) {
        setTimeout("submitFormContent()", 1000);
    }
}


function checkRegister(){
    let check1 = checkUsername("username", "invalid-username");
    let check2 = checkPassword("password",  "invalid-password")
    let check3 = checkConfirmPassword("confirm_password",  "invalid-confirm-password")
    let check4 = checkEmail();
    if(check1 && check2 && check3 && check4){
        return confirm("Do you want to register?")
    }else{
        return false;
    }
}

function doubleCheckPasswordRetype(){
    let passwordMain = document.getElementById("password").value;
    let RegisterFormRePassword = document.getElementById("RegisterFormRePassword").value;
    console.log(passwordMain === RegisterFormRePassword);
    if (passwordMain === RegisterFormRePassword){
        document.getElementById("invalid-re-password").style.display = "none";
        return true;
    }else{
        document.getElementById("invalid-re-password").style.display = "block";
        return false;
    }
}

function checkEditProfile(){
    let check1 = checkName("firstname", "invalid-firstname");
    let check2 = checkName("lastname", "invalid-lastname");
    let check3 = checkTelephone();
    if(check1 && check2 && check3){
        return confirm("Do you want to update?")
    }else{
        return false;
    }
}

function checkUsername(id, idFeedback){
    let name = document.getElementById(id).value;
    let regex = /^[a-zA-Z0-9]+$/;
    if(!regex.test(name)){
        document.getElementById(idFeedback).style.display = "block";
        return false;
    }else{
        document.getElementById(idFeedback).style.display = "none";
        return true;
    }
}

function checkPassword(id, idFeedback){
    let name = document.getElementById(id).value;
    let regex = /^[A-Za-z]\w{7,14}$/;
    if(!regex.test(name)){
        document.getElementById(idFeedback).style.display = "block";
        return false;
    }else{
        document.getElementById(idFeedback).style.display = "none";
        return true;
    }
}
function checkConfirmPassword(id, idFeedback){
    let name = document.getElementById(id).value;
    let regex = /^[A-Za-z]\w{7,14}$/;
    if(!regex.test(name)){
        if (name !== document.getElementById(id).value){
            document.getElementById("Not Match!").style.display = "block";
            return false;
        }
        document.getElementById(idFeedback).style.display = "block";
        return false;
    }else{
        document.getElementById(idFeedback).style.display = "none";
        return true;
    }
}



function checkEmail(){
    let email = document.getElementById("email").value;
    let regex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/i;
    if(!regex.test(email)){
        document.getElementById("invalid-email").style.display = "block";
        return false;
    }else{
        document.getElementById("invalid-email").style.display = "none";
        return true;
    }
}


function checkTelephone(){
    let phone = document.getElementById("telephone").value;
    let regex = /^\d{10,11}$/i;
    if(!regex.test(phone)){
        document.getElementById("invalid-phone").style.display = "block";
        return false;
    }else{
        document.getElementById("invalid-phone").style.display = "none";
        return true;
    }
}
function checkName(id, idFeedback){
    let name = document.getElementById(id).value;
    let regex = /^[A-Za-z]{1,20}$/i;
    if(!regex.test(name)){
        document.getElementById(idFeedback).style.display = "block";
        return false;
    }else{
        document.getElementById(idFeedback).style.display = "none";
        return true;
    }
}



function myFunction() {
    // Declare variables
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("search-input");
    filter = input.value.toUpperCase();
    table = document.getElementById("myTable");
    tr = table.getElementsByTagName("tr");

    // Loop through all table rows, and hide those who don't match the search query
    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[0];
        if (td) {
            txtValue = td.textContent || td.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}
