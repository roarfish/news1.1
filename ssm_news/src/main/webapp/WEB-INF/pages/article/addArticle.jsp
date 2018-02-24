<%@ page language="java" import="java.util.*"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<script type="text/javascript" src="${basePath }/js/article/back.js"></script>
<script type="text/javascript" src="${basePath }/js/article/addArticle.js"></script>
<script type="text/javascript" src="${basePath }/js/common/project_name.js"></script>
<script></script>
<div>
	<h1 class="title">添加新闻 <a href="javascript:void(0)" class="back-btn">返回</a></h1>
	<form name="frm" action="" id="frm" method="post">
		<table>
			<tr><td>新闻标题：</td><td><input id="article_title" name=article_title autocomplete="off" maxlength="300" type="text"/></td><td id="err_article_title"></td></tr>
	    	<tr><td>新闻类别：</td>
	    		<td>
					<select id="nav_id" name="nav_id" style="width:173px">
					</select>
				</td>
				<td id="err_nav_id"></td>
			</tr>
			<tr><td>发布时间：</td>
				<td>
					<input id="article_date" name="article_date" maxlength="20"
						 type="text" onClick="WdatePicker()" readonly/>
				</td>
				<td id="err_article_date"></td>
			</tr>
			<tr>
				<td valign="top">新闻正文：</td>
				<td colspan="2">
				    <textarea id="content" name="content1" rows="8" cols="100" style="width:680px;height:350px;" ></textarea>
				</td>
			</tr>
	    	<tr><td></td><td><a class="btn" onclick="startPost();" href="javascript:void(0)">保存</a></td></tr>
		</table>
	</form>
</div>
