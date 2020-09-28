<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/layui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/xadmin.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/font.css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/xadmin.js"></script>
    <style type="text/css">
        body{
            margin:0px
        }
    </style>
    <title></title>
</head>
<body style="background:#Fff;">
<div style="">
    <div style="width:calc( 100% - 120px );background:#fff;position:relative;" id="tasklist">
    </div>

    <div style="width:115px;height:100%;float:left;top:0px;left:calc( 100% - 120px );position:fixed;z-index: 99999;" >

        <div style="position:fixed;top:120px" onclick="sousuo(1)">
            <div style="width:80px;height:80px;background:#0099ff;text-align:center;cursor: pointer;">
			<span style="width:60px;height:60px">
			<img src="${pageContext.request.contextPath}/images/all.png" style="margin-top:10px;width:40px;height:40px" >
			</span>

                <p style="color:#fff;font-size:12px;margin-top:0px">全部任务</p>
            </div>
        </div>
        <div style="position:fixed;top:200px" onclick="sousuo(4)">
            <div style="width:80px;height:80px;background:#66cc66;;text-align:center;cursor: pointer;">
			<span style="width:60px;height:60px">
			<img src="${pageContext.request.contextPath}/images/feiji.png" style="margin-top:10px;width:40px;height:40px" >
			</span>

                <p style="color:#fff;font-size:12px;margin-top:0px">已提交</p>
            </div>
        </div>
        <div style="position:fixed;top:280px" onclick="sousuo(2)">
            <div style="width:80px;height:80px;background:#FFC000;;text-align:center;cursor: pointer;">
		<span style="width:60px;height:60px">
		<img src="${pageContext.request.contextPath}/images/wait.png" style="margin-top:10px;width:40px;height:40px" >
		</span>

                <p style="color:#fff;font-size:12px;margin-top:0px">待领取</p>
            </div>
        </div>
        <div style="position:fixed;top:360px" onclick="sousuo(3)">
            <div style="width:80px;height:80px;background:#999999;;text-align:center;cursor: pointer; ">
			<span style="width:60px;height:60px">
			<img src="${pageContext.request.contextPath}/images/kaiguan.png" style="margin-top:10px;width:40px;height:40px" >
			</span>

                <p style="color:#fff;font-size:12px;margin-top:0px">待完成</p>
            </div>
        </div>

        <div style="position:fixed;top:440px" onclick="sousuo(5)">
            <div style="width:80px;height:80px;background:#EE1A44;;text-align:center;cursor: pointer; ">
			<span style="width:60px;height:60px">
			<img src="${pageContext.request.contextPath}/images/kaiguan.png" style="margin-top:10px;width:40px;height:40px" >
			</span>

                <p style="color:#fff;font-size:12px;margin-top:0px">待返工</p>
            </div>
        </div>
        <div style="position:fixed;top:520px"  onclick="sousuo(7)">
            <div style="width:80px;height:80px;background:#0099ff;;text-align:center;cursor: pointer;">
			<span style="width:60px;height:60px">
			<img src="${pageContext.request.contextPath}/images/bub.png" style="margin-top:10px;width:40px;height:40px" >
			</span>

                <p style="color:#fff;font-size:12px;margin-top:0px">已完成</p>
            </div>
        </div>
    </div>

</div>

<form id="formId" style="display: none">
    <input id="dateType" name="dateType" value="addtime" >
    <input  id="status"  name="status"  >
</form>


