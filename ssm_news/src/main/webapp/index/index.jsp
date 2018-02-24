<%@page import="com.zhou.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//List <Map>resultList = (List)request.getAttribute("resultList");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>老象学院</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="老象学院,JAVA Web培训,IT培训">
	<meta http-equiv="description" content="老象学院一直专注于信息技术类培训，课程涉及计算机编程语言，如java、C、C++等，还涉及计算机科学与技术专业类课程，如数据结构、高级语言程序设计、数据库系统等，授课教师均为“双师型”（既是大学计算机专业授课教师，也是企业高级工程师），凭借丰富的教学经验与项目开发经验，确保学员既能学到专业基础知识，也能掌握项目开发经验，快速成为IT卓越人才。">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>css/style.css">
  </head>
  <body>
  <jsp:include page="top.jsp"></jsp:include>
  <jsp:include page="nav.jsp"></jsp:include>
  <div class="index-main-box w">
  	<%-- <%
  	for(Map map :resultList){
  		Nav nav = (Nav)map.get("nav");
  		List <Article>articleList = (List)map.get("articleList");
  	%>
  	<div class="panel">
		<div>
			<h2><%=nav.getNav_name() %><a href="articleList.html?nav_id=<%=nav.getNav_id() %>" class="more" target="_blank">更多</a></h2>
			<ul>
				<%
				if(articleList.size()<1){
					out.println("<li>没有数据</li>");
				}else for(Article a:articleList){ %>
				<li><a href="item.html?article_id=<%=a.getArticle_id()%>" target="_blank" title="<%=a.getArticle_title() %>"><%=a.getArticle_title() %></a><span><%=a.getArticle_date() %></span></li>
				<%} %>
			</ul>
		</div>
	</div>
	<%} %> --%>
  </div>
  <jsp:include page="footer.jsp"></jsp:include>
  </body>
</html>
