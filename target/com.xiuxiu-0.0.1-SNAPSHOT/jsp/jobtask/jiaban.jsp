<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=1, initial-scale=1,target-densitydpi=low-dpi" />

    <style>
        body{
            margin:0
        }

    </style>
    <meta charset="utf-8">
    <title></title>
</head>
<body>
<div style="height:44px;width:100%;background:#0099ff;position:fixed;top:0px;left:0px;float:left;text-align:center">
    <div style="line-height:44px;float:left">
        <img src="${pageContext.request.contextPath}/images/返回.png"  style="width:20px;height:20px;margin-top:10px;margin-left:10px">
        <!-- 	<span style="font-size:12px;color:white;bottom:10px">返回</span> -->

    </div>
    <div style="line-height:44px;font-size:14px;color:#fff">加班申请</div>
</div>
<form style="position:fixed;top:90px">
    <div >
        <span style="margin-left:20px">申请事由</span>
        <input type="text" name="" id="" value="" style="height:22px;width:200px"/>
    </div>
    <div style="position:relative;margin-top:20px;margin-left:20px">
        <span>申请日期</span>
        <input type="text" name="" id="" value="" style="height:22px;width:200px"/>
    </div>
    <div style="position:relative;margin-top:20px;margin-left:20px">
        <span>申请时长</span>
        <select>
            <option value ="">1小时</option>
            <option value ="">1.5小时</option>
            <option value ="">2小时</option>
            <option value ="">2.5小时</option>
            <option value ="">3小时</option>
            <option value ="">3.5小时</option>
            <option value ="">4小时</option>
            <option value ="">4.5小时</option>
            <option value ="">5小时</option>
            <option value ="">5.5小时</option>
            <option value ="">6小时</option>
            <option value ="">6.5小时</option>
            <option value ="">7小时</option>
            <option value ="">7.5小时</option>
            <option value ="">8小时</option>
        </select>
    </div>
    <div>
</form>
<div style="position:fixed;top:80%;left:calc( 50% - 30px )">
    <span  style="font-size:14px;background:#0099ff;padding:5px 8px;border-radius:3px;color:white">提交申请</span>
</div>
</div>


</body>

</html>