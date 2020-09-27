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
<div style="width:100%;background:#0099ff;position:fixed;top:0px;left:0px;float:left;text-align:center">
    <div style="line-height:44px;float:left">
        <img src="${pageContext.request.contextPath}/images/返回.png"  style="width:20px;height:20px;margin-top:10px;margin-left:10px">
        <!-- 	<span style="font-size:12px;color:white;bottom:10px">返回</span> -->

    </div>
    <div style="line-height:44px;font-size:14px;color:#fff">打卡</div>

</div>
<div>
    <div style="position:fixed;top: 30%;left: 40%">
        <span onclick="shangban()" style="font-size:14px;background:#0099ff;padding:5px 8px;border-radius:3px;color:white">上班打卡</span>
    </div>
</div>

<div>
    <div style="position:fixed;top: 50%;left: 40%">
        <span onclick="xiaban()" style="font-size:14px;background:#0099ff;padding:5px 8px;border-radius:3px;color:white">下班打卡</span>
    </div>
</div>

<div class="dakacg" style="display:none;position:fixed;width:100%;height:100%;left:0px;top:44px;background:#fff">
    <div style="position:fixed;width:100px;height:120px;background:white;top:calc( 50% - 50px );left:calc( 50% - 50px );text-align:center">
        <span> <img src="${pageContext.request.contextPath}/images/cg.png" style="width:40px;height:40px;margin-top:15px" ></span>
        <p style="font-size:13px">打卡成功</p>
    </div>
</div>
<div class="dakasb" style="display:none;position:fixed;width:100%;height:100%;left:0px;top:44px;">
    <div class="dakagb" style="position:fixed;width:100%;height:100%;left:0px;top:44px;background:rgb(0,0,0,0.3)">
        <div style="position: fixed;width: 180px;height: 175px;background: white; top: 27%;left: 27%; text-align: center;">
            <span> <img src="${pageContext.request.contextPath}/images/cw.png" style="width:40px;height:40px;margin-top:15px" ></span>
           <div id="divid">
            <p style="font-size:13px">打卡失败</p>
            <p style="font-size:12px">重新点击打卡</p>
           </div>
        </div>
    </div>
</div>
<!-- 当前URL -->
<input type="text" name="nowurl" id="nowurl" style="display: none">
<!-- 来源URL -->
<input type="text" name="fromurl" id="fromurl" style="display: none"><br>

<!-- 是否是微信 -->
<input type="text"  name="lsframe2" id="lsframe2" style="display: none"><br>
<!-- 获取时间 -->
<input type="text"  name = "addtime"  id="addtime" style="display: none">
<form id="formId" style="margin-top: 55px;display: none">
    <!-- 获取ip -->
    <input type="text"   id="ip" name="ip"><br>
    <!-- 来源设备 -->
    <input type="text" name="fromsystem" id="equipment"><br>
    <!-- ip所在地 -->
    <input type="text"  name="address" id="ipaddress"><br>

    <input type="text" name="useragent" id="useragent" style="width: 100%"><br>
</form>

</body>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.0.js"></script>
<script src="https://pv.sohu.com/cityjson?ie=utf-8"></script>
<script src="${pageContext.request.contextPath}/js/Statistics.js"></script>
<script type="text/javascript">

    $(".dakagb").click(function(){
        $(".dakasb").fadeOut();
    })
    $(".dakacg").click(function(){
        $(".dakacg").fadeOut();
    })

    $(function () {
        /* 获取ip */
        $("#ip").val(returnCitySN['cip']);
        /* 获取城市 */
        $("#ipaddress").val(returnCitySN['cname']);

        $("#useragent").val(navigator.userAgent);

    })

    function shangban() {
        $.ajax({
            type : "POST",
            dataType : "json",
            url : "${pageContext.request.contextPath}/flow/shangban",
            data : $("#formId").serialize(),
            success : function(data) {
                if(data.code == 1){
                    $(".dakacg").fadeIn();

                }else {
                    var str='<p style="font-size:13px">打卡失败</p><p style="font-size:12px">'+data.message+'</p></div></div></div>';
                    $("#divid").html(str);
                    $(".dakasb").fadeIn();
                }
            },
            error:function () {
                layer.alert("网络繁忙 稍后再试")
            }
        })

    }

    function xiaban() {
        $.ajax({
            type : "POST",
            dataType : "json",
            url : "${pageContext.request.contextPath}/flow/xiaban",
            data : $("#formId").serialize(),
            success : function(data) {
                if(data.code == 1){
                    $(".dakacg").fadeIn();

                }else {
                    var str='<p style="font-size:13px">打卡失败</p><p style="font-size:12px">'+data.message+'</p></div></div></div>';
                    $("#divid").html(str);
                    $(".dakasb").fadeIn();
                }
            },
            error:function () {
                layer.alert("网络繁忙 稍后再试")
            }
        })

    }
</script>
</html>
