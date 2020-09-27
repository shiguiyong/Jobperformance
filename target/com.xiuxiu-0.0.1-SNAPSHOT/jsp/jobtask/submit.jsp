<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/layui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/xadmin.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/font.css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/xadmin.js"></script>
<style>
    .layui-table{
        height: auto;
    }
</style>
</head>
<body>
<form id="formId" method="post" enctype="multipart/form-data">

<input id="id" name="id" type="hidden" value="<%out.print(request.getParameter("taskId"));%>">
<table class="layui-table tab3" style="width:98%;margin-left:1%;overflow: auto;position:relative;max-width: 2400px;">
    <thead>
    <tr>
        <th nowrap width="10%" >备注</th>
    </tr>
    </thead>
    <tbody>
    <tr style="height: 30px;">
        <td nowrap>
            <textarea name="remark" cols="75" rows="4" style="font-size: medium"></textarea>
        </td>
    </tr>
    </tbody>
</table>

    <table class="layui-table tab3" style="width:98%;margin-left:1%;overflow: auto;position:relative;max-width: 2400px;height: 15%">
        <thead>
        <tr>
            <th nowrap width="10%" >上传文件</th>
        </tr>
        </thead>
        <tbody>
        <tr style="height: 25px;">
            <td nowrap>
            <input type="file" name="file">
            </td>
        </tr>
        </tbody>
    </table>


    <section style="cursor: pointer;display: block; text-align: center;border: 1px #00b0f0;border-style: solid;width: 15%;margin: auto;padding: 3px;color: #00b0f0;">
        <div class="tijiao"  lay-filter="add" lay-submit="" id="sub"  >提交</div>
    </section>
</form>
<script>
    $("#sub").click(function () {
        var upload = new FormData($("#formId")[0]);
        $.ajax({
            type : "POST",
            dataType : "json",
            async: false,
            url : "${pageContext.request.contextPath}/JobTask/uploadsub",
            data : upload,
            cache:false,
            contentType: false,
            processData: false,
            success : function(data) {
                if(data.success){
                    layer.alert(data.message,function () {
                        x_admin_close();
                        window.parent.location.reload();
                    });

                }else {
                    layer.alert(data.message)
                }

            },
            error:function () {
                layer.alert("网络繁忙 稍后再试")
            }
        })
    })
