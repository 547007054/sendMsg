layui.use(['layer'], function () {

    var uuid = Math.uuid();
    var $ = layui.jquery;

    // 图形验证码
    $('#login-captcha').attr("src", getProjectUrl() + "/kaptcha?randomStr=" + uuid);
    $('#login-captcha').attr("style", "");

    // 图形验证码
    $('#login-captcha').click(function () {
        this.src = this.src;
    });

    $('#username').on('focus keyup blur', function (e) {
        var $this = $(this);

        if (e.type == 'keyup') {
            console.log('keyup')

            if ($this.val() === '') {
                $(".imguser").attr("src", "/static/images/user.png");
            } else {
                $(".imguser").attr("src", "/static/images/bUser.png");
            }
        } else if (e.type == 'blur') {
            console.log('blur')

            if ($this.val() === '') {
                $(".imguser").attr("src", "/static/images/user.png");
            } else {
                $(".imguser").attr("src", "/static/images/bUser.png");
            }
        } else if (e.type == 'focus') {
            console.log('focus')
            if ($this.val() === '') {
                $(".imguser").attr("src", "/static/images/user.png");
            } else if ($this.val() !== '') {
                $(".imguser").attr("src", "/static/images/bUser.png");
            }
        }
    });

    $('#password').on('focus keyup blur ', function (e) {
        var $this = $(this);
        if (e.type == 'keyup') {
            if ($this.val() == '') {
                $(".imgpsd").attr("src", "/static/images/password.png");
            } else {
                $(".imgpsd").attr("src", "/static/images/bPassword.png");
            }
        } else if (e.type == 'blur') {
            if ($this.val() == '') {
                $(".imgpsd").attr("src", "/static/images/password.png");
            } else {
                $(".imgpsd").attr("src", "/static/images/bPassword.png");
            }
        } else if (e.type == 'focus') {
            if ($this.val() == '') {
                $(".imgpsd").attr("src", "/static/images/password.png");
            } else if ($this.val() != '') {
                $(".imgpsd").attr("src", "/static/images/bPassword.png");
            }
        }
    });

    $('#kaptcha').on('focus keyup blur ', function (e) {
        var $this = $(this);
        if (e.type === 'keyup') {
            if ($this.val() === '') {
                $(".imgCode").attr("src", "/static/images/code.png");
            } else {
                $(".imgCode").attr("src", "/static/images/bCode.png");
            }
        } else if (e.type === 'blur') {
            if ($this.val() === '') {
                $(".imgCode").attr("src", "/static/images/code.png");
            } else {
                $(".imgCode").attr("src", "/static/images/bCode.png");
            }
        } else if (e.type === 'focus') {
            if ($this.val() === '') {
                $(".imgCode").attr("src", "/static/images/code.png");
            } else if ($this.val() !== '') {
                $(".imgCode").attr("src", "/static/images/bCode.png");
            }
        }
    });

    $('.change_lf img').on('click', function () {
        if ($(this).attr("src") == "/static/images/ok-normal.png") {
            $(this).attr("src", "/static/images/ok-active.png")
        } else if ($(this).attr("src") == "/static/images/ok-ative.png") {
            $(this).attr("src", "/static/images/ok-normal.png")
        }
    });

    var username = localStorage.getItem("ztjs_username");
    $('#username').val(username);

    var password = localStorage.getItem("ztjs_password");
    $('#password').val(password);

    $('#btnLogin').on('click', function () {
        var username = $('#username').val();
        if (username == '') {
            layer.tips('请输入用户名！', $('#username'), {
                tips: [1, '#E81123'],
                time: 4000
            });
            return false;
        }

        var password = $('#password').val();
        if (password == '') {
            layer.tips('请输入密码！', $('#password'), {
                tips: [1, '#E81123'],
                time: 4000
            });
            return false;
        }

        var kaptcha = $('#kaptcha').val();
        if (kaptcha == '') {
            layer.tips('请输入验证码！', $('#kaptcha'), {
                tips: [1, '#E81123'],
                time: 4000
            });
            return false;
        }

        var index = layer.msg('请求处理中...', {
            icon: 16,
            shade: 0.01,
            time: -1
        });
        layer.style(index, {
            border: 'none'
        });

        var data = {
            "username": username,
            "password": password,
            "kaptcha": kaptcha,
            "randomStr": uuid
        };

        $.ajax({
            url: getProjectUrl() + '/loginForm',
            data: data,
            type: 'POST',
            'complete': function () {
                layer.close(index);
            },
            success: function (result) {
                if (result.code == 200) {
                    localStorage.clear();
                    if ($('.change-ok-img').attr("src") == getProjectUrl() + "/static/images/ok-active.png") {
                        localStorage.setItem("ztjs_username", username);
                        localStorage.setItem("ztjs_password", password);
                    }

                    layer.msg(result.msg, {icon: 1, time: 1000}, function () {
                        location.replace(getProjectUrl() + "index");
                    });
                } else {
                    $('#kaptcha').val('');
                    $('#login-captcha').attr("src", getProjectUrl() + "/kaptcha?randomStr=" + uuid);
                    layer.msg(result.msg, {icon: 5, time: 2000});
                }
            },
            error: function (xhr) {
                $('#kaptcha').val('');
                $('#login-captcha').attr("src", getProjectUrl() + "/kaptcha?randomStr=" + uuid);
                layer.msg('系统繁忙, 请稍后再试！', {icon: 5, time: 2000});
            }
        });
    });

});