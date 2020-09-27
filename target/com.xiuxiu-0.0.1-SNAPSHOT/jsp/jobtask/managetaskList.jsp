<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>任务列表</title>
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
        .layui-form-select .layui-input{
            padding-left: 0;
            padding-right: 0;
        }
        .layui-input
        {
            padding-left: 0;
            padding-right: 0;
        }
    </style>
</head>

<body>
<div id="loadering">

</div>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">任务管理</a>
		<a href="">任务列表</a>
      </span>

    <a class="shuaxin" href="${pageContext.request.contextPath}/JobTask/internallylogin?account=${employees.account}&password=${employees.password}" title="刷新">刷新</a>
    <span id="total" class="x-right" >共有数据：条</span>
</div>
<div  class="x-body">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so" id="formId" method="post">
            <table class="form-table"  style="margin: auto;display: block;width: 50%">
                <tbody >
                <tr class="table-new-tr">
                    <td nowrap class="name">任务单号</td>
                    <td> <input type="text" name="serialnumber"  placeholder="" autocomplete="off" class="layui-input">
                    </td>
                    <c:if test="${employees.id == 1}">
                        <td nowrap class="name">员工名</td>
                        <td> <input type="text" name="employeeName"  placeholder="" autocomplete="off" class="layui-input">
                        </td>
                    </c:if>
                    <td nowrap class="name">时间</td>
                   <td >
                        <select style="height:22px;font-size: 12px" name="dateType">
                            <option value="addtime">发布时间</option>
                        </select>
                    </td>
                    <td nowrap class="name">开始时间</td>
                    <td > <input  name="starttime" class="layui-input" id="start_time" ></td>
                    <td nowrap class="name">结束时间</td>
                    <td > <input  name="endtime" class="layui-input" id="end_time"  >
                    </td>



                    <td> <div style="margin-left: 10px"  id="sousuo" class="sousuo" onclick="searchPage(1)" lay-filter="sreach">搜索</div></td>

                </tr>  </tbody>
            </table>
        </form>
    </div>


    <botton class="left-btn-purple" onclick="addTask()">新增事务</botton>


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
        <th nowrap >操作</th>
        <th nowrap>任务单号</th>
        <th nowrap width="185px">员工</th>
        <th nowrap width="145px">完成率</th>
        <th nowrap width="145px">总任务数</th>
        <th nowrap width="145px">已完成</th>
        <th nowrap width="145px">待审核</th>
        <th nowrap width="145px">待领取</th>
        <th nowrap width="145px">待完成</th>
        <th nowrap width="145px">待返工</th>
        <th nowrap width="145px">返工中</th>
        <th nowrap width="145px">已返工</th>
        <th nowrap width="145px">超时完成</th>


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





    function goPageNum(){
        var goPageNum = $("#goPageNum").val();
        searchPage(goPageNum);
    }

    function searchPage(pageNum) {
        if(pageNum==0){return;}
        $.ajax({
            type : "POST",
            dataType : "json",
            url : "${pageContext.request.contextPath}/JobTask/queryAllAjax?pageNum="+pageNum+"",
            data : $('#formId').serialize(),
            success : function(data) {
                var str='';
                $.each(data.list,function(index, list){
                    str+='<tr><td nowrap><input type="checkbox" name="checkbox" id="ids" style="margin: auto;display: block;" lay-skin="primary" value="'+list.id+'" /> </td>';
                    str +='<td nowrap>';
                    str +='<a class="bj-btn" onclick="lookdetails(\''+list.serialnumber+'\')">查看详情</a>';
                    str +='</td>';
                    if(list.serialnumber!=null){
                        str+='<td nowrap>'+list.serialnumber+'</td>';
                    }else {
                        str+='<td nowrap></td>';
                    }
                    if(list.empName!=null){
                        str+='<td nowrap>'+list.empName+'</td>';
                    }else {
                        str+='<td nowrap></td>';
                    }

                    str+='<td nowrap>'+list.finished+'</td>';
                    str+='<td nowrap>'+list.total+'</td>';
                    str+='<td nowrap>'+list.finish+'</td>';
                    var checkNum = list.rewaitcheck+list.waitcheck;
                    str+='<td nowrap>'+checkNum+'</td>';
                    str+='<td nowrap>'+list.waitclaim+'</td>';
                    str+='<td nowrap>'+list.waitend+'</td>';
                    str+='<td nowrap>'+list.waitrework+'</td>';
                    str+='<td nowrap>'+list.reworking+'</td>';
                    str+='<td nowrap>'+list.numberofrework+'</td>';
                    str+='<td nowrap>'+list.overtimenum+'</td>';
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
                $("#loadering").append('<img class="loading3" style="left:45%;top:45%;z-index: 1001;position: absolute;border-radius: 5px;width:60px;height:60px" src="${pageContext.request.contextPath}/images/icon3.gif" />');
                $("#loadering").append('<div class="loading4" style="position:absolute;width:100%;height:100%;opacity: 0.5;background-color: #E8E8E8;z-index:1000;"></div>');
            },
            complete : function () {
                $(".loading3").fadeOut("slow");
                $(".loading4").fadeOut("slow");
            }
        });

    }
    searchPage(1);

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


    function addTask() {
        layer.open({
            type: 2,
            title: ['新增','color:black;background-color:#ffc000;'],
            shadeClose: true,
            shade: 0.8,
            area: ['35%', '90%'],
            content: '${pageContext.request.contextPath}/jsp/jobtask/addtask.jsp',
        });
    }
</script>
</body>
</html>
