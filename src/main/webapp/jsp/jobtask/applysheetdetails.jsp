<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>申请列表</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<%--
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
--%>
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
        <a href="">申请管理</a>
		<a href="">申请列表</a>
      </span>

    <a class="shuaxin" href="${pageContext.request.contextPath}/JobTask/internallylogin?account=${employees.account}&password=${employees.password}" title="刷新">刷新</a>
    <span id="total" class="x-right" >共有数据：条</span>
</div>
<div  class="x-body">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so" id="formId" method="post">
            <table class="form-table" style="margin: auto;display: block;width: 50%">
                <tbody >
                <tr class="table-new-tr">
                    <td> <input type="hidden" name="serialnumber" value="<%out.print(request.getParameter("idnum"));%>" placeholder="" autocomplete="off" class="layui-input">

                    <c:if test="${employees.id == 1}">
                        <td nowrap class="name">员工名</td>
                        <td> <input type="text" name="employeeName"  placeholder="" autocomplete="off" class="layui-input">
                        </td>
                    </c:if>
                    <td nowrap class="name">申请时间：</td>
                    <td nowrap class="name">开始时间</td>
                    <td > <input  name="starttime" class="layui-input" id="start_time" ></td>
                    <td nowrap class="name">结束时间</td>
                    <td > <input  name="endtime" class="layui-input" id="end_time"  >
                    </td>
                    <td nowrap class="name">类型</td>
                    <td >
                        <select style="height:22px;font-size: 12px" name="type">
                            <option value="">请选择</option>
                            <option value="1">加班</option>
                            <option value="2">请假</option>
                            <option value="3">业绩</option>
                        </select>
                    </td>

                    <td nowrap class="name" style="margin-left: 20px">状态</td>
                    <td >
                        <select style="height:22px;font-size: 12px" name="status">
                            <option value="">请选择</option>
                            <option value="1">待审</option>
                            <option value="2">通过</option>
                            <option value="3">拒绝</option>
                        </select>
                    </td>



                    <td> <div style="margin-left: 10px" id="sousuo" class="sousuo" onclick="searchPage(1)" lay-filter="sreach">搜索</div></td>

                </tr>  </tbody>
            </table>
        </form>
    </div>


    <c:if test="${employees.id !=1}">
    <botton class="left-btn-purple" onclick="addApply()">新增申请</botton>
    </c:if>

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
        <th nowrap>状态</th>
        <th nowrap width="150px">月结号</th>
        <th nowrap width="80px">类型</th>
        <th nowrap width="80px">员工</th>
        <th nowrap width="100px">金额</th>
        <th nowrap width="100px">申请时间</th>
        <th nowrap width="100px">开始时间</th>
        <th nowrap width="100px">截止时间</th>
        <th nowrap width="100px">时长</th>
        <th nowrap width="100px">审核时间</th>
        <th nowrap width="80px">审核人</th>
        <th nowrap width="180px">申请备注</th>



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
            url : "${pageContext.request.contextPath}/flow/queryApplicationDetails?pageNum="+pageNum+"",
            data : $('#formId').serialize(),
            success : function(data) {
                var str='';
                $.each(data.list,function(index, list){
                    str+='<tr><td nowrap><input type="checkbox" name="checkbox" id="ids" style="margin: auto;display: block;" lay-skin="primary" value="'+list.id+'" /> </td>';
                    str+='<td nowrap id="status'+list.id+'">';
                    if(list.status == 1){
                        str+='<a class="bj-btn" onclick="checkStatus('+list.id+')">待审核</a>';
                    }
                    if(list.status == 2){
                        str+='<a class="bj-btn">已通过</a>';
                    }
                    if(list.status == 3){
                        str+='<a class="bj-btn">已拒绝</a>';
                    }
                    str+='</td>';
                    if(list.serialnumber!=null){
                        str+='<td nowrap>'+list.serialnumber+'</td>';
                    }else {
                        str+='<td nowrap></td>';
                    }
                    str+='<td nowrap style="text-align: center;">';
                    if(list.type == 1){
                        str+='<a class="bj-btn">加班</a>';
                    }
                    if(list.type == 2){
                        str+='<a class="bj-btn">请假</a>';
                    }
                    if(list.type == 3){
                        str+='<a class="bj-btn">业绩</a>';
                    }
                    str+='</td>';
                    if(list.empname!=null){
                        str+='<td nowrap>'+list.empname+'</td>';
                    }else {
                        str+='<td nowrap></td>';
                    }
                    if(list.money == null){
                        str+='<td nowrap></td>';
                    }else {
                        str+='<td nowrap>'+list.money+'</td>';
                    }

                    var addTime = formatDate(new Date(list.addtime),"yyyy-MM-dd HH:mm:ss");
                    str+='<td nowrap>'+addTime+'</td>';
                    var starttime = formatDate(new Date(list.starttime),"yyyy-MM-dd HH:mm:ss");
                    str+='<td nowrap>'+starttime+'</td>';
                    var endtime = formatDate(new Date(list.endtime),"yyyy-MM-dd HH:mm:ss");
                    str+='<td nowrap>'+endtime+'</td>';
                    str+='<td nowrap>'+list.duration+'</td>';
                    if(list.confirmtime == null){
                        str+='<td nowrap></td>';
                    }else {
                        var confirmtime = formatDate(new Date(list.confirmtime),"yyyy-MM-dd HH:mm:ss");
                        str+='<td nowrap>'+confirmtime+'</td>';
                    }
                    if(list.confirman == null){
                        str+='<td nowrap></td>';
                    }else {
                        str+='<td nowrap>'+list.confirman+'</td>';
                    }
                    if(list.remark == null){
                        str+='<td nowrap></td>';
                    }else {
                        str+='<td nowrap>'+list.remark+'</td>';
                    }
                  str+='</tr>';



                    str+='</tr>';

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
                $("#loadering").append('<img class="loading3" style="left:45%;top:45%;z-index: 1001;position: absolute;border-radius: 5px;width:40px;height:40px" src="${pageContext.request.contextPath}/images/icon3.gif" />');
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




    function lookdetails(idnum) {
        layer.open({
            type: 2,
            title: ['查看详情','color:black;background-color:#ffc000;'],
            shadeClose: true,
            shade: 0.8,
            area: ['80%', '85%'],
            content: '${pageContext.request.contextPath}/jsp/jobtask/taskListDetails.jsp?idnum='+idnum,
          /*  end:function () {
                location.reload();
            }*/
        });

        //x_admin_show('','${pageContext.request.contextPath}/jsp/jobtask/taskListDetails.jsp?idnum='+idnum,1200,500);

       // x_admin_show('','${pageContext.request.contextPath}/JobTask/getTaskById?id='+idnum,800,600);

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


    layui.use('laydate', function(){
        var laydate = layui.laydate;
        //日期时间选择器
        laydate.render({
            elem: '#test5'
            ,type: 'datetime'
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


    function addApply() {
        layer.open({
            type: 2,
            title: ['新增','color:black;background-color:#ffc000;'],
            shadeClose: true,
            shade: 0.8,
            area: ['35%', '90%'],
            content: '${pageContext.request.contextPath}/jsp/jobtask/addapply.jsp',
        });
    }


    function checkStatus(id) {
        layer.open({
            title:'审核',
            content: '<form id="IdForm"  method="post" >' +
                '状态:&nbsp&nbsp&nbsp<input  type="radio"  name="status" value="2" checked>通过' +
                '&nbsp;&nbsp;&nbsp;&nbsp;<input  type="radio"  name="status" value="3" >打回<br>' +
                ' <input type="hidden" name="id" value="'+id+'" checked>'+
                '金额：&nbsp;&nbsp;&nbsp;&nbsp;<input  type="text" name="money" ><br>' +
                '</form>',

            yes: function(index, layero){
                var status = $('input:radio:checked').val();
                $.ajax({
                    type : 'post',
                    dataType : "json",
                    url : '${pageContext.request.contextPath }/flow/confirmApplication',
                    data : $("#IdForm").serialize(),
                    traditional : true,//这里设置为true,不然后台接收到的参数会带上[]，导致数据无法正常接
                    success : function(data) {
                        var str = '';
                        if(status == 2){
                            str ='  <span class="status-btn-yqx">已通过</span>';
                        }
                        if(status == 3){
                            str ='<span class="status-btn-yqx">已拒绝</span>';
                        }
                        if(data.code == 1){
                            layer.msg(data.message,{time:1000},function (a) {
                                $("#status"+id).html(str);
                            });
                        }else {
                            layer.msg(data.message,{time:1000});
                        }



                    }
                })

            }
        });
    }
</script>
</body>
</html>
