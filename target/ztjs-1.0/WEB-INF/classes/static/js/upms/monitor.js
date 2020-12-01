layui.use(['table', 'form', 'layer', 'admin'], function () {

    $('.dp').on('click', function () {
        var aa = $('#dpMenu').css('display');
        if (aa == 'none') {
            $('#dpMenu').css('display', 'block')
        } else {
            $('#dpMenu').css('display', 'none')
        }
    });

    $('#dpMenu>li>a').on('click', function () {
        $('#dpMenu').css('display', 'none')
    });

    $('#warpMain').on('click', function () {
        location.replace(getProjectUrl() + "wrapMain");
    });

});