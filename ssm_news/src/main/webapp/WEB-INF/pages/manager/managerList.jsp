<%@ page import="com.zhou.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<script type="text/javascript" src="${basePath }/js/manager/manager_list.js"></script>
<script type="text/javascript" src="${basePath }/js/common/page.js"></script>
<script type="text/javascript" src="${basePath }/js/common/back.js"></script>
<div>
	<h1 class="title">管理员信息列表<a href="javascript:void(0)" class="back-btn">返回主页</a></h1>
	<table class="tab" cellspacing="20">
		<tr>
			<td class="text-center" >选择</td>
			<td class="text-center">序号</td>
			<td class="text-center">登录账号</td>
			<td class="text-center">登录姓名</td>
			<td class="text-center">编辑</td>
			</tr>
		<tbody id="tbodyId">
					
		</tbody>
		<tr>
			<td colspan="1" style="border-bottom:0"><a id="addM" class="btn" href="javascript:void(0)">增加管理员</a></td>
			<td colspan="1" style="border-bottom:0"><input type="button" value="删除" class="btn" onclick="onDeleteManager();"></td>
		</tr>
	</table>
	<jsp:include page="../common/page.jsp"></jsp:include>
</div>
<script type="text/javascript">
$("#addM").click(function(){
	$(".admin").empty();
	var url="manager/addUI.do?t="+Math.random(1000);
	$(".admin").load(url);
})	
</script>