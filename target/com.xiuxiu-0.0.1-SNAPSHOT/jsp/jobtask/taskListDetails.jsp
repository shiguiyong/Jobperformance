<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>任务列表</title>
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
        .hidelabel{
            display: none;
        }
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
        <a href="">任务管理</a>
		<a href="">任务列表</a>
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
            <input type="hidden" name="employeeId" value="${employees.id}">
            <td nowrap class="name">任务标题</td>
            <td> <input type="text" name="taskTitle"  placeholder="" autocomplete="off" class="layui-input">
            </td>
            <td> <input type="hidden" name="serialnumber" value="<%out.print(request.getParameter("idnum"));%>" placeholder="" autocomplete="off" class="layui-input">
            </td>
            <c:if test="${employees.id == 1}">
                <td nowrap class="name">员工名</td>
                <td> <input type="text" name="employeeName"  placeholder="" autocomplete="off" class="layui-input">
                </td>
            </c:if>
            <td nowrap class="name">状态</td>
            <td >
                <select style="height:22px;font-size: 12px" name="status">
                     <option value="">请选择</option>
                    <option value="2">待认领</option>
                    <option value="3">待完成</option>
                    <option value="4">待审核</option>
                    <option value="5">待返工</option>
                    <option value="6">返工中</option>
                    <option value="7">正常完成</option>
                    <option value="8">超时完成</option>

                </select>
            </td>

            <td nowrap class="name">时间类型</td>
            <td >
                <select style="height:22px;font-size: 12px" name="dateType">
                    <option value="addtime">发布时间</option>
                    <option value="allottime">分配时间</option>
                    <option value="claimtime">认领时间</option>
                    <option value="subtime">提交时间</option>
                    <option value="confirmtime">审核时间</option>
                </select>
            </td>
            <td nowrap class="name">开始时间</td>
            <td > <input  name="starttime" class="layui-input" id="start_time" ></td>
            <td nowrap class="name">结束时间</td>
            <td > <input  name="endtime" class="layui-input" id="end_time"  >
            </td>
                <td></td>
                <td></td>
                    <td> <div id="sousuo" class="sousuo" onclick="searchPage(1)" style="margin-left: 10px" lay-filter="sreach">搜索</div></td>

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
        <th nowrap >状态</th>
        <th nowrap >操作</th>
        <th nowrap>工单号</th>
        <th nowrap width="185px">认领员工</th>
        <th nowrap width="185px">任务标题</th>
        <th nowrap width="185px">任务详情</th>
        <th nowrap width="185px">起始时间</th>
        <th nowrap width="185px">截止时间</th>
        <th nowrap width="185px">发布时间</th>
        <th nowrap width="185px">认领时间</th>
        <th nowrap width="185px">提交时间</th>
        <th nowrap width="185px">审核时间</th>
        <th nowrap width="185px">返工备注</th>
        <th nowrap width="185px">审核人</th>
        <th nowrap width="185px">备注</th>

    </tr>
    </thead>
    <tbody id="tb">
    </tbody>
</table>
<%--<div id="noMsg" style="position: absolute;left: 40%;top: 40%">
    <img src="${pageContext.request.contextPath}/images/noMsg.jpg" alt="" style="">
    <p style="font-size: 15px;color: #c7c7c7">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp暂无数据</p>
