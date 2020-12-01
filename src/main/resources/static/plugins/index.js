/**
 * Created by Administrator on 2019/7/25.
 */

$('.dp').on('click', function () {
    var aa = $('#dpMenu').css('display');
    if (aa == 'none') {
        $('#dpMenu').css('display','block')
    } else {
        $('#dpMenu').css('display','none')
    }
});

$('#dpMenu>li>a').on('click', function () {
    $('#dpMenu').css('display','none')
});






