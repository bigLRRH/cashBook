var username_pattern = /^\w{3,20}$/;//username must be between 3 and 20 characters
var password_pattern = /^(?=.*[a-zA-Z])(?=.*\d).{8,16}$/;//password must be 8 and 16 characters
var mobileNumber_pattern = /^\d{11}$/
function signup_check() {
    var username = document.getElementById("signup_username").value;
    var password = document.getElementById("signup_password").value;
    var mobileNumber = document.getElementById("signup_mobileNumber").value;
    var confirmPassword = document.getElementById("signup_confirmPassword").value;
    if (!mobileNumber_pattern.test(mobileNumber)) {
        alert("Mobile number must be 11 numbers");
        return false;
    }
    if (!username_pattern.test(username)) {
        alert("Username must be between 3 and 20 characters");
        return false;
    }
    if (!password_pattern.test(password)) {
        alert("Password must be between 8 and 16 characters");
        return false;
    }
    if (!password.value === confirmPassword) {
        alert("Two passwords are inconsistent");
        return false;
    }
    return true;
}