</div>--%>
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
            url : "${pageContext.request.contextPath}/JobTask/queryDetailsAjax?pageNum="+pageNum+"",
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
                        str+='<a class="bj-btn">待领取</a>';
                    }
                    if(list.status == 3){
                        str+='<a class="bj-btn">待提交</a>';
                    }
                    if(list.status == 4){
                        str+='<a class="bj-btn" onclick="checkStatus('+list.id+')">待审核</a>';
                    }
                    if(list.status == 5){
                        str+='<a class="bj-btn">待返工</a>';
                    }
                    if(list.status == 6){
                        str+='<a class="bj-btn">返工中</a>';
                    } if(list.status == 7){
                        str+='<a class="bj-btn">已完成</a>';
                    }
                    if(list.status == 8){
                        str+='<a class="bj-btn">超时完成</a>';
                    }
                    if(list.status == 9){
                        str+='<a class="bj-btn">完成返工</a>';
                    }
                    str +='</td>';
                    str +='<td nowrap>';

                    str +='<a class="bj-btn" onclick="editTask(\''+list.id+'\')">编辑</a>';
                    if(list.image !=null){
                        str +='<a class="bj-btn" onclick="downloadLocal(\''+list.image+'\')">任务附件</a>';

                    }
                    if(list.fileurl !=null){
                        str +='<a class="bj-btn" onclick="downloadLocal(\''+list.fileurl+'\')">提交附件</a>';
                    }
                    if(list.reworkurl !=null){
                        str +='<a class="bj-btn" onclick="downloadLocal(\''+list.reworkurl+'\')">返工附件</a>';
                    }
                  /*  str +='<a class="bj-btn" onclick="lookImages('+list.id+')">查看</a>';*/
                    str +='</td>';
                    str+='<td nowrap>'+list.serialnumber+'</td>';

                    if(list.empname!=null){
                        str+='<td nowrap>'+list.empname+'</td>';
                    }else {
                        str+='<td nowrap></td>';
                    }
                    str+='<td nowrap>'+list.tasktitle+'</td>';
                    str+='<td nowrap>'+list.taskdetails+'</td>';
                    var starttime = formatDate(new Date(list.starttime),"yyyy-MM-dd HH:mm:ss");
                    str+='<td nowrap>'+starttime+'</td>';
                    var endtime = formatDate(new Date(list.endtime),"yyyy-MM-dd HH:mm:ss");
                    str+='<td nowrap>'+endtime+'</td>';
                    if(list.addtime!=null){
                        var addTime = formatDate(new Date(list.addtime),"yyyy-MM-dd HH:mm:ss");
                        str+='<td nowrap>'+addTime+'</td>';
                    }else {
                        str+='<td nowrap></td>';
                    }

                    if(list.claimtime!=null){
                        var claimtime = formatDate(new Date(list.claimtime),"yyyy-MM-dd HH:mm:ss");
                        str+='<td nowrap>'+claimtime+'</td>';
                    }else {
                        str+='<td nowrap></td>';
                    }


                    if(list.subtime !=null){
                        var subtime = formatDate(new Date(list.subtime),"yyyy-MM-dd HH:mm:ss");
                        str+='<td nowrap>'+subtime+'</td>';
                    }else {
                        str+='<td nowrap></td>';
                    }

                    if(list.confirmtime !=null){
                        var confirmtime = formatDate(new Date(list.confirmtime),"yyyy-MM-dd HH:mm:ss");
                        str+='<td nowrap>'+confirmtime+'</td>';
                    }else {
                        str+='<td nowrap></td>';
                    }
                    if(list.reworkremark!=null){
                        str+='<td nowrap>'+list.reworkremark+'</td>';
                    }else {
                        str+='<td nowrap></td>';
                    }

                    if(list.checkman!=null){
                        str+='<td nowrap>'+list.checkman+'</td>';
                    }else {
                        str+='<td nowrap></td>';
                    }


                    if(list.remark!=null){
                        str+='<td nowrap>'+list.remark+'</td></tr>';
                    }else {
                        str+='<td nowrap></td></tr>';
                    }

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

    function editTask(idnum) {
        x_admin_show('','${pageContext.request.contextPath}/JobTask/getTaskById?id='+idnum,800,600);
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


    function downloadLocal(fileurl) {
        location.href="${pageContext.request.contextPath}/JobTask/downloadLocal?fileurl="+fileurl;
    }

    function lookImages(id) {
        layer.open({
            type: 2,
            title: ['查看','color:black;background-color:#ffc000;'],
            shadeClose: false,
            shade: 0.8,
            area: ['35%', '90%'],
            content: '${pageContext.request.contextPath}/jsp/jobtask/pictrue.jsp?id='+id,
        });
    }

    function changelabel(_this) {

        if($(_this).val()=="1") {
            $(".hidelabel").hide()
        }else{
            $(".hidelabel").show()
        }
    }

    function checkStatus(id) {
        layer.open({
            title:'审核',
            content: '<form id="IdForm"  method="post" enctype="multipart/form-data">' +
                '状态:&nbsp&nbsp&nbsp<input onclick="changelabel(this)" type="radio" name="type" value="1" checked>通过' +
                '&nbsp;&nbsp;&nbsp;&nbsp;<input onclick="changelabel(this)" type="radio" name="type" value="2" >打回<br>' +
                '<p class="hidelabel">返工备注:<textarea style="width: 75%;font-size: medium;float: right" id="remark"  name="remark" cols="30" rows="2" ></textarea></p>'+
                ' <input type="hidden" name="id" value="'+id+'" checked>'+
                '<p class="hidelabel" style="float: left">返工附件:<input type="file" name="file"></p></form>',

            yes: function(index, layero){
                var upload = new FormData($("#IdForm")[0]);
                $.ajax({
                    type : 'post',
                    dataType : "json",
                    url : '${pageContext.request.contextPath }/JobTask/checkStatus',
                    data : upload,
                    traditional : true,//这里设置为true,不然后台接收到的参数会带上[]，导致数据无法正常接
                    cache:false,
                    contentType: false,
                    processData: false,
                    success : function(data) {
                        var str = '';
                        if(data.code == 5){
                            str = '<a class="bj-btn">待返工</a>';
                        }
                        if(data.code == 7){
                            str ='  <span class="status-btn-yqx">已完成</span>';
                        }
                        if(data.code == 8){
                            str ='  <span class="status-btn-yqx">超时完成</span>';
                        }
                        if(data.code == 9){
                            str ='<span class="status-btn-yqx">完成返工</span>';
                        }

                        layer.msg(data.message,{time:1000},function (a) {
                            $("#status"+id).html(str);
                        });

                    }
                })

            }
        });
    }
    
   
</script>
</body>
</html>
