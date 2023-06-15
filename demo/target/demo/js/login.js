var username_pattern = /^\w{3,20}$/;//username must be between 3 and 20 characters
var password_pattern = /^(?=.*[a-zA-Z])(?=.*\d).{8,16}$/;//password must be 8 and 16 characters
var verificationCode_pattern = /^(?=.*[a-zA-Z])(?=.*\d).{4}$/;//Verfication code must be 4 characters
async function login() {
    var username = document.getElementById("login_username").value;
    var password = document.getElementById("login_password").value;
    var verfication_code_answer = document.getElementById("verification_code_answer").value;
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
    // //判断验证码格式
    // if(!verificationCode_pattern.test(verfication_code_answer)){
    //     alert("Verfication code must be 4 characters");
    //     return;
    // }
    //验证码验证
    if (!await verificationCode_verify2(verfication_code_answer)) {
        alert("Please enter the correct verification code");
        verificationCode_reset1();
        return;
    }
    document.getElementById("login_form").submit();
}

function verificationCode_reset1() {
    var xhr = window.XMLHttpRequest ? new XMLHttpRequest() : ActiveXObject("Microsoft.XMLHTTP");
    xhr.open("GET", "../vcs?action=reset", true);
    xhr.onreadystatechange = function () {//监听
        document.getElementById("verification_code").value = xhr.getResponseHeader("VerificationCode");
    }
    xhr.send(null);
}
//未采用
async function verificationCode_reset2()
{
    url = "../vcs?action=reset";
    response = await fetch(url);
    document.getElementById("verification_code").value = response.headers.get("VerificationCode");
}

//不知道有什么bug
async function verificationCode_verify1(answer) {
    var xmlhttp = window.XMLHttpRequest ? new XMLHttpRequest() : ActiveXObject("Microsoft.XMLHTTP");
    xmlhttp.open("GET", "../vcs?action=verify&answer=" + answer, true);
    var flag;
    await new Promise((resolve,reject)=>{
        xmlhttp.onreadystatechange = function () {//监听
            flag = xmlhttp.getResponseHeader("verify");
            resolve();
        }
    })
    xmlhttp.send(null);
    return flag = "true" ? true : false;
}
//fetch
async function verificationCode_verify2(answer) {
  var url = "../vcs?action=verify&answer="+ answer;
  var response = await fetch(url);
  var flag = response.headers.get("verify");
  return flag == "true" ? true : false;
}