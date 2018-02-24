<%@ page import="com.zhou.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<script type="text/javascript" src="${basePath }/js/nav/back.js"></script>
<div>
	<h1 class="title">修改分类信息 <a href="javascript:void(0)" class="back-btn">返回</a></h1>
	<form action="" id="for" method="post">
		<input type="hidden" name="nav_id" value="">
		<table>
			<tr><td>新闻类别名称：</td><td><input id="nav_name" name="nav_name" maxlength="10" type="text"></td><td id="err_nav_name"></td></tr>
			<tr><td align="right">权重：</td><td><input id="nav_feight" name="nav_feight" maxlength="20" type="text" ></td><td id="err_nav_feight"></td></tr>
			<!-- <tr><td><input type="submit" value="保存"></td></tr> -->
			<tr><td><a onclick="startPost()" class="btn" href="javascript:void(0)">保存</a></td></tr>
		</table>
	</form>
</div>
<script type="text/javascript" src="${basePath }/js/nav/editNav.js"></script>
