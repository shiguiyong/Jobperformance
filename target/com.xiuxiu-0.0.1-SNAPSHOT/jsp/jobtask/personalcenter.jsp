<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>欢迎来到咻咻国际后台管理系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/layui.css">    
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/xadmin.css">    
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/font.css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/xadmin.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>	
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
    <style type="text/css">
        .imgBig{
            position: absolute;
            top: 8px;
            left: 8px;
            z-index: 1000;
            box-shadow: 0 0 10px #888;
            -webkit-box-shadow: 0 0 10px #888;
            -moz-box-shadow: 0 0 10px #888;
            -o-box-shadow: 0 0 10px #888;
        }
        .imgSmall{
            position: static;
            box-shadow: none;
            -webkit-box-shadow: none;
            -moz-box-shadow: none;
            -o-box-shadow: none;
            width: 20px;
            height: 20px;
        }
    </style>
</head>

<body>
<div class="x-body">
    <form class="am-form" id="form">
        <div class="layui-form-item">
            <label  class="layui-form-label"><span class="x-red"></span></label>
            <div class="layui-input-inline">
                <input type="text" id="code" name="id" value="${employees.id}" required=""
                       style="display: none;"  autocomplete="off" class="layui-input"  >
            </div>
        </div>
        <div class="layui-form-item">
            <label  class="layui-form-label"><span class="x-red">*</span>名称</label>
            <div class="layui-input-inline">
                <input style="height: 28px;width: 260px;" type="text" id="name" value="${employees.name}" name="name"  required="" lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label  class="layui-form-label"><span class="x-red">*</span>账号</label>
            <div class="layui-input-inline">
                <input style="height: 28px;width: 260px;" type="text" id="account" value="${employees.account}" name="account"  required="" lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label  class="layui-form-label"><span class="x-red">*</span>密码</label>
            <div class="layui-input-inline">
                <input style="height: 28px;width: 260px;"type="text" id="password" type="password" value="${employees.password}" name="password"  required="" lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label  class="layui-form-label">
            </label>
            <div type="submit" class="bj-btn" style=" display: block;width: 16%;margin: auto" id="sub" lay-filter="add" onclick="reg()">提交编辑</div>
        </div>
    </form>
</div>

<script type="text/javascript">

    function reg(){
        var account = $("#account").val();
        var password = $("#password").val();
        if(account == null || account == ""){alert("请填写区");return;}
        if(password == null || password == ""){alert("请填写密码");return;}
        $.ajax({
            type : "POST",
            dataType : "json",
            async:false,
            url : "${pageContext.request.contextPath}/JobTask/updateEmp",
            data : $('#form').serialize(),
            success : function(data) {
                var split = data.message.split(",");
                layer.alert(split[0],function () {
                    x_admin_close();
                    window.parent.shuaxin(split[1],split[2]);
                });

            }

        })
    }


</script>

</body>
</html>