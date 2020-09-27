<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <meta charset="UTF-8">
    <title></title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/xadmin.css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/xadmin.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/mobileBUGFix.mini.js"></script>
    <style>

        body {
            background: white;
            overflow: auto;
        }

        input{
            width: 75% !important;
            float: left;
        }
        .Data_name{
            float: left;
            padding: 0 15px;
            width: 12%;
        }
        .data_box{
            margin: 20px 10px;
            float: left;width: 100%;
        }
        .layui-input{
            height: 35px;
            font-size: medium;
        }
        select{height: 40px;width: 75%}
    </style>
</head>
<body style="width: 100%;overflow:hidden;">

<form style="position: fixed;top: 35px;" id="formId" method="post" enctype="multipart/form-data">
    <div style="width: 70%;margin: auto;display: block">
            <div class="data_box">
            <span class="Data_name">开始时间</span>
            <input id="starttime1"   name="starttime"  placeholder="" autocomplete="off" class="layui-input">
            </div>

            <div class="data_box">
            <span class="Data_name">结束时间</span>
            <input id="endtime1"  name="endtime"  placeholder="" autocomplete="off" class="layui-input">
            </div>
        <div class="data_box">
            <span class="Data_name">时长</span>
            <select name="duration">
                <option value ="1">1小时</option>
                <option value ="1.5">1.5小时</option>
                <option value ="2">2小时</option>
                <option value ="2.5">2.5小时</option>
                <option value ="3">3小时</option>
                <option value ="3.5">3.5小时</option>
                <option value ="4">4小时</option>
                <option value ="4.5">4.5小时</option>
                <option value ="5">5小时</option>
                <option value ="5.5">5.5小时</option>
                <option value ="6">6小时</option>
                <option value ="6.5">6.5小时</option>
                <option value ="7">7小时</option>
                <option value ="7.5">7.5小时</option>
                <option value ="8">8小时</option>
                <option value ="8">一天</option>
                <option value ="16">二天</option>
                <option value ="24">三天</option>
                <option value ="32">四天</option>
                <option value ="40">五天</option>
            </select>
<%--
            <input id="duration"   name="duration"  placeholder="" autocomplete="off" class="layui-input">
--%>
        </div>
        <div class="data_box">
            <span class="Data_name">类型</span>
           <select name="type">
               <option value="1">加班</option>
               <option value="2">请假</option>
               <option value="3">业绩</option>
           </select>
        </div>
            <div class="data_box">
            <span class="Data_name">备注</span>
            <textarea style="width: 75%;font-size: medium" id="remark"  name="remark" cols="30" rows="4" ></textarea>
            </div>

            <div onclick="sub()" style="display: -webkit-box;margin: auto;width: 7%;border: 1px #ff7600;border-style: solid;padding: 3px 10px;color: #ff7600;cursor: pointer;text-align: center">提交</div>

       </div>


</form>



</body>
<script>
    $(function(){
        $.ajax({
            type:"POST",
            url:"${pageContext.request.contextPath}/JobTask/getEmployees",
            data:{},
            dataType:"json",
            success:function(data){
                $("#first").html("<option value=''> 请选择 </option>");
                for(var i=0;i<data.length;i++){
                    var $option = $("<option value='"+data[i].id+"'>"+data[i].name+"</option>");
                    $("#first").append($option);
                }
            }
        });
    });


    function setEmpId() {
        var name = $("#first").find("option:selected").text();
        if(name == '请选择'){
            $("#empname").val('');
        }else {
            $("#empname").val(name);
        }
    }

    function sub() {
        $.ajax({
            type : "POST",
            dataType : "json",
            url : "${pageContext.request.contextPath}/flow/writeApplication",
            data : $("#formId").serialize(),
            success : function(data) {
                if(data.code ==1){
                    layer.msg(data.message,{time:1500},function () {
                        x_admin_close();
                        window.parent.location.reload();

                    });
                }else {
                    layer.alert(data.message);
                }


            },
            error:function () {
                layer.alert("网络繁忙 稍后再试")
            }
        })
    }

    layui.use('laydate', function(){
        var laydate = layui.laydate;
        //日期时间选择器
        laydate.render({
            elem: '#starttime1'
            ,type: 'datetime'
        });

        //日期时间选择器
        laydate.render({
            elem: '#endtime1'
            ,type: 'datetime'
        });
    });

</script>
</html>