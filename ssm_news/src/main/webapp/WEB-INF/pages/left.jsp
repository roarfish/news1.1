<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
	<div class="left-menu">
		<h1 class="title">导航菜单</h1>
		<ul>
			<li><a href="javascript:void(0)" id="load-manager-list">用户管理</a></li>
			<li><a href="javascript:void(0)" id="load-nav-list">类别管理</a></li>
			<li><a href="javascript:void(0)" id="load-article-list">文章管理</a></li>
			<li><a href="logout.do">退出系统</a></li>
		</ul>
	</div>

<script type="text/javascript">
$("#load-manager-list").click(function(){
	$(".admin").empty();
	var url="manager/listUI.do?t="+Math.random(1000);
	$(".admin").load(url);
})
$('#load-nav-list').click(function(){
	$(".admin").empty();
	var url="nav/listUI.do?t="+Math.random(1000);
	$(".admin").load(url);
})
$('#load-article-list').click(function(){
	$(".admin").empty();
	var url="article/listUI.do?t="+Math.random(1000);
	$(".admin").load(url);
})
</script>