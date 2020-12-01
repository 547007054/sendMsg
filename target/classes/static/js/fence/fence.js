layui.use(['table', 'layer',  'form','upload'], function () {
    // 操作对象
    var form = layui.form;
    var table = layui.table;
    var layer = layui.layer;
    var upload = layui.upload;
    var $ = layui.jquery;
    var height = $(window).height();
    var poi;
    var map
    var styleOptions = {
        strokeColor:"red",    //边线颜色。
        fillColor:"red",      //填充颜色。当参数为空时，圆形将没有填充效果。
        strokeWeight: 3,       //边线的宽度，以像素为单位。
        strokeOpacity: 0.8,	   //边线透明度，取值范围0 - 1。
        fillOpacity: 0.6,      //填充的透明度，取值范围0 - 1。
        strokeStyle: 'solid' //边线的样式，solid或dashed。
    }
    // 表格渲染
    var fenceTable = table.render({
        id: 'fenceTable',
        elem: '#fenceTable',
        width: 335,
        // height: height-30,
        cellMinWidth: 60,
        url: '/fence/fence/getAllFence',
        loading: true,
        smartReloadModel: true,
        singleSelect: false,
        response: {
            statusCode: 200
        },
        parseData: function (result) {
            return {
                "code": result.code,
                "msg": result.msg,
                "data": result.data
            };
        },
        cols: [[
            {type: 'numbers', title: '序号', align: 'center', width: 60},
            {field: 'FENCE_NAME', title: '区域名称', align: 'center', width: 150},
            {title: '操作', align: 'center', width: 120, templet: '#tableBar'}
        ]]
    });
    table.on('row(fenceTable)', function (obj) {
        obj.tr.addClass('layui-table-click').siblings().removeClass('layui-table-click');
    });
    table.on('tool(fenceTable)', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;
        if (layEvent === 'search') {
            var fenceName = data.FENCE_NAME;
            get1('/fence/fence/getFence',{fenceName:fenceName},function (result) {
                var point=[];
                var item=result.data;
                var longitudeColumnLen;
                var minLng ;
                var maxLng;
                var minLat;
                var maxLat;
                var latitudeColumns=item.longitudeColumn.split(',');
                var longitudeColumn=item.latitudeColumns.split(',');
                longitudeColumnLen =longitudeColumn.length;
                minLng=longitudeColumn[0];
                maxLng=longitudeColumn[0];
                maxLat=latitudeColumns[0];
                minLat=latitudeColumns[0];
                for(var j=0;j<longitudeColumnLen;j++){
                    var lng=longitudeColumn[j];
                    var lat=latitudeColumns[j];
                    var pObj={};
                    pObj.lng=lng;
                    pObj.lat=lat;
                    point.push(pObj);
                    if(longitudeColumn[j]>maxLng){
                        maxLng=longitudeColumn[j]
                    }else if(longitudeColumn[j]<minLng){
                        minLng=longitudeColumn[j]
                    }
                    if(latitudeColumns[j]>maxLat){
                        maxLat=latitudeColumns[j]
                    }else if(latitudeColumns[j]<minLat){
                        minLat=latitudeColumns[j]
                    }
                }
                var cenLat=(parseFloat(maxLng)+parseFloat(minLng))/2;
                var cenLng = (parseFloat(maxLat)+parseFloat(minLat))/2;
                var obj={};
                cenLng=cenLng.toFixed(8);
                cenLat=cenLat.toFixed(8)
                obj.lng=cenLng;
                obj.lat=cenLat;
                showMap(obj);
                getFence();
            })
        } else if (layEvent === 'del') {
            doDelete(data.FENCE_NAME)
        }
    });
    showMap(null);
    getFence();
    function showMap(data) {
        //地图
       map = new BMap.Map('map');
        var geolocation = new BMap.Geolocation();
        geolocation.getCurrentPosition(function(r){
            if(data){
                poi = new BMap.Point(data.lng,data.lat);
            }else{
                if(this.getStatus() == BMAP_STATUS_SUCCESS){
                    poi = new BMap.Point(r.point.lng,r.point.lat);
                }else {
                    poi = new BMap.Point(116.307852,40.057031);
                }
            }
            map.centerAndZoom(poi, 16);
        },{enableHighAccuracy: true});
        // 百度地图API功能

        map.enableScrollWheelZoom(true);
        var overlaycomplete = function(e){
            var overlaysPath;
            var obj={};
            overlaysPath=e.overlay.getPath();
            var lng=[];
            var lat=[];
            $.each(overlaysPath,function(index,item){
                lng.push(item.lng);
                lat.push(item.lat);
            })
            obj.longitudeColumn=lng.toString();
            obj.latitudeColumns=lat.toString();
            showEditModel(obj)
        };
        //实例化鼠标绘制工具
        var drawingManager = new BMapLib.DrawingManager(map, {
            isOpen: false, //是否开启绘制模式
            enableDrawingTool: true, //是否显示工具栏
            drawingToolOptions: {
                anchor: BMAP_ANCHOR_TOP_RIGHT, //位置
                offset: new BMap.Size(5, 5), //偏离值
            },
            circleOptions: styleOptions, //圆的样式
            polylineOptions: styleOptions, //线的样式
            polygonOptions: styleOptions, //多边形的样式
            rectangleOptions: styleOptions //矩形的样式
        });
        //添加鼠标绘制工具监听事件，用于获取绘制结果
        drawingManager.addEventListener('overlaycomplete', overlaycomplete);
    }

    function getFence() {
        get('/fence/fence/getAllFence',function (result) {
            var fenceLen=result.data.length;
            for(var i=0;i<fenceLen;i++){
                var point=[];
                var item=result.data[i];
                var longitudeColumnLen;
                var latitudeColumns=item.LATITUDE_COLUMNS.split(',');
                var longitudeColumn=item.LONGITUDE_COLUMN.split(',');
                longitudeColumnLen =longitudeColumn.length;
                for(var j=0;j<longitudeColumnLen;j++){
                    var lng=longitudeColumn[j];
                    var lat=latitudeColumns[j];
                    var pObj={};
                    pObj.lng=lng;
                    pObj.lat=lat;
                    point.push(pObj);
                }
                var polArry = [];
                $.each(point,function(index,item){
                    var p = new BMap.Point(item.lng,item.lat);
                    polArry.push(p);
                })
                var polygon = new BMap.Polygon(polArry,styleOptions);
                map.addOverlay(polygon);
            }
        })
    }

    // 显示表单弹窗
    function showEditModel(obj) {
        layer.open({
            type: 1,
            area: '350px',
            title: '添加区域信息',
            content: $('#modelFence').html(),
            success: function (dLayer, dIndex) {
                $(dLayer).children('.layui-layer-content').css('overflow', 'visible');
                form.on('submit(modelFenceSubmit)', function (data) {
                    obj.fenceName=data.field.fenceName;
                    console.log(JSON.stringify(obj))
                    post('/fence/fence/addFence',JSON.stringify(obj),function (result) {
                        if (result.code == 200) {
                            layer.close(dIndex);
                            layer.msg(result.msg, {icon: 1});
                            fenceTable.reload();
                        } else {
                            layer.msg(result.msg, {icon: 2});
                        }
                    })
                    return false;
                });
            }
        });
    }
    // 删除信息
    function doDelete(fenceName) {
        top.layer.confirm('确定要删除区域“' + fenceName + '”吗？', function (index) {
            top.layer.close(index);
            get1('/fence/fence/deleteUserByName',{fenceName:fenceName} ,function (result) {
                if (result.code == 200) {
                    layer.msg(result.msg, {icon: 1});
                    fenceTable.reload();
                } else {
                    layer.msg(result.msg, {icon: 2});
                }
            });
        });
    }

    //信息导入
    $('#informationImport').on('click', function () {
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