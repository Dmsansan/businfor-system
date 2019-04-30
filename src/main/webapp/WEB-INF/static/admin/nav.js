//左侧竖导航：请求数据
layui.config({
    base: '/layui/lay/modules/',　　//需要依赖的slider路径
}).use(['element', 'layer', 'slider'], function () {
    var element = layui._elements,
        $ = layui.jquery,
        layer = layui.layer,
        navbar = layui.slider;

    $.ajax({
        type:'post',
        url:"/menu/leftNavMenu",
        success:function(data){
            console.log(data);
            var navData = data;
            $("#admin_userName").text(data.fullname); //用户名称

            //设置navbar
            navbar.set({
                spreadOne: true,
                elem: "#navbar_side",
                cached: false,
                data: navData
            });

            //渲染navbar
            navbar.render();

            //监听点击事件
            navbar.on('click(side)', function (data) {
                var childHtml = data.field.href;//获取当前点击项的路径
                $(".layui-body iframe").attr("src",childHtml);//将路径赋值给右侧iframe
            });
        }
    });

});