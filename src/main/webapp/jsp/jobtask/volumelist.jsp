<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>来访列表</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/layui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/xadmin.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/font.css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/xadmin.js"></script>

    <style type="text/css">
        img{ position:absolute; border:0px solid #FFF;}

        .layui-table{
            overflow: auto;
            width: 98%;
            margin-left: 1%;
        }
        /*.layui-table td, .layui-table th{
            width: 10%;
        }*/
        .bj-btn{
            margin-left: 2%;
        }

    </style>
</head>

<body>
<div id="loadering">

</div>
<div class="x-nav">
      <span class="layui-breadcrumb"> 
        <a href="">来访列表</a>
		<a href="">来访列表</a>
      </span>

    <a class="shuaxin" href="javascript:location.replace(location.href);" title="刷新">刷新</a>
    <span id="total" class="x-right" >共有数据：条</span>
</div>
<div  class="x-body">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so" id="formId" method="post">
            <table class="form-table" >
                <tbody >
                <tr class="table-new-tr">
            <td nowrap class="name">来访URL</td>
            <td> <input type="text" name="fromurl"  placeholder="" autocomplete="off" class="layui-input">
            </td>
            <td nowrap class="name">来访IP</td>
            <td> <input type="text" name="ip"  placeholder="" autocomplete="off" class="layui-input">
            </td>
            <td nowrap class="name">来访设备</td>
            <td >
                <select style="height:22px;font-size: 12px" name="lsframe">
                     <option value="">请选择</option>
                     <option value="安卓">安卓</option>
                     <option value="苹果">苹果</option>
                     <option value="ipad">ipad</option>
                     <option value="电脑">电脑</option>
                </select>
            </td>
                    <td nowrap class="name">来访环境</td>
                    <td >
                        <select style="height:22px;font-size: 12px" name="lsframe2">
                            <option value="">请选择</option>
                            <option value="微信环境">微信环境</option>
                            <option value="非微信">非微信</option>

                        </select>
                    </td>

            <td nowrap class="name">时间类型</td>
            <td >
                <select style="height:22px;font-size: 12px" name="dateType">
                    <option value="addtime">来访时间</option>
                </select>
            </td>
            <td nowrap class="name">开始时间</td>
            <td > <input  name="standbyone" class="layui-input" id="start_time" ></td>
            <td nowrap class="name">结束时间</td>
            <td > <input  name="standbytwo" class="layui-input" id="end_time"  >
            </td>
                    <td> <div id="sousuo" class="sousuo" onclick="searchPage(1)" lay-filter="sreach">搜索</div></td>

                </tr>  </tbody>
            </table>
        </form>
    </div>



	<span class="page-new">
        <span id="pagefoot">
        </span>
    </span>
</div>

<table style="overflow-x: auto;height:auto;margin-top:5px;" class="layui-table">
    <thead>
    <tr>

        <th >
            <input type="checkbox"  onclick="swapCheck()"  lay-skin="primary">
        </th>
        <th nowrap width="15%">当前url</th>
        <th nowrap width="15%">来访url</th>
        <th nowrap width="15%">来访IP</th>
        <th nowrap width="15%">IP所在地</th>
        <th nowrap width="15%">来访设备</th>
        <th nowrap width="15%">是否微信</th>
        <th nowrap width="15%" >来访时间</th>

    </tr>
    </thead>
    <tbody id="tb">
    </tbody>
</table>
<div id="noMsg" style="position: absolute;left: 40%;top: 40%">
    <img src="${pageContext.request.contextPath}/images/noMsg.jpg" alt="" style="">
    <p style="font-size: 15px;color: #c7c7c7">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp暂无数据</p>
</div>
<script type="text/javascript">

    $(function () {
    searchPage(1);
    })
    function goPageNum(){
        var goPageNum = $("#goPageNum").val();
        searchPage(goPageNum);
    }
    function searchPage(pageNum) {
        if(pageNum==0){return;}
        $.ajax({
            type : "POST",
            dataType : "json",
            url : "${pageContext.request.contextPath}/flow/getVolume?pageNum="+pageNum+"",
            data : $('#formId').serialize(),
            success : function(data) {
                var str='';
                $.each(data.list,function(index, list){
                    str+='<tr><td nowrap><input type="checkbox" name="checkbox" id="ids" style="margin: auto;display: block;" lay-skin="primary" value="'+list.id+'" /> </td>';
                    str+='<td nowrap>'+list.nowurl+'</td>';
                    if(list.fromurl.length == 0){
                        str+='<td nowrap></td>';
                    }else {
                        str+='<td nowrap>'+list.fromurl+'</td>';
                    }
                    str+='<td nowrap>'+list.ip+'</td>';
                    str+='<td nowrap>'+list.ipaddress+'</td>';
                    str+='<td nowrap>'+list.lsframe+'</td>';
                    str+='<td nowrap>'+list.lsframe2+'</td>';
                    str+='<td nowrap>'+list.addtime+'</td></tr>';

                })
                pagenum=parseInt(data.pageNum);
                pagenum0=pagenum-1;
                pagenum1=pagenum+1;
                pagenum2=pagenum+2;
                pagenum3=pagenum+3;
                var htm = "<a   href='#' onclick='searchPage(1)'>首页 </a><a   href='#' onclick='searchPage(" + data.prePage + ")'>上一页 </a>";
                if (data.pageNum > 1) {
                    htm += "<a   href='#' onclick='searchPage(" + pagenum0 + ")'>" + pagenum0 + " </a>"
                }
                htm += "<span   >" + data.pageNum + "</span> ";
                if (data.lastPage - data.pageNum > 0) {
                    htm += "<a   href='#' onclick='searchPage(" + pagenum1 + ")'>" + pagenum1 + " </a>"
                } else {
                    htm += "<a   href='#' ></a>"
                }
                if (data.lastPage - data.pageNum > 1) {
                    htm += "<a   href='#' onclick='searchPage(" + pagenum2 + ")'>" + pagenum2 + " </a>"
                } else {
                    htm += "<a   href='#' ></a>"
                }
                if (data.lastPage - data.pageNum > 2 & data.pageNum == 1) {
                    htm += "<a   href='#' onclick='searchPage(" + pagenum3 + ")'>" + pagenum3 + " </a>"
                }
                htm += "<a   href='#' onclick='searchPage(" + data.nextPage + ")'> 下一页</a><a   href='#' onclick='searchPage(" + data.pages + ")'> 尾页</a><span  > 共有" + data.pages + "页 </span>"
                htm += '<input class="layui-input-ym" id="goPageNum" type="text"  placeholder="页码" name="page" autocomplete="off" style="">&nbsp<button class="tiaozhuan"   onclick="goPageNum()"  type="layui-submit">  跳转</button>'
                $("#pagefoot").html(htm);
                $("#total").html("共有数据："+data.total+" 条");
                $("#tb").html(str);
            },
            error : function() {
                alert("系統繁忙");

            },
            beforeSend : function () {
                $("#loadering").append('<img class="loading3" style="left:45%;top:45%;z-index: 1001;position: absolute;border-radius: 5px;width:180px;height:180px" src="${pageContext.request.contextPath}/images/icon3.gif" />');
                $("#loadering").append('<div class="loading4" style="position:absolute;width:100%;height:100%;opacity: 0.5;background-color: #E8E8E8;z-index:1000;"></div>');
            },
            complete : function () {
                $(".loading3").fadeOut("slow");
                $(".loading4").fadeOut("slow");
            }
        });

    }


</script>

<script type="text/javascript">


    function myFunction(sell,codeId){
        //alert(codeId);
        var id = sell.id;
        //alert(id);
        var id1 =id-0.5;
        var val= $("#"+id1).text();//售价
        var value = sell.value;//输入价
        //  alert(val+"++"+value);
        $("#"+id1).html(value);
        if(Number(value)>0){
            var b = window.confirm("你确认调价成"+value+"元吗？");
            if(b){
                $.ajax({
                    type:'post',
                    dataType: "json",
                    url:'${pageContext.request.contextPath }/GoodsSupplier/passSell',
                    data:{"id":codeId,"sell":value},
                    traditional: true,//这里设置为true,不然后台接收到的参数会带上[]，导致数据无法正常接收
                    success:function(data) {
                        alert(data.message);
                        location.reload();
                    }})
            }
        }
    }

    function lookdetails(idnum) {
        layer.open({
            type: 2,
            title: '事务详情',
            closeBtn: 1, //关闭按钮是否显示 1显示0不显示
            shadeClose: true,
            shade: 0.8,
            area: ['90%', '90%'],
            skin:'layui-layer-lan',
            content: '${pageContext.request.contextPath}/jsp/Joptask/taskDetails.jsp',
        });
    }




    function formatDate(date,format){
        var paddNum = function(num){
            num += "";
            return num.replace(/^(\d)$/,"0$1");
        }
        //指定格式字符
        var cfg = {
            yyyy : date.getFullYear() //年 : 4位
            ,yy : date.getFullYear().toString().substring(2)//年 : 2位
            ,M  : date.getMonth() + 1  //月 : 如果1位的时候不补0
            ,MM : paddNum(date.getMonth() + 1) //月 : 如果1位的时候补0
            ,d  : date.getDate()   //日 : 如果1位的时候不补0
            ,dd : paddNum(date.getDate())//日 : 如果1位的时候补0
            ,HH : date.getHours()  //时
            ,mm : date.getMinutes() //分
            ,ss : date.getSeconds() //秒
        }
        format || (format = "yyyy-MM-dd hh:mm:ss");
        return format.replace(/([a-z])(\1)*/ig,function(m){return cfg[m];});
    }



    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#end' //指定元素
        });
    });





    /*用户-删除*/
    function member_del(obj,id){
        layer.confirm('确认要删除吗？',function(index){
            //发异步删除数据
            $(obj).parents("tr").remove();
            layer.msg('已删除!',{icon:1,time:1000});
        });
    }
    /* 复选框  */



    var isCheckAll = false;
    function alltime() {
        if (isCheckAll) {
            $("input[type='checkbox']").each(function() {
                this.checked = false;
            });
            isCheckAll = false;
        } else {
            $("input[type='checkbox']").each(function() {
                this.checked = true;
            });
            isCheckAll = true;
        }
    }


    function delAll (argument) {

        var data = tableCheck.getData();

        layer.confirm('确认要删除吗？'+data,function(index){
            //捉到所有被选中的，发异步进行删除
            layer.msg('删除成功', {icon: 1});
            $(".layui-form-checked").not('.header').parents('tr').remove();
        });
    }


