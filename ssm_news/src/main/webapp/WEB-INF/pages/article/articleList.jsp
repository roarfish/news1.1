<%@ page import="com.zhou.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<script type="text/javascript" src="${basePath }/js/common/page.js"></script>
<script type="text/javascript" src="${basePath }/js/common/back.js"></script>
<script type="text/javascript" src="${basePath }/js/common/project_name.js"></script>
<script type="text/javascript" src="${basePath }/js/article/articleList.js"></script>
<div>
	<h1 class="title">新闻信息列表<a href="javascript:void(0)" class="back-btn">返回主页</a></h1>
	<table class="tab" cellspacing="20">
		<tr>
			<td colspan="5">
				<form action="javascript:void(0)" method="post" id="frm">
					<label>新闻类别</label>
						<select id="nav_id">
	  					</select>
					<label>标题</label>
					<input type="text" name="article_title" id="article_title">
					<input type="button" value="搜索" id="search">
				</form>
			</td>
		</tr>
		<tr>
			<td class="text-center" >选择</td>
			<td class="text-center">序号</td>
			<td class="text-center">新闻标题</td>
			<td class="text-center">类别名称</td>
			<td class="text-center">发布时间</td>
		</tr>
		<tbody id="tbodyId">
					
		</tbody>
		<tr>
			<td colspan="5" style="border-bottom:0">
  				<a class="btn" href="javascript:void(0)" id="addA">添加新闻</a>
  				<a class="btn" href="javascript:void(0)" id="updateA">修改</a>
  				<a class="btn" href="javascript:void(0)" onclick="deleteNews()">删除</a>
  			</td>
		</tr>
	</table>
	<jsp:include page="../common/page.jsp" ></jsp:include>
</div>
<div class="win-box" id="win-box">
  	<h2 class="win-title">修改新闻类别<span onclick="closeNavWindow(0);">&times;</span></h2>
  	<iframe src="" id="update-win"></iframe>
</div>

