layui.use(['index'], function () {
    var $ = layui.jquery;
    var index = layui.index;

    // 默认加载主页
    index.loadHome({
        menuPath: getProjectUrl() + '/upms/user',
        menuName: '<i class="layui-icon layui-icon-home"></i>',
        loadSetting: false
    });

});