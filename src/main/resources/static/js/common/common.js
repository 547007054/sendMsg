/**
 * 以下代码是配置layui扩展模块的目录，每个页面都需要引入
 */
layui.config({
    base: getProjectUrl() + '/static/module/'
}).extend({
    formSelects: 'formSelects/formSelects-v4',
    treetable: 'treetable-lay/treetable',
    dropdown: 'dropdown/dropdown',
    notice: 'notice/notice',
    step: 'step-lay/step',
    dtree: 'dtree/dtree',
    citypicker: 'city-picker/city-picker',
    tableSelect: 'tableSelect/tableSelect'
}).use(['layer', 'admin'], function () {
    var $ = layui.jquery;
    var layer = layui.layer;
    var admin = layui.admin;

    // 移除loading动画
    setTimeout(function () {
        admin.removeLoading();
    }, window == top ? 600 : 100);
});

/**
 * 获取当前项目的根路径，通过获取layui.js全路径截取assets之前的地址
 *
 * @returns {string}
 */
function getProjectUrl() {
    var layuiDir = layui.cache.dir;
    if (!layuiDir) {
        var js = document.scripts, last = js.length - 1, src;
        for (var i = last; i > 0; i--) {
            if (js[i].readyState === 'interactive') {
                src = js[i].src;
                break;
            }
        }
        var jsPath = src || js[last].src;
        layuiDir = jsPath.substring(0, jsPath.lastIndexOf('/') + 1);
    }
    return layuiDir.substring(0, layuiDir.indexOf('assets'));
}

/**
 * ajax封装
 *
 * @param url      请求的url
 * @param data     请求的参数
 * @param success  请求成功后执行的函数
 * @param async    异步请求
 * @param type     请求的类型
 * @param dataType 接收数据类型
 * @param error    请求失败后执行的函数
 * @returns {boolean}
 */
function ajax(url, data, async, type, dataType, success, error) {
    var $ = layui.jquery;
    var type = type || 'post';
    var dataType = dataType || 'json';
    var async = async || true;

    var error = error || function (data) {
        setTimeout(function () {
            switch (data.status) {
                case 404:
                    layer.msg('请求失败，请求未找到');
                    break;
                case 503:
                    layer.msg('请求失败，服务器内部错误');
                    break;
                default:
                    layer.alert('请求失败, 网络连接超时！', {
                        icon: 2,
                        skin: 'layer-ext-moon',
                        offset: 't'
                    });
                    break;
            }
        }, 500);
    };

    var index;
    $.ajax({
        'url': getProjectUrl() + url,
        'data': data,
        'type': type,
        'dataType': dataType,
        'async': async,
        'cache': false,
        'contentType': 'application/json;charset=utf-8',
        'jsonpCallback': 'jsonp' + (new Date()).valueOf().toString().substr(-4),
        'beforeSend': function () {
            index = layer.msg('请求处理中...', {
                icon: 16,
                shade: 0.01,
                time: -1
            });
            layer.style(index, {
                border: 'none'
            });
        },
        'complete': function (request) {
            layer.close(index);
        },
        'success': success,
        'error': error
    });
}

/**
 * ajax 提交(post方式提交)
 *
 * @param url
 * @param data
 * @param success
 * @param alone
 */
function post(url, data, success) {
    ajax(url, data, false, 'post', 'json', success);
}

/**
 * ajax 提交(post方式提交)
 *
 * @param url
 * @param data
 * @param success
 * @param alone
 */
function post(url, data, success, error) {
    ajax(url, data, false, 'post', 'json', success, error);
}

/**
 * ajax 提交(get方式提交)
 *
 * @param url
 * @param success
 * @param alone
 */
function get(url, success) {
    ajax(url, {}, false, 'get', 'json', success);
}

/**
 * ajax 提交(get方式提交)
 *
 * @param url
 * @param data
 * @param success
 */
function get1(url, data, success) {
    ajax(url, data, false, 'get', 'json', success);
}

/**
 * jsonp 跨域请求(get方式提交)
 *
 * @param url
 * @param success
 * @param cache
 * @param alone
 */
function jsonp(url, success) {
    ajax(url, {}, false, 'get', 'jsonp', success);
}

