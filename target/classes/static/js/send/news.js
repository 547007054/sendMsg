layui.use(['layer', 'form', 'upload'], function () {
    var $ = layui.jquery;
    var layer = layui.layer;
    var form = layui.form;
    var upload = layui.upload;
    var uploadPic;//上传封面图片返回结果

    $('#sendMsg').on('click', function () {
        var obj = new Object();
        obj.touser = $('#touser').val();
        obj.toparty = $('#toparty').val();
        obj.totag = $('#totag').val();
        obj.title = $('#title').val();
        obj.content = document.getElementById("content").innerHTML
        obj.author = $('#author').val();
        obj.url = $('#url').val();
        if(obj.touser==""){
            layer.msg("接收人不可为空!", {icon: 2});
        }else if(obj.title==""){
            layer.msg("标题不可为空!", {icon: 2});
        }else if(uploadPic!="成功！"){
            layer.msg("封面图片不可为空!", {icon: 2});
        }else{
            post('/send/news/sendMsg', JSON.stringify(obj), function (result) {
                if (result.code == 200) {
                    layer.msg(result.msg, {icon: 1});
                } else {
                    layer.msg(result.msg, {icon: 2});
                }
            })
        }
    });
    $('#addPicBtn').on('click', function () {
        importModel();
    });
    $('#insetPicBtn').on('click', function () {
        insertModel();
    });
    // 弹出上传封面图片文件框
    function importModel() {
        layer.open({
            type: 1,
            area: '600px',
            title: '添加封面图片',
            content: $('#modelImport').html(),
            success: function (dLayer, dIndex) {
                $(dLayer).children('.layui-layer-content').css('overflow', 'visible');
                var lIndex;
                var uploadUrl= 'E:/';
                upload.render({
                    elem: '#file',
                    url: '/send/news/upload',
                    accept:'images',
                    auto: false,
                    bindAction: '#startUpload',
                    data: {
                        fileUrl:uploadUrl
                    },
                    before: function (obj) {
                        lIndex = layer.msg('正在导入...', {
                            icon: 16,
                            shade: 0.01,
                            time: -1
                        });
                        layer.style(lIndex, {
                            border: 'none'
                        });
                    },
                    done: function (res, index, upload) {
                        layer.close(lIndex);
                        if (res.code == 200) {
                            console.log("上传图片返回结果："+res.data)
                            uploadPic = res.data;
                            layer.close(dIndex);
                            layer.msg(res.msg, {icon: 1});
                        } else {
                            layer.msg(res.msg, {icon: 2});
                        }
                    },
                    error: function (index, upload) {
                        layer.close(lIndex);
                        layer.msg('系统繁忙，请稍后再试！', {icon: 2});
                    }
                });
            }
        });
    }

    // 弹出插入图片文件框
    function insertModel() {
        layer.open({
            type: 1,
            area: '600px',
            title: '插入图片',
            content: $('#modelImport').html(),
            success: function (dLayer, dIndex) {
                $(dLayer).children('.layui-layer-content').css('overflow', 'visible');
                var lIndex;
                var InsertUrl= 'E:/';
                upload.render({
                    elem: '#file',
                    url: '/send/news/uploadIPC',
                    accept:'images',
                    auto: false,
                    bindAction: '#startUpload',
                    data: {
                        fileUrl:InsertUrl
                    },
                    before: function (obj) {
                        obj.preview(function(index, file, result){
                        });
                        lIndex = layer.msg('正在导入...', {
                            icon: 16,
                            shade: 0.01,
                            time: -1
                        });
                        layer.style(lIndex, {
                            border: 'none'
                        });
                    },
                    done: function (res, index, upload) {
                        layer.close(lIndex);
                        if (res.code == 200) {
                            console.log("插入图片返回结果："+res.data)
                            $("p").append("<img src="+res.data+">");
                          //  console.log(document.getElementById('content').value)
                            layer.close(dIndex);
                            layer.msg(res.msg, {icon: 1});
                        } else {
                            layer.msg(res.msg, {icon: 2});
                        }
                    },
                    error: function (index, upload) {
                        layer.close(lIndex);
                        layer.msg('系统繁忙，请稍后再试！', {icon: 2});
                    }
                });
            }
        });
    }
    //表单初始赋值
    form.val('info', {
        "toparty": "@all",
        "totag": "@all"
    })
    // 刷新
    $("#refreshBtn").on('click',function () {
        location.reload();
    })
})