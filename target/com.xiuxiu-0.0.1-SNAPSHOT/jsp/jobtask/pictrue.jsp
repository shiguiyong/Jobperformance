<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/xadmin.js"></script>
</head>
<body>
<div class="x-body">
    <input type="hidden" id="id" value="<%out.print(request.getParameter("id"));%>">
    <table>
        <tbody id="tb">
       <%-- <c:forEach var="pic" items="${imagedetails}">
            <tr nowrap ><img src="https://www.18725987688.com/jobimages/${pic}" style="height: 500px;width: 350px;"></tr>
        </c:forEach>--%>

    </tbody>
    </table>
</div>
<script>
    $(function () {
        $.ajax({
            type : "POST",
            dataType : "json",
            url : "${pageContext.request.contextPath}/JobTask/lookImages",
            data : {id:$("#id").val()},
            success : function(data) {
                var str='';
                $.each(data,function(index, list){
                    str+=' <tr nowrap ><img src="https://www.18725987688.com/jobimages/'+list+'" style="height: 500px;width: 350px;"></tr>';
                })

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
    })

</script>
</body>
</html>
