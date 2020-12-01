layui.use(['table', 'layer', 'admin', 'form',], function () {
    // 操作对象
    var form = layui.form;
    var table = layui.table;
    var layer = layui.layer;
    var admin = layui.admin;
    var $ = layui.jquery
    var height = $(window).height();

    // 表格渲染
    var dutyTable = table.render({
        id: 'dutyTable',
        elem: '#dutyTable',
        height: height - 160,
        cellMinWidth: 180,
        url: '/upms/duty/getDutyByParams',
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
            {type: 'numbers', title: '序号', align: 'center', width: 60},
            {
                field: 'type', title: '职务类型', align: 'center', width: 180, templet: function (d) {
                    return d.type == 1 ? '项目部职务' : '分公司';
                }
            },
            {field: 'dutyName', title: '职务名称', align: 'center', width: 200},
            {title: '操作', align: 'center', width: 175, templet: '#tableBar'}
        ]]
    });

    table.on('row(dutyTable)', function (obj) {
        obj.tr.addClass('layui-table-click').siblings().removeClass('layui-table-click');
    });

    form.on('select(type1)', function (data) {
        dutyTable.reload({where: {type: data.value, dutyName: $('#dutyName1').val()}});
    });

    // 添加按钮
    $("#addBtn").on("click", function () {
        showEditModel(1, null);
    });

    // 显示表单弹窗
    function showEditModel(type, data) {
        admin.open({
            type: 1,
            area: '450px',
            title: (type == 2 ? '修改' : '添加') + '职务信息',
            content: $('#modelDuty').html(),
            success: function (dLayer, dIndex) {
                $(dLayer).children('.layui-layer-content').css('overflow', 'visible');
                var url = type == 1 ? '/upms/duty/addDuty' : '/upms/duty/updateDuty';

                if (type == 2) {
                    form.val('modelDutyForm', data);
                }

                form.render('select');
                form.on('submit(modelDutySubmit)', function (data) {
                    post(url, JSON.stringify(data.field), function (result) {
                        if (result.code == 200) {
                            layer.close(dIndex);
                            layer.msg(result.msg, {icon: 1});
                            dutyTable.reload()
                        } else {
                            layer.msg(result.msg, {icon: 2});
                        }
                    });
                    return false;
                });
            }
        });
    }

    table.on('tool(dutyTable)', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            showEditModel(2, data);
        } else if (layEvent === 'del') {
            doDelete(data.id, data.dutyName);
        }
    });

    // 删除信息
    function doDelete(id, dutyName) {
        top.layer.confirm('确定要删除职务“' + dutyName + '”吗？', {
            skin: 'layui-layer-admin'
        }, function (index) {
            top.layer.close(index);
            get('/upms/duty/deleteDutyById/' + id, function (result) {
                if (result.code == 200) {
                    layer.msg(result.msg, {icon: 1});
                    dutyTable.reload();
                } else {
                    layer.msg(result.msg, {icon: 2});
                }
            });
        });
    }

    // 搜索功能的实现
    $('#searchBtn').on('click', function () {
        var type1 = $('#type1').val();
        var dutyName1 = $('#dutyName1').val();
        dutyTable.reload({where: {type: type1, dutyName: dutyName1}});
    });

    // 刷新
    $('#refreshBtn').on('click', function () {
        var type1 = $('#type1').val();
        var dutyName1 = $('#dutyName1').val();
        dutyTable.reload({where: {type: type1, dutyName: dutyName1}});
    });

});