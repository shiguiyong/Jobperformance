<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <style>
        body{
            margin:0
        }
		@media only screen and (min-width:769px) {
		.lsbox{width:31%;height:auto;background:#f2f2f2;margin:10px;position:relative;float:left;border-radius:5px;padding-bottom:10px}
		}
		@media only screen and (max-width:768px) {
		.lsbox{width:96%;height:auto;background:#f2f2f2;margin:10px;position:relative;float:left;border-radius:5px;padding-bottom:5px}
		}
		.lsnum{color:#66CC66;font-size: 16px;}    
			</style>
    <meta charset="utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/layui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/xadmin.css">
    <script src="${pageContext.request.contextPath }/js/jquery.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/xadmin.js"></script>
    <title></title>
</head>
<body>
<div  class="lsbox" id="data">
    <div style="margin-left:10px;margin-top:10px" id="emolument">
        <span style="color:#0099ff;font-weight:800;font-size:14px">丨</span>
        <span style="font-size:14px">薪资概览</span>
        <div>
            <div style="width:25%;text-align: center;float: left;margin-top: 10px;">
                <span class="lsnum">${employees.basic}</span>
                <p style="font-size:12px;"> 基本工资</p>
            </div>
            <div style="width:25%;text-align: center;float: left;margin-top: 10px;">
                <span class="lsnum">${employees.performance} </span>
                <p style="font-size:12px;">绩效基数</p>
            </div>
            <div style="width:25%;text-align: center;float: left;margin-top: 10px;">
                <span class="lsnum">  <fmt:formatNumber type="percent" value="${employees.performancepercent}" maxFractionDigits="3"  /></span>
                <p style="font-size:12px;">
                绩效比例
              </p>
            </div>
            <div style="width:25%;text-align: center;float: left;margin-top: 10px;">
                <span class="lsnum"> ${employees.yuperformance}</span>
                <p style="font-size:12px;">预计绩效</p>
            </div>
            <div style="width:25%;text-align: center;float: left;margin-top: 10px;">
                <span class="lsnum">${employees.present} </span>
                <p style="font-size:12px;">全勤奖励</p>
            </div>
            <div style="width:25%;text-align: center;float: left;margin-top: 10px;">
                <span class="lsnum">${employees.reducepresent} </span>
                <p style="font-size:12px;">出勤扣减</p>
            </div>
            <div style="width:25%;text-align: center;float: left;margin-top: 10px;">
                <span class="lsnum">${employees.addwork} </span>
                <p style="font-size:12px;">提成</p>
            </div>
            <div style="width:25%;text-align: center;float: left;margin-top: 10px;">
                <span class="lsnum">${employees.basic+employees.addwork+employees.present+employees.yuperformance-employees.reducepresent} </span>
                <p style="font-size:12px;">预计总数</p>
            </div>

        </div>
    </div>
</div>
<div class="lsbox">
    <div style="margin-left:10px;margin-top:10px">
        <span style="color:#0099ff;font-weight:800;font-size:14px">丨</span>
        <span style="font-size:14px">薪资概览</span>
    </div>
</div>
<div class="lsbox">
    <div style="margin-left:10px;margin-top:10px">
        <span style="color:#0099ff;font-weight:800;font-size:14px">丨</span>
        <span style="font-size:14px">注意事项</span>
        <p style="font-size: 12px;">1.该绩效体系拥有10%容错率，即允许因有可能的失误或时间判断失误而导致的未完成。10%以内的“未完成”系统将不会统计在绩效以内；</p>
        <p style="font-size: 12px;">2.以约定时间内的审核通过作为完成标准，只是提交或超过截止时间均为未按时完成，请大家合理分配时间；</p>
        <p style="font-size: 12px;">3.领取任务前请确定截止时间与完成时长，领取之后将不作修改；超过截止时间未领取的作未完成处理；</p>
        <p style="font-size: 12px;">4.<strong>薪资的30%</strong>将作为绩效基数；低于90%的完成率将作为系数体现在绩效基数上，可通过系统实时查看当月完成率；</p>
        <p style="font-size: 12px;">5.本体系鼓励提前完成任务，每个任务的时长将是人事部判定是否需要加班的参考标准，如需加班<strong>请提请加班申请</strong>，人事部核准后将自动核算在系统当中；</p>
        <p style="font-size: 12px;">6.请在系统内提交完成结果以方便系统自动统计，该系统以外的口头提交或聊天提交均不会被系统统计，请预留审核时间以防需返工而导致超时未完成；</p>
        <p style="font-size: 12px;">7.该体系从即日起试运行，于2020年10月1日起正式实施；</p>

        <p style="font-size: 12px;">8.统计周期为一个自然月，最终解释权归咻咻国际行政人事所有。</p>

    </div>
</div>
</body>
<script>
    $(function () {
        initialize();
    })

    function initialize() {
        $.ajax({
            type : "POST",
            dataType : "json",
            url : "${pageContext.request.contextPath}/JobTask/queryAllAjax?pageNum="+pageNum+"",
            data : {},
            success : function(data) {
                var str='';
                $.each(data.list,function(index, list){
                    str+='   <span style="color:#0099ff;font-weight:800;font-size:14px">丨</span>';
                    str+='       <span style="font-size:14px">薪资概览</span>';
                    str+='        <div><div style="width:25%;text-align: center;float: left;margin-top: 10px;">' ;
                    str+='               <span style="color:#66CC66;"> 基本工资</span>';
                    str+='              <p style="font-size:12px;">基本工资</p></div>';
                    str+='           <div style="width:25%;text-align: center;float: left;margin-top: 10px;">';
                    str+='               <span style="color:#66CC66"> 绩效基数</span>';
                    str+='                <p style="font-size:12px;">绩效基数</p> </div>';
                    str+='           <div style="width:25%;text-align: center;float: left;margin-top: 10px;">';
                    str+='               <span style="color:#66CC66"> 绩效比例</span>';
                    str+='               <p style="font-size:12px;">绩效比例</p></div>';
                    str+='           <div style="width:25%;text-align: center;float: left;margin-top: 10px;">';
                    str+='               <span style="color:#66CC66"> 预计绩效</span>';
                    str+='               <p style="font-size:12px;">预计绩效</p></div>';
                    str+='           <div style="width:25%;text-align: center;float: left;margin-top: 10px;">';
                    str+='               <span style="color:#66CC66"> 全勤奖励</span>';
                    str+='              <p style="font-size:12px;">全勤奖励</p></div>';
                    str+='          <div style="width:25%;text-align: center;float: left;margin-top: 10px;">';
                    str+='               <span style="color:#66CC66"> 出勤扣减</span>';
                    str+='               <p style="font-size:12px;">出勤扣减</p></div>';
                    str+='           <div style="width:25%;text-align: center;float: left;margin-top: 10px;">';
                    str+='               <span style="color:#66CC66"> 提成</span>';
                    str+='               <p style="font-size:12px;">加班/业绩提成</p></div>';
                    str+='           <div style="width:25%;text-align: center;float: left;margin-top: 10px;">';
                    str+='               <span style="color:#66CC66"> 预约总数</span>';
                    str+='              <p style="font-size:12px;">预约总数</p>';
                    str+='           </div></div>';





                })
                $("#emolument").html(str);
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

</html>
