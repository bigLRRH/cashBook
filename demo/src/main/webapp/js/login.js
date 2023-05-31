function login_check() {
    var loginname = document.getElementById("loginname");
    var loginpwd = document.getElementById("loginpwd");
    var username_pattern = /^\w{3,16}$/;//表示数字,字母,下划线，3-15位
    var password_pattern = /^(?=.*[a-zA-Z])(?=.*\d).{6,16}$/;//至少包含字母、数字，8-127位
    if (!username_pattern.test(loginname.value)) {
        alert("用户名错误");
        return false;
    }
    if (!password_pattern.test(loginpwd.value)) {
        alert("密码错误");
        return false;
    }
    return true;
}