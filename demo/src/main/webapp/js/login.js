var username_pattern = /^\w{3,20}$/;//username must be between 3 and 20 characters
var password_pattern = /^(?=.*[a-zA-Z])(?=.*\d).{8,16}$/;//password must be 8 and 16 characters

var xmlhttp = window.XMLHttpRequest ? new XMLHttpRequest() : ActiveXObject("Microsoft.XMLHTTP");


function login() {
    var username = document.getElementById("login_username").value;
    var password = document.getElementById("login_password").value;
    var verfication_code_answer = document.getElementById("login_password").value;
    //判断用户名格式
    if (!username_pattern.test(username)) {
        alert("Username must be between 3 and 20 characters");
        return;
    }
    //判断密码格式
    if (!password_pattern.test(password)) {
        alert("Password must be between 8 and 16 characters");
        return;
    }
    //验证码判断
    
}