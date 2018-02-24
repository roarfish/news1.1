<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<span id="pageId" >
		<a class="first">首页</a>
		<a class="pre">上一页</a>&nbsp;
		<a class="next">下一页</a>
		<a class="last">尾页</a>
		<a class="pageCount"></a>
		<a class="pageCurrent"></a>
		<a class="rowCount"></a>
		跳转至<select id="select" onchange="go2page(this.value);" style="width:40px"></select>页
	</span>
	
	