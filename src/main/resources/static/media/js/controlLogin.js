
 var canGetCookie = 1;//是否支持存储Cookie 0 不支持 1 支持

var CodeVal = 0;
Code();
function Code() {
    if(canGetCookie === 1){
        createCode("AdminCode");
        var AdminCode = getCookieValue("AdminCode");
        showCheck(AdminCode);
    }else{
        showCheck(createCode(""));
    }
}
function showCheck(a) {
    CodeVal = a;
    var c = document.getElementById("myCanvas");
    var ctx = c.getContext("2d");
    ctx.clearRect(0, 0, 1000, 1000);
    ctx.font = "80px 'Hiragino Sans GB'";
    ctx.fillStyle = "#E8DFE8";
    ctx.fillText(a, 0, 100);
}
$(document).keypress(function (e) {
    // 回车键事件
    if (e.which == 13) {
        $('input[type="button"]').click();
    }
});
//粒子背景特效
$('body').particleground({
    dotColor: '#E8DFE8',
    lineColor: '#1b3273'
});
$('input[name="pwd"]').focus(function () {
    $(this).attr('type', 'password');
});
$('input[type="text"]').focus(function () {
    $(this).prev().animate({ 'opacity': '1' }, 200);
});
$('input[type="text"],input[type="password"]').blur(function () {
    $(this).prev().animate({ 'opacity': '.5' }, 200);
});
$('input[name="login"],input[name="pwd"]').keyup(function () {
    var Len = $(this).val().length;
    if (!$(this).val() == '' && Len >= 5) {
        $(this).next().animate({
            'opacity': '1',
            'right': '30'
        }, 200);
    } else {
        $(this).next().animate({
            'opacity': '0',
            'right': '20'
        }, 200);
    }
});
$("#denglu").click(function () {
    var login = $("#username").val();
    var pwd = $("#password").val();
    var code = $('.ValidateNum').val();
    var JsonData = {username: login, password: pwd};
    //判断验证码是否正确，正确发送请求验证账号密码
    if (code== getCookieValue("AdminCode")) {
        $.post("/api/admin/login.do", JsonData,
            function (data) {
                if (data.code === 200) {
                    location.href="/after/index1.html";
                }else {
                    $("#msg").text(data.data)
                }

            })
    }
    else {
        var msg = new Vue({
            el: '#msg',
            data: {
                message: '验证码错误'
            }
        })
        $("#msg").text("验证码错误")
    }

})
