<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
  <meta charset="UTF-8">
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/layui.js" charset="utf-8"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/xadmin.js"></script>

	<title>咻咻国际人力管理系统登录</title>
  
  <link rel="stylesheet" href="../../css/hrloginstyle.css">

</head>
<body >
<div style="position:fixed;top:80px">
	<img src="../../images/hrslogo1.png" style="height:70px;width:auto">
</div>
<div class="container" >
	<form  method="post">
		<div class="input_box">
			<label label_id="input1">用户名</label>
			<input type="text" id="account" name="account" placeholder="用户名/员工ID" input_id="input1">
		</div>
		<div class="input_box">
			<label label_id="input2">密码</label>
			<input type="password" id="password" name="password" placeholder="密码" input_id="input2">
		</div>
		<div style="position: relative;height: 40px;width: 250px;text-align: center;background-color: #66cc66;border: 1px solid #66cc66;font-size: medium;color: white;line-height: 2.5;cursor: pointer" onclick="login()" >
			<span class="btn_txt" >登录</span>

		</div>
	</form>
</div>
<div style="position:fixed;bottom:60px;font-size:12px;color:#0099ff">渝ICP备17006513号丨渝公安备50010802001965</div>


<%--  <script  src="../../js/script.js"></script>--%>
  <script>

	  function login() {
		  var account = $("#account").val();
		  var password = $("#password").val();
		  $.ajax({
			  type: 'get',
			  dataType: "jsonp",
			  url: '${pageContext.request.contextPath}/JobTask/login',
			  data: {
				  account:account,
				  password:password
			  },
			  async: false,
			  traditional: true,
			  success: function (data) {
				  if(data.code == 1){
					location.href="${pageContext.request.contextPath}/jsp/jobtask/index.jsp"
				  }else if(data.code == 3) {
					  location.href="${pageContext.request.contextPath}/jsp/jobtask/manageindex.jsp"
				  }else {
					  layer.msg(data.message,{time:3000});
				  }
			  }
		  });
	  }


  </script>



</body>
</html>
