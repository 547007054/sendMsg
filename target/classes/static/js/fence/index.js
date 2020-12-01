/**
 * Created by aa on 2019/9/9.
 */
layui.use(['layer','upload'], function () {
    var layer = layui.layer;
    var upload = layui.upload;
    var $ = layui.jquery;
    //弹出一个iframe层
    $('#textPush').on('click', function () {
        layer.open({
            type: 2,
            title: '文本推送',
            area: ['700px', '450px'],
            content: '../../../send/send.html'
        });
    });
    $('#picPush').on('click', function () {
        layer.open({
            type: 2,
            title: '图文推送',
            area: ['740px', '450px'],
            content: '../../../send/news.html'
        });
    });
    $('#informationImport').on('click', function () {
        var flag = sessionStorage.getItem("flag");
        var upload1 = layer.open({
            type: 1,
            title: '信息导入',
            area: ['700px', '460px'],
            content: '<div class="layui-upload-drag" id="upload"><i class="layui-icon"></i><p>点击选择文件，或将文件拖拽到此处</p></div><button type="button" class="layui-btn" id="beginUpload">开始上传</button>',
            success:function () {
                upload.render({
                    elem: '#upload'
                    ,url: '/fence/indexFence/excelImport'//上传文件接口
                    ,accept: 'file'
                    ,exts: 'xlsx|xls'
                    ,auto: false
                    ,bindAction: '#beginUpload'
                    ,done: function(result){
                        if(result.code == 200){
                            layer.msg(result.msg, {icon: 1});
                            layer.close(upload1);
                            // location.reload();
                        }else{
                            layer.msg(result.msg, {icon: 2});
                        }
                    }
                });
            }
        });
    });

});

