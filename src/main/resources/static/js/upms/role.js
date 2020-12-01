layui.use(['layer','form','table','util','admin'],function () {
    var $ = layui.jquery;
    var layer = layui.layer;
    var form = layui.form;
    var table = layui.table;
    var util = layui.util;
    var admin = layui.admin;
    var height = $(window).height();
    var role = null;


    $('#permDiv').height(height - 98);
    // 渲染表格
    var roleTable=table.render({
        id: 'roleTable',
        title: '角色信息列表',
        elem: '#roleTable',
        height: height - 160,
        cellMinWidth: 180,
        url: getProjectUrl() + '/upms/role/getAllRole',
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
            {type: 'numbers', title: '序号', align: 'center', width: 60,fixed: 'left'},
            {field: 'roleName', title: '角色名称', align: 'center', width: 150,fixed: 'left'},
            {field: 'roleType', title: '角色类型', align: 'center', width: 100,fixed: 'left'},
            {field: 'description', title: '角色描述', align: 'center', width: 150,fixed: 'left'},
            {field: 'createTime', title: '创建时间', align: 'center', width: 162,fixed: 'left'},
            {templet: '#tableBar', align: 'center', title: '操作', width: 190,fixed: 'right'}
        ]]
    });
    // 添加
    $('#btnAdd').click(function () {
        showEditModel(1,null);
    });

    // 搜索
    $('#btnSearch').click(function () {
        roleTable.reload({where: {keyword: $('#edtSearch').val()}});
    });
    table.on('row(roleTable)', function (obj) {
        role = obj.data;
        obj.tr.addClass('layui-table-click').siblings().removeClass('layui-table-click');
    });
    // 工具条点击事件
    table.on('tool(roleTable)', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;
        if (layEvent === 'edit') { // 修改
            showEditModel(2,data);
        } else if (layEvent === 'delete') { // 删除
            doDel(obj);
        } else if (layEvent === 'perm') {
            showPermModel(data.id);
        }
    });

    // 删除
    function doDel(obj) {
        top.layer.confirm('确定要删除“' + obj.data.roleName + '”角色吗？', {
            skin: 'layui-layer-admin'
        }, function (i) {
            top.layer.close(i);
            get('/upms/role/deleteRoleById/'+obj.data.id,function (result) {
                if (result.code == 200) {
                    layer.msg(result.msg, {icon: 1});
                    roleTable.reload();
                } else {
                    layer.msg(result.msg, {icon: 2});
                }
            });
        });
    }

    // 显示编辑弹窗
    function showEditModel(type,data) {
        admin.open({
            type: 1,
            title: (type==2 ? '修改' : '添加') + '角色',
            content: $('#modelRole').html(),
            success: function (layero, dIndex) {
                var url = type == 1 ? '/upms/role/addRole' : '/upms/role/updateRole';
                form.val('modelRoleForm');
                if (type == 2) {
                  /*  form.val('modelRoleForm', data);// 回显数据*/
                    $("input[name='id']").val(data.id);
                    $("input[name='roleName']").val(data.roleName);
                    $("input[name='description']").val(data.description);
                    var len =$('input[name="roleType"]').length;
                    $('input[name="roleType"]').siblings('.layui-form-radio').removeClass('layui-form-radioed').find('i').html('&#xe63f;');
                    for(var i=0;i<len;i++){
                        if($('input[name="roleType"]').eq(i).val()==data.roleType){
                            $('input[name="roleType"]').eq(i).next().addClass('layui-form-radioed')
                           .find('i').html('&#xe643;');
                        }
                    }
                }
                // 表单提交事件
                form.on('submit(modelRoleSubmit)', function (data) {
                    post(url, JSON.stringify(data.field), function (result) {
                        if (result.code == 200) {
                            layer.close(dIndex);
                            layer.msg(result.msg, {icon: 1});
                            table.reload('roleTable');
                        } else {
                            layer.msg(result.msg, {icon: 2});
                        }
                    });
                    return false;
                });
            }
        });
    }
    function initTree() {
        get('/upms/permission/getAllPermission', function (result) {
            if (result.code == 200) {
                var setting = {
                    data: {
                        simpleData: {
                            enable: true,
                            idKey: "id",
                            pIdKey: "parentId",
                            rootPId: -1
                        }
                    },
                    check: {
                        enable: true,
                        autoCheckTrigger: true
                    }
                };
                $.fn.zTree.init($("#permTree"), setting, result.data);
            } else {
                layer.msg('权限加载失败！', {icon: 2});
            }
        });
    }
    initTree();
    // 权限管理
    function showPermModel(roleId) {
        get('/upms/role/getRolePermissionByRoleId/' + roleId, function (result) {
            if (result.code == 200) {
                if (result.data != null) {
                    var treeObj = $.fn.zTree.getZTreeObj("permTree");
                    var nodes = treeObj.transformToArray(treeObj.getNodes());

                    treeObj.checkAllNodes(false);
                    $.each(nodes, function (i, node) {
                        $.each(result.data, function (i1, perm) {
                            if (node.id == perm.permissionId) {
                                treeObj.checkNode(node, true, false);
                                return true;
                            }
                        });
                    });
                }
            } else {
                layer.msg('权限加载失败！', {icon: 2});
            }
        });
    }
    // 授权
    $('#permBtn').on('click', function () {
        var treeObj = $.fn.zTree.getZTreeObj("permTree");
        var nodes = treeObj.getChangeCheckedNodes();
        if (nodes.length == 0) {
            layer.msg('请选择您需要赋予权限信息！', {icon: 2});
            return false;
        }

        if (role == null) {
            layer.msg('请选择角色信息！', {icon: 2});
            return false;
        }

        top.layer.confirm('您确定要给该权限赋予权限吗？', {
            skin: 'layui-layer-admin'
        }, function (index) {
            top.layer.close(index);

            var permissionIds = '';
            $.each(nodes, function (i, node) {
                permissionIds += node.id + ',';
            });

            get('/upms/role/roleAuthorization/' + role.id + '/' + permissionIds, function (result) {

                if (result.code == 200) {
                    layer.msg('角色授权成功！', {icon: 1});
                } else {
                    layer.msg('角色授权失败！', {icon: 2});
                }
            });
        });
    });

    // 全选
    $('#allBtn').on('click', function () {
        var treeObj = $.fn.zTree.getZTreeObj("permTree");
        treeObj.checkAllNodes(true);
    });

})