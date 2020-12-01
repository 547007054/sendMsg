layui.use(['table', 'form', 'layer', 'admin'], function () {
    // 操作对象
    var form = layui.form;
    var table = layui.table;
    var layer = layui.layer;
    var admin = layui.admin;
    var $ = layui.jquery

 /*   // 表格渲染
    var userTable = table.render({
        id: 'userTableId',
        title: '用户信息列表',
        elem: '#userTable',
        height: 862,
        cellMinWidth: 180,
        url: getProjectUrl() + '/upms/user/getUserList',
        page: true,
        loading: true,
        smartReloadModel: true,
        singleSelect: false,
        limit: 20,
        limits: [20, 50, 100],
        request: {
            pageName: 'pageNo',
            limitName: 'pageSize'
        },
        response: {
            statusCode: 200
        },
        parseData: function (result) {
            return {
                "code": result.code,
                "msg": result.msg,
                "count": result.data.total,
                "data": result.data.rows
            };
        },
        cols: [[
            {type: 'numbers', title: '序号', align: 'center', width: 80, fixed: 'left'},
            {field: 'username', title: '账号', align: 'left', width: 200, fixed: 'left'},
            {field: 'nickname', title: '昵称', align: 'left', width: 200, fixed: 'left'},
            {field: 'email', title: '邮件', align: 'left', width: 200},
            {field: 'phone', title: '电话', align: 'left', width: 200},
            {field: 'locked', title: '是否锁定', align: 'center', width: 120, templet: '#lockedTpl', unresize: true},
            {field: 'description', title: '描述', align: 'left'},
            {field: 'createDate', title: '创建日期', align: 'center', width: 180},
            {templet: '#tableBar', title: '操作', align: 'left', width: 180, fixed: 'right'}
        ]]
    });

    form.on('checkbox(lockedCheckBox)', function (obj) {
        var lockedCheckBox = obj.elem.checked;
        var username = this.value;
        var locked = lockedCheckBox == true ? -1 : 1;

        get('/upms/user/updateUserLockedByUserId/' + username + '/' + locked, function (result) {
            if (result.code == 200) {
                layer.msg(result.msg, {icon: 1});
            } else {
                layer.msg(result.msg, {icon: 2});
            }
        });
    });

    table.on('row(userTable)', function (obj) {
        obj.tr.addClass('layui-table-click').siblings().removeClass('layui-table-click');
    });

    // 工具条点击事件
    table.on('tool(userTable)', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            showEditModel(2, data);
        } else if (layEvent === 'del') {
            doDel(data.id, data.nickname);
        } else if (layEvent === 'pwd') {
            doPwd(data.username);
        }
    });

    // 添加采集设备
    $('#addBtn').on('click', function () {
        showEditModel(1, null);
    });

    // 显示表单弹窗
    function showEditModel(type, data) {
        admin.open({
            type: 1,
            area: '450px',
            title: (type == 2 ? '修改' : '添加') + '用户信息',
            content: $('#modelUser').html(),
            success: function (dLayer, dIndex) {
                $(dLayer).children('.layui-layer-content').css('overflow', 'visible');
                var url = type == 1 ? '/upms/user/addUser' : '/upms/user/updateUser';

                if (type == 2) {
                    $('#username').attr("readonly", "readonly")
                    $("#passwordDiv").attr("style", "display:none;");
                    $("#rePasswordDiv").attr("style", "display:none;");
                    $("#roleDiv").attr("style", "display:none;");
                    form.val('modelUserForm', data);
                }

                form.render();
                form.on('submit(modelUserSubmit)', function (data) {
                    post(url, JSON.stringify(data.field), function (result) {
                        if (result.code == 200) {
                            layer.close(dIndex);
                            layer.msg(result.msg, {icon: 1});
                            userTable.reload()
                        } else {
                            layer.msg(result.msg, {icon: 2});
                        }
                    });
                    return false;
                });
            }
        });
    }

    // 删除用户信息
    function doDel(id, nickname) {
        top.layer.confirm('确定要删除用户“' + nickname + '”吗？', {
            skin: 'layui-layer-admin'
        }, function (index) {
            top.layer.close(index);
            get('/upms/user/deleteUserById/' + id, function (result) {
                if (result.code == 200) {
                    layer.msg(result.msg, {icon: 1});
                    userTable.reload();
                } else {
                    layer.msg(result.msg, {icon: 2});
                }
            });
        });
    }

    // 重置密码
    function doPwd(name) {
        admin.open({
            type: 1,
            area: '450px',
            title: '重置用户密码',
            content: $('#modelUserPwd').html(),
            success: function (dLayer, dIndex) {
                $(dLayer).children('.layui-layer-content').css('overflow', 'visible');
                $('#username1').val(name);
                form.on('submit(modelUserPwdSubmit)', function () {
                    var username = $('#username1').val();
                    var password = $('#password1').val();
                    var rePassword = $('#rePassword1').val();

                    if (password == '') {
                        layer.msg('密码不能为空！', {icon: 2});
                        return false;
                    }

                    if (password != rePassword) {
                        layer.msg('两次输入密码不一致！', {icon: 2});
                        return false;
                    }

                    get('/upms/user/restUserPwd/' + username + '/' + password, function (result) {
                        if (result.code == 200) {
                            layer.close(dIndex);
                            layer.msg(result.msg, {icon: 1});
                            userTable.reload()
                        } else {
                            layer.msg(result.msg, {icon: 2});
                        }
                    });
                    return false;
                });
            }
        });
    }

    // 搜索功能的实现
    $('#searchBtn').on('click', function () {
        var loginName = $('#loginName').val();
        if (loginName == '') {
            layer.msg('请选择搜索条件');
            return false;
        }
        userTable.reload({where: {username: loginName}});
    });

    // 刷新
    $('#refreshBtn').on('click', function () {
        userTable.reload();
    });*/

});