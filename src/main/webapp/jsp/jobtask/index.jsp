<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.0.js"></script>
    <style type="text/css">
        
        html,body{
            margin: 0;
            height: 100%;
            width: 100%;
        }
        *{
            font-family: 微软雅黑;
        }
		.home-btn{
		text-align: center;float:left;width:auto;height:40px;cursor: pointer;
		}
		@media only screen and (min-width:769px) {
		.images	{width:40px;height:40px;top:0px;left:0px;position:relative;margin: 10px;}
		.head-box{padding-left:45px;height:80px;border-bottom: 2px solid #0099ff;width: 100%;}
		.logoimage{height:60px;width:auto;margin-top:10px;margin-right: 20px;}
		.lsframe{border:none;position: fixed;height:88%;width: 100%;left: 0;top:calc( 12% + 2px );}
		}
		@media only screen and (max-width:768px) {
		.images	{width:24px;height:auto;top:0px;left:0px;position:relative;margin: 10px;}
		.head-box{padding-left:20px;height:60px;border-bottom: 2px solid #0099ff;width: 100%;}
		.logoimage{height:40px;width:auto;margin-top:10px;}
		.lsframe{border:none;position: fixed;height:92%;width: 100%;left: 0;top:8%;}
		}

    </style>
</head>
<body>

<div class="head-box">
    <div class="home-btn" onclick="show(this)" id="home">
        <img src="${pageContext.request.contextPath}/images/home.png" class="images" >
        <p style="font-size: 12px;margin-top:-10px">首页</p>
    </div>
    <div class="home-btn" onclick="show(this)" id="task">
        <img src="${pageContext.request.contextPath}/images/task.png" class="images" >
        <p style="font-size: 12px;margin-top:-10px">任务</p>
    </div>
    <div class="home-btn" onclick="show(this)" id="daka">
        <img src="${pageContext.request.contextPath}/images/time.png" class="images" >
        <p style="font-size: 12px;margin-top:-10px">打卡</p>
    </div>
  <!--  <div class="home-btn" onclick="show(this)" id="time">
        <img src="${pageContext.request.contextPath}/images/time.png" class="images" >
        <p style="font-size: 12px;margin-top:-10px">考勤</p>
    </div> -->
     <div class="home-btn" onclick="show(this)" id="apply">
    <img src="${pageContext.request.contextPath}/images/资源.png" class="images" >
    <p style="font-size: 12px;margin-top:-10px">申请</p>
    </div>
    <!-- <div class="home-btn" >
        <img src="${pageContext.request.contextPath}/images/time.png" class="images" >
        <p style="font-size: 12px;margin-top:-10px">个人中心</p>
    </div> -->
    <div style="float:right;margin-right:10px" >
        <a class="shuaxin" onclick="shuaxin('${employees.account}','${employees.password}')" title="刷新">刷新</a>
        <img onclick="show(this)" id="center" src="${pageContext.request.contextPath}/images/hrslogo2.png" class="logoimage" >
    </div>
</div>




<div class="lsframe" style="">
    <iframe id="lsframe" src="${pageContext.request.contextPath}/emp/empsheet" style="width:100%;height:100%;z-index:9999999;border:none;" ></iframe>
</div>

</body>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/layui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/xadmin.css">
<script src="${pageContext.request.contextPath }/js/jquery.min.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/xadmin.js"></script>
<script>
    function show(_this){
        if($(_this).attr("id")=="home"){
            document.getElementById("lsframe").src="${pageContext.request.contextPath}/jsp/jobtask/home.jsp";
        }
        if($(_this).attr("id")=="task"){
            document.getElementById("lsframe").src="${pageContext.request.contextPath}/jsp/jobtask/task.jsp";
        }
        if($(_this).attr("id")=="time"){
            document.getElementById("lsframe").src="${pageContext.request.contextPath}/jsp/jobtask/attendancedetails.jsp";
        }
        if($(_this).attr("id")=="daka"){
            document.getElementById("lsframe").src="${pageContext.request.contextPath}/jsp/jobtask/shangban.jsp";
        }
        if($(_this).attr("id")=="apply"){
            document.getElementById("lsframe").src="${pageContext.request.contextPath}/jsp/jobtask/applysheetdetails.jsp";
        }
        if($(_this).attr("id")=="center"){
            x_admin_show('',"${pageContext.request.contextPath}/JobTask/personalcenter",400,400);
            //document.getElementById("lsframe").src="https://baidu.com";
        }
    }


    function shuaxin(account,password) {
        location.href="${pageContext.request.contextPath}/JobTask/internallylogin?account="+account+"&password="+password
    }
</script>

</html>
