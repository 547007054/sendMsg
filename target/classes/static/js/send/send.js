layui.use(['layer', 'form', 'upload'], function () {
    var $ = layui.jquery;
    var layer = layui.layer;
    var form = layui.form;
    //发送信息
    $("#sendmsg").on('click',function () {
        var obj = new Object();
        obj.msgtype = $('#msgtype').val();
        obj.touser = $('#touser').val();
        obj.toparty = $('#toparty').val();
        obj.totag = $('#totag').val();
        obj.content = $('#textContent').val();
        if($('#textContent').val()!=null){
            post('/send/send/sendMsg', JSON.stringify(obj), function (result) {
                if (result.code == 200) {
                    layer.msg(result.msg, {icon: 1});
                } else {
                    layer.msg(result.msg, {icon: 2});
                }
            })
        }
    })
    //表单初始赋值
    form.val('info', {
        "toparty": "@all",
        "totag": "@all",
        "msgtype": "text"
    })
    // 刷新
    $("#refreshBtn").on('click',function () {
        location.reload();
    })
})