</script>
<script>var _hmt = _hmt || []; (function() {
    var hm = document.createElement("script");
    hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
    var s = document.getElementsByTagName("script")[0];
    s.parentNode.insertBefore(hm, s);
})();
</script>
<%--//取消等待图标--%>
<script type="">
    function loadingmsg() {
        $('.loading',parent.document).remove();
    }
</script>
<script language="javascript">
    /*鼠标移动事件图片放大显示*/
    $(function(){
        var offsetX=20-$(".layui-table").offset().left;
        var offsetY=20-$(".layui-table").offset().top;
        $(document).on("mouseover",".layui-table td .imgSmall",function(event) {
            var $target=$(event.target);
            if($target.is('img'))
            {
                $("<img id='tip' src='"+$target.attr("src")+"'>").css({
                    "height":250,
                    "width":250,
                    "top":event.pageX+offsetX,
                    "left":event.pageY+offsetY,
                }).appendTo($("body"));
            }
        }).mouseout(function() {
            $("#tip").remove();
        }).mousemove(function(event) {
            $("#tip").css(
                {
                    "left":event.pageX+offsetX,
                    "top":event.pageY+offsetY
                });
        });
    })


    /*layui时间选择器*/
    layui.use('laydate', function(){
        var $ = layui.$;
        var laydate = layui.laydate;
        var nowTime = new Date().valueOf();
        var max = null;
        var start = laydate.render({
            elem: '#start_time',
            type: 'date',
            btns: ['clear', 'confirm'],
            done: function(value, date){
                endMax = end.config.max;
                end.config.min = date;
                end.config.min.month = date.month -1;
            },
            change: function(value, date, endDate){
                var timestamp2 = Date.parse(new Date(value));
                timestamp2 = timestamp2 / 1000;
                end.config.min = timestamp2;
                end.config.min.month = date.month -1;
            }
        });
        var end = laydate.render({
            elem: '#end_time',
            type: 'date',
            done: function(value, date){
                console.log(" ======  "+date);
                if($.trim(value) == ''){
                    var curDate = new Date();
                    date = {'date': curDate.getDate(), 'month': curDate.getMonth()+1, 'year': curDate.getFullYear()};
                }
                start.config.max = date;
                start.config.max.month = date.month -1;
            }
        });
    });
</script>
<script type="">
    /*快捷搜索按钮*/
    $(".layui-input").bind("keypress", function(){
        if (event.keyCode == 13){
            // 触发需要调用的方法
            $("#sousuo").click();
        }
    })
</script>
<script type="">


    var isCheckAll = false;
    function swapCheck() {
        if (isCheckAll) {
            $("input[type='checkbox']").each(function() {
                this.checked = false;
            });
            isCheckAll = false;
        } else {
            $("input[type='checkbox']").each(function() {
                this.checked = true;
            });
            isCheckAll = true;
        }
    }
    //暂无数据时 显示图片代替效果
    function showMsg(){

        var a = $("#noMsg");
        var b = $("td");
        if(b.text()!=""){
            a.hide();
        }else{
            a.show();
        }
    }
    showMsg();
</script>
</body>
</html>
