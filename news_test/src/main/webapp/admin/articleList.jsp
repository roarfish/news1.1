<%@page import="com.action.bean.ActionBean,com.entity.*,java.util.*,com.tools.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	int p=MyFuns.string2Int(request.getParameter("p"));
	String nav_id=request.getParameter("nav_id");
	String article_title=MyFuns.convert2Utf8(request.getParameter("article_title"));
	if(p<0){
		response.sendRedirect("articleList.jsp");
	}
	ActionBean actionBean=new ActionBean();
	//List<ArticlePojo> article=actionBean.queryArticleAll();
	Map maps=actionBean.queryArticleByPage(p,nav_id,article_title);
	List<Map> map=(List<Map>)maps.get("list");
	if(p>0 && map.size()<1){
		response.sendRedirect("articleList.jsp");
	}
	List<Nav> nav_list=(List<Nav>)maps.get("navList");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<base href="<%=basePath%>">
<link href="<%=basePath %>css/style.css" rel="stylesheet" type="text/css">
<title>新闻信息列表</title>
<script type="text/javascript">
	/* 修改管理员信息 */
	function updateManager(btn){
		var tr=btn.parentNode.parentNode;
		var tds=tr.getElementsByTagName("td");
		var id=tds[2].innerHTML;
		location="editManager.jsp?manager_id="+id;
	}
	/* 查看被选中的管理员 */
	function selectedRow(){
		var ms=document.getElementsByName("box");
		debugger
		var obj=null;
		for(i=0;i<ms.length;i++){
			if(ms[i].checked){
				obj=ms[i];
				break;
			}
		}
		if(null==obj){
			alert("请选择要删除的新闻");
			return;
		}
		return obj;
	}
	/* 删除被选中的管理员 */
	function deleteNews(){
  		var obj = selectedRow();
  		if(obj==null)return;
  		if(confirm("您确认要删除此新闻吗？")){
  			location="<%=basePath%>deleteNews?article_id="+obj.value;
  		}
  	}
	
	function updateNews(){
		var obj = selectedRow();
  		if(obj==null)return;
  		location="editNews.jsp?article_id="+obj.value;
	}
	
	function go2Page(page){
		document.getElementById("go_page_number").value=page;
  		document.getElementById("frm").submit();		
	}
</script>
</head>
<body>
	<div class="main-frame">
	<jsp:include page="top.jsp"></jsp:include>
	<jsp:include page="left.jsp"></jsp:include>
	<div class="right">
	<div class="admin" align="center" >
		<h1 class="title">新闻信息列表<a href="<%=basePath%>admin/main.jsp" class="back-btn">返回主页</a></h1>
		<table class="tab" cellspacing="20">
			<tr>
				<td colspan="5">
				<form action="admin/articleList.jsp" method="post" id="frm">
					<label>新闻类别</label>
					<select name="nav_id">
						<option value="">===请选择新闻类别:===</option>
						<% for(Nav nav:nav_list){
  							%>
  							<option value="<%=nav.getNav_id() %>" <%=(nav.getNav_id().equals(nav_id)?"selected='selected' ":"") %>><%=nav.getNav_name() %></option>
  							<%
							}
  						 %>					
  					</select>
					<label>标题</label>
					<input type="text" name="article_title" id="article_title" value="<%=article_title==null?"":article_title%>">
					<input type="hidden" name="p" id="go_page_number" value="<%=p%>">
					<input type="submit" value="搜索">
				</form>
				</td>
			</tr>
			<tr>
				<td class="text-center" >选择</td>
				<td class="text-center">序号</td>
				<td class="text-center">新闻标题</td>
				<td>类别名称</td>
				<td>发布时间</td>
			</tr>
			<%
				int i=5*p;
				int totalNews=(Integer)maps.get("rows");
				int totalPages=totalNews % 5==0?totalNews/5:totalNews/5+1;
				for(Map art : map){
			%>
						<tr>
						<td align="center"><input type="radio" name="box" value="<%=art.get("article_id")%>"></td>
						<td align="center"><%=++i %></td>
						<td align="center"><%=art.get("article_title") %></td>
						<td><%=art.get("nav_name") %></td>
						<td><%=art.get("article_date") %></td>
						</tr>
					<%
				}
			%>
			<tr>
				<td colspan="5" class="page">
				<span>共<%=totalNews %>条新闻</span><span>当前为第<%=p+1%>页</span>	
				<%
					if(p>0){
						%>
						<a href="javascript:void(0)" onclick="go2Page(0)">第一页</a>
	  					<a href="javascript:void(0)" onclick="go2Page(<%=p-1%>)">上一页</a>
						<%
					}
				%>
				<%
					if(p<totalPages-1){
						%>
						<a href="javascript:void(0)" onclick="go2Page(<%=p+1%>)">下一页</a>
	  					<a href="javascript:void(0)" onclick="go2Page(<%=totalPages-1%>)">最后一页</a>
						<%
					}
				%>
				<span>共<%=totalPages %>页</span>
	  				<%if(totalPages>1){ %>
	  				<span>转到第
	  					<select onchange="go2Page(this.value)">
	  					<%for(int j=0;j<totalPages;j++){ %>
	  						<option value="<%=j%>"<%=j==p?"selected='selected'":""%>><%=j+1%></option>
	  					<%} %>
	  					</select>
	  					页
	  				</span>
	  				<%} %>	
				</td>
			</tr>
			<tr>
				<td colspan="5" style="border-bottom:0">
  				<a class="btn" href="admin/addArticle.jsp">添加新闻</a>
  				<a class="btn" href="javascript:void(0)" onclick="updateNews()">修改</a>
  				<a class="btn" href="javascript:void(0)" onclick="deleteNews()">删除</a>
  			</td>
			</tr>
		</table>
		
	</div>
	</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<div class="win-box" id="win-box">
  	<h2 class="win-title">修改新闻类别<span onclick="closeNavWindow(0);">&times;</span></h2>
  	<iframe src="" id="update-win"></iframe>
  </div>
</body>
</html>