</script>
<%--<script>
    $("#fm").click(function () {
        $("#picture").click();
    })

    $("#fm1").click(function () {
        $("#picture1").click();
    })
    $("#fm2").click(function () {
        $("#picture2").click();
    })
    $("#fm3").click(function () {
        $("#picture3").click();
    })
    $("#fm4").click(function () {
        $("#picture4").click();
    })
    $("#fm5").click(function () {
        $("#picture5").click();
    })
    $("#fm6").click(function () {
        $("#picture6").click();
    })
    $("#fm7").click(function () {
        $("#picture7").click();
    })
    $("#fm8").click(function () {
        $("#picture8").click();
    })
    $("#fm9").click(function () {
        $("#picture9").click();
    })

    $('#picture').on('change', function(){
        var imgFiles = $(this)[0].files
        for (i=0;i<imgFiles.length;i++){
            filePath = imgFiles[i].name
            fileFormat = filePath.split('.')[1].toLowerCase()
            src = window.URL.createObjectURL(imgFiles[i])
            if( !fileFormat.match(/png|jpg|jpeg/) ) {
                alert('上传错误,文件格式必须为：png/jpg/jpeg')
                return
            }
            var preview = document.getElementById("previewImg")
            var img = document.createElement('img')
            img.width = 30
            img.height = 30
            img.src = src
            img.className ="img1"
            preview.appendChild(img)
        }
    })

    $(document).on("change","#previewImg",function () {
        if($(this).children().length>1){
            $("#fm").hide();
        }else{
            $("#fm").show();
        }

    })




    $(document).on("click",".img1",function () {
        $(this).remove();
        $("#picture").val("")
    })
    $(document).on("click",".img2",function () {
        $(this).remove();
        $("#picture1").val("")
    })
    $('#picture1').on('change', function(){
        var imgFiles = $(this)[0].files
        for (i=0;i<imgFiles.length;i++){
            filePath = imgFiles[i].name
            fileFormat = filePath.split('.')[1].toLowerCase()
            src = window.URL.createObjectURL(imgFiles[i])
            if( !fileFormat.match(/png|jpg|jpeg/) ) {
                alert('上传错误,文件格式必须为：png/jpg/jpeg')
                return
            }
            var preview = document.getElementById("previewImg1")
            var img = document.createElement('img')
            img.width = 30
            img.height = 30
            img.src = src
            img.className ="img2"
            preview.appendChild(img)
        }
    })
    $(document).on("click",".img3",function () {
        $(this).remove();
        $("#picture2").val("")
    })
    $('#picture2').on('change', function(){
        var imgFiles = $(this)[0].files
        for (i=0;i<imgFiles.length;i++){
            filePath = imgFiles[i].name
            fileFormat = filePath.split('.')[1].toLowerCase()
            src = window.URL.createObjectURL(imgFiles[i])
            if( !fileFormat.match(/png|jpg|jpeg/) ) {
                alert('上传错误,文件格式必须为：png/jpg/jpeg')
                return
            }
            var preview = document.getElementById("previewImg2")
            var img = document.createElement('img')
            img.width = 30
            img.height = 30
            img.src = src
            img.className ="img3"
            preview.appendChild(img)
        }
    })

    $(document).on("click",".img4",function () {
        $(this).remove();
        $("#picture3").val("")
    })
    $('#picture3').on('change', function(){
        var imgFiles = $(this)[0].files
        for (i=0;i<imgFiles.length;i++){
            filePath = imgFiles[i].name
            fileFormat = filePath.split('.')[1].toLowerCase()
            src = window.URL.createObjectURL(imgFiles[i])
            if( !fileFormat.match(/png|jpg|jpeg/) ) {
                alert('上传错误,文件格式必须为：png/jpg/jpeg')
                return
            }
            var preview = document.getElementById("previewImg3")
            var img = document.createElement('img')
            img.width = 30
            img.height = 30
            img.src = src
            img.className ="img4"
            preview.appendChild(img)
        }
    })

    $(document).on("click",".img5",function () {
        $(this).remove();
        $("#picture4").val("")
    })
    $('#picture4').on('change', function(){
        var imgFiles = $(this)[0].files
        for (i=0;i<imgFiles.length;i++){
            filePath = imgFiles[i].name
            fileFormat = filePath.split('.')[1].toLowerCase()
            src = window.URL.createObjectURL(imgFiles[i])
            if( !fileFormat.match(/png|jpg|jpeg/) ) {
                alert('上传错误,文件格式必须为：png/jpg/jpeg')
                return
            }
            var preview = document.getElementById("previewImg4")
            var img = document.createElement('img')
            img.width = 30
            img.height = 30
            img.src = src
            img.className ="img5"
            preview.appendChild(img)
        }
    })
    $(document).on("click",".img6",function () {
        $(this).remove();
        $("#picture5").val("")
    })
    $('#picture5').on('change', function(){
        var imgFiles = $(this)[0].files
        for (i=0;i<imgFiles.length;i++){
            filePath = imgFiles[i].name
            fileFormat = filePath.split('.')[1].toLowerCase()
            src = window.URL.createObjectURL(imgFiles[i])
            if( !fileFormat.match(/png|jpg|jpeg/) ) {
                alert('上传错误,文件格式必须为：png/jpg/jpeg')
                return
            }
            var preview = document.getElementById("previewImg5")
            var img = document.createElement('img')
            img.width = 30
            img.height = 30
            img.src = src
            img.className ="img6"
            preview.appendChild(img)
        }
    })

    $(document).on("click",".img7",function () {
        $(this).remove();
        $("#picture6").val("")
    })
    $('#picture6').on('change', function(){
        var imgFiles = $(this)[0].files
        for (i=0;i<imgFiles.length;i++){
            filePath = imgFiles[i].name
            fileFormat = filePath.split('.')[1].toLowerCase()
            src = window.URL.createObjectURL(imgFiles[i])
            if( !fileFormat.match(/png|jpg|jpeg/) ) {
                alert('上传错误,文件格式必须为：png/jpg/jpeg')
                return
            }
            var preview = document.getElementById("previewImg6")
            var img = document.createElement('img')
            img.width = 30
            img.height = 30
            img.src = src
            img.className ="img7"
            preview.appendChild(img)
        }
    })
    $(document).on("click",".img8",function () {
        $(this).remove();
        $("#picture7").val("")
    })
    $('#picture7').on('change', function(){
        var imgFiles = $(this)[0].files
        for (i=0;i<imgFiles.length;i++){
            filePath = imgFiles[i].name
            fileFormat = filePath.split('.')[1].toLowerCase()
            src = window.URL.createObjectURL(imgFiles[i])
            if( !fileFormat.match(/png|jpg|jpeg/) ) {
                alert('上传错误,文件格式必须为：png/jpg/jpeg')
                return
            }
            var preview = document.getElementById("previewImg7")
            var img = document.createElement('img')
            img.width = 30
            img.height = 30
            img.src = src
            img.className ="img8"
            preview.appendChild(img)
        }
    })
    $(document).on("click",".img9",function () {
        $(this).remove();
        $("#picture8").val("")
    })
    $('#picture8').on('change', function(){
        var imgFiles = $(this)[0].files
        for (i=0;i<imgFiles.length;i++){
            filePath = imgFiles[i].name
            fileFormat = filePath.split('.')[1].toLowerCase()
            src = window.URL.createObjectURL(imgFiles[i])
            if( !fileFormat.match(/png|jpg|jpeg/) ) {
                alert('上传错误,文件格式必须为：png/jpg/jpeg')
                return
            }
            var preview = document.getElementById("previewImg8")
            var img = document.createElement('img')
            img.width = 30
            img.height = 30
            img.src = src
            img.className ="img9"
            preview.appendChild(img)
        }
    })
    $(document).on("click",".img0",function () {
        $(this).remove();
        $("#picture9").val("")
    })
    $('#picture9').on('change', function(){
        var imgFiles = $(this)[0].files
        for (i=0;i<imgFiles.length;i++){
            filePath = imgFiles[i].name
            fileFormat = filePath.split('.')[1].toLowerCase()
            src = window.URL.createObjectURL(imgFiles[i])
            if( !fileFormat.match(/png|jpg|jpeg/) ) {
                alert('上传错误,文件格式必须为：png/jpg/jpeg')
                return
            }
            var preview = document.getElementById("previewImg9")
            var img = document.createElement('img')
            img.width = 30
            img.height = 30
            img.src = src
            img.className ="img0"
            preview.appendChild(img)
        }
    })
</script>--%>
</body>
</html>