<script>
    $(function () {
        getTask(1);
    })

    function getTask(pageNum) {
        $.ajax({
            type : "POST",
            dataType : "json",
            url : "${pageContext.request.contextPath}/JobTask/queryDetailsAjax?pageNum="+pageNum+"",
            data :$('#formId').serialize(),
            success : function(data) {
                var str='';
                $.each(data.list,function(index, list){
                    str +=' <div style="width:20%;background:#a8e8ff;position:relative;margin-left:10px;margin-top:10px;z-index:9;height:330px;border-radius:5px;float:left">';
                    str +=' <p style="padding:10px">';
                    if(list.status == 1){
                        str +=' <span style="font-size:12px;background:#00b0f0;color:white" id="status'+list.id+'">待审核</span>' ;
                    }
                    if(list.status == 2){
                        str +=' <span style="font-size:12px;background:#ffc000;color:white" id="status'+list.id+'">待领取</span>' ;
                    }
                    if(list.status == 3){
                        str +=' <span style="font-size:12px;background:#00b0f0;color:white" id="status'+list.id+'">待提交</span>' ;
                    }
                    if(list.status == 4){
                        str +=' <span style="font-size:12px;background:#00b0f0;color:white" id="status'+list.id+'">待审核</span>' ;
                    }
                    if(list.status == 5){
                        str +=' <span style="font-size:12px;background:#ee1a44;color:white" id="status'+list.id+'">待返工</span>' ;
                    }
                    if(list.status == 6){
                        str +=' <span style="font-size:12px;background:#00b0f0;color:white" id="status'+list.id+'">返工中</span>' ;
                    }
                    if(list.status == 7){
                        str +=' <span style="font-size:12px;background:#00b0f0;color:white" id="status'+list.id+'">已完成</span>' ;
                    }
                    if(list.status == 8){
                        str +=' <span style="font-size:12px;background:#00b0f0;color:white" id="status'+list.id+'">已返完</span>' ;
                    }
                    str +=' <span style="font-weight:800">'+list.tasktitle+'</span>';

                    str +=' <span><img src="${pageContext.request.contextPath}/images/tips.png" style="width:24px;height:24px" ></span> </p>';
                    str +='<p style="padding:10px">';
                    str +=' <span><img src="${pageContext.request.contextPath}/images/时钟.png" style="width:20px;height:20px;background:#9d9d9d;border-radius:5px" ></span>';
                    str +=' <span style="font-size:12px;line-height:15px;">'+list.workhours+'小时</span>';
                    str +=' <span><img src="${pageContext.request.contextPath}/images/警报.png" style="width:20px;height:20px;background:#9d9d9d;border-radius:5px" ></span>';
                    str +=' <span style="font-size:12px;line-height:15px;">'+list.addtime+'</span></p><p style="margin:10px;">';
                    str +=' <span style="font-size:12px">任务详情：'+list.taskdetails+'</span></p>';
                    if(list.image !=null){
                        str+='<p style="margin:0 10px;padding:5px 10px;cursor: pointer" onclick="downloadLocal(\''+list.image+'\')">';
                        str +=' <span><img src="${pageContext.request.contextPath}/images/fj.png" style="width:25px;height:25px;background:#9d9d9d;border-radius:5px" ></span>';
                        str +=' <span style="font-size:12px;line-height:15px;">下载任务附件</span></p>';

                    }
                    if(list.fileurl !=null){
                        str+='<p style="margin:0 10px;padding:5px 10px;cursor: pointer" onclick="downloadLocal(\''+list.fileurl+'\')">';
                        str +=' <span><img src="${pageContext.request.contextPath}/images/fj.png" style="width:25px;height:25px;background:#9d9d9d;border-radius:5px" ></span>';
                        str +=' <span style="font-size:12px;line-height:15px;">下载提交附件</span></p>';
                    }
                    if(list.reworkurl !=null){
                        str+='<p style="margin:0 10px;padding:5px 10px;cursor: pointer" onclick="downloadLocal(\''+list.reworkurl+'\')">';
                        str +=' <span><img src="${pageContext.request.contextPath}/images/fj.png" style="width:25px;height:25px;background:#9d9d9d;border-radius:5px" ></span>';
                        str +=' <span style="font-size:12px;line-height:15px;">下载返工附件</span></p>';

                    }
                    if(list.reworkremark ==null){
                        str +=' <p style="margin:0 10px;"><span style="font-size:12px"> 返工备注：</span></p>';
                    }else {
                        str +=' <p style="margin:0 10px;"><span style="font-size:12px"> 返工备注：'+list.reworkremark+'</span></p>';
                    }
                    str +=' <p style="margin:0 10px;"><span style="font-size:12px"> 起始时间：'+list.starttime+'</span></p>';
                    str +=' <p style="margin:0 10px;"><span style="font-size:12px"> 终止时间：'+list.endtime+'</span></p>';

                    if(list.addtime ==null){
                        str +=' <p style="margin:0 10px;"><span style="font-size:12px"> 分配时间：</span></p>';
                    }else {
                        str +=' <p style="margin:0 10px;"><span style="font-size:12px"> 分配时间：'+list.addtime+'</span></p>';
                    }
                    if(list.claimtime == null){
                        str +=' <p style="margin:0 10px;"><span style="font-size:12px"> 领取时间：</span></p>';
                    }else {
                        str +=' <p style="margin:0 10px;"><span style="font-size:12px"> 领取时间：'+list.claimtime+'</span></p>';
                    }
                    if(list.subtime ==null){
                        str +=' <p style="margin:0 10px;"><span style="font-size:12px"> 提交时间：</span></p>';
                    }else {
                        str +=' <p style="margin:0 10px;"><span style="font-size:12px"> 提交时间：'+list.subtime+'</span></p>';
                    }
                    if(list.confirmtime ==null){
                        str +=' <p style="margin:0 10px;"><span style="font-size:12px"> 审核时间：</span></p>';
                    }else {
                        str +=' <p style="margin:0 10px;"><span style="font-size:12px"> 审核时间：'+list.confirmtime+'</span></p>';
                    }
                    if(list.remark ==null){
                        str +=' <p style="margin:0 10px;"><span style="font-size:12px"> 任务备注：</span></p>';
                    }else {
                        str +=' <p style="margin:0 10px;"><span style="font-size:12px"> 任务备注：'+list.remark+'</span></p>';
                    }
                    str +=' <p style="margin:0 10px;padding:5px 10px;text-align:center" id="sub'+list.id+'">';
                    if(list.status == 2 || list.status == 5){
                        str +=' <span style="background:#00b0f0;padding:2px 8px;font-size:14px;color:white;border-radius:3px;cursor: pointer" onclick="claimtask('+list.id+')">领取</span>';
                    }
                    if(list.status == 3 || list.status == 6){
                        str +=' <span style="background:#00b0f0;padding:2px 8px;font-size:14px;color:white;border-radius:3px;cursor: pointer" onclick="sub('+list.id+')">提交</span>';
                    }

                    str+='</p></div>';

                })
                pagenum=parseInt(data.pageNum);
                pagenum0=pagenum-1;
                pagenum1=pagenum+1;
                pagenum2=pagenum+2;
                pagenum3=pagenum+3;
                var htm = "<a   href='#' onclick='getTask(1)'>首页 </a><a   href='#' onclick='getTask(" + data.prePage + ")'>上一页 </a>";
                if (data.pageNum > 1) {
                    htm += "<a   href='#' onclick='getTask(" + pagenum0 + ")'>" + pagenum0 + " </a>"
                }
                htm += "<span   >" + data.pageNum + "</span> ";
                if (data.lastPage - data.pageNum > 0) {
                    htm += "<a   href='#' onclick='getTask(" + pagenum1 + ")'>" + pagenum1 + " </a>"
                } else {
                    htm += "<a   href='#' ></a>"
                }
                if (data.lastPage - data.pageNum > 1) {
                    htm += "<a   href='#' onclick='getTask(" + pagenum2 + ")'>" + pagenum2 + " </a>"
                } else {
                    htm += "<a   href='#' ></a>"
                }
                if (data.lastPage - data.pageNum > 2 & data.pageNum == 1) {
                    htm += "<a   href='#' onclick='getTask(" + pagenum3 + ")'>" + pagenum3 + " </a>"
                }
                htm += "<a   href='#' onclick='getTask(" + data.nextPage + ")'> 下一页</a><a   href='#' onclick='getTask(" + data.pages + ")'> 尾页</a><span  > 共有" + data.pages + "页 </span>"
                htm += '<input class="layui-input-ym" id="goPageNum" type="text"  placeholder="页码" name="page" autocomplete="off" style="">&nbsp<button class="tiaozhuan"   onclick="getTask()"  type="layui-submit">  跳转</button>'
                //$("#pagefoot").html(htm);
                //$("#total").html("共有数据："+data.total+" 条");
                $("#tasklist").html(str);
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
    }



    function sousuo(type) {
        if(type == 1 ){
            $("#status").val('');
        }else {
            $("#status").val(type);
        }
        getTask(1);
    }

    function sub(id) {
        layer.open({
            type: 2,
            title: ['新增','color:black;background-color:#ffc000;'],
            shadeClose: true,
            shade: 0.8,
            area: ['35%', '90%'],
            content: '${pageContext.request.contextPath}/jsp/jobtask/submit.jsp?taskId='+id,
        });
        /*layer.open({
            type: 2,
            title: ['提交任务','color:black;background-color:#ffc000;'],
            shadeClose: true,
            shade: 0.8,
            area: ['40%', '60%'],
            content: '${pageContext.request.contextPath}/jsp/jobtask/submit.jsp?taskId='+id,
            end:function () {
                location.reload();
            }
        });
*/
    }
    function claimtask(id) {
        var status = $("#status"+id).text();
        if(status != '待领取'&&status != '待返工'){
            layer.msg('您已经领取了此任务，无需再次领取',{time:2000});

            return ;
        }

        layer.alert("请确认完成时长和截至时间，一旦领取后，时间无法修改", {
            skin: 'layui-layer-lan' //样式类名  自定义样式
            ,closeBtn: 1   // 是否显示关闭按钮
            ,anim: 1 //动画类型
            ,btn: ['确定','取消'] //按钮
            ,icon: 6    // icon
            ,time:3000
            ,yes:function(){
                var sss='<span style="background:#00b0f0;padding:2px 8px;font-size:14px;color:white;border-radius:3px;cursor: pointer" onclick="sub('+id+')">提交</span>';
                $.ajax({
                    type : "POST",
                    dataType : "json",
                    url : "${pageContext.request.contextPath}/JobTask/updateclaimStatus",
                    data : {id:id},
                    success : function(data) {
                        if(data.code ==1){
                            layer.msg('领取成功',{time:1500},function () {
                                //location.reload();
                                $("#status"+id).html("待提交")
                                $("#sub"+id).html(sss)

                            });
                        }else {
                            layer.alert('领取失败');
                        }


                    },
                    error:function () {
                        layer.alert("网络繁忙 稍后再试")
                    }
                })
            }
        });



    }


    function downloadLocal(fileurl) {
        location.href="${pageContext.request.contextPath}/JobTask/downloadLocal?fileurl="+fileurl;
    }


    function closeAll() {
        layer.closeAll();
    }

</script>



</body>
</html>