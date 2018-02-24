<%@page import="com.zhou.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<script type="text/javascript" src="${basePath }/js/common/page.js"></script>
<script type="text/javascript" src="${basePath }/js/common/back.js"></script>
<script type="text/javascript" src="${basePath }/js/nav/navList.js"></script>
<div >
	<h1 class="title">新闻类别管理<a href="javascript:void(0)" class="back-btn">返回主页</a></h1>
	<table class="tab" cellspacing="20">
		<tr>
			<td class="text-center" >选择</td>
			<td class="text-center">类别名称</td>
			<td class="text-center">排序权重</td>
			<td class="text-center">编辑</td>
		</tr>
		<tbody id="tbodyId">
				
		</tbody>
		<tr>
			<td colspan="1" style="border-bottom:0"><a id="addN" class="btn" href="javascript:void(0)">增加类别</a></td>
			<td colspan="1" style="border-bottom:0"><input type="button" value="删除" class="btn" onclick="onDeleteNav();"></td>
		</tr>
	</table>
<jsp:include page="../common/page.jsp"></jsp:include>
</div>
<div class="win-box" id="win-box">
	<h2 class="win-title">修改新闻类别<span onclick="closeNavWindow(0);">&times;</span></h2>
	<iframe src="" id="update-win"></iframe>
</div>
<script type="text/javascript">
$("#addN").click(function(){
	$(".admin").empty();
	var url="nav/addUI.do?t="+Math.random(1000);
	$(".admin").load(url);
})	
</script>	
	
