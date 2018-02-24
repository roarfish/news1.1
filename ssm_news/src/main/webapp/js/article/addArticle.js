$(function(){
	var idname="#nav_id";
	doSetProjects(idname)
})


 function valiInput(id,msg,n){
	var val = $("#"+id).val();
	$("#err_"+id).html("");
	if(val=="" || val.length<n){
		$("#err_"+id).html("<span class='err'>"+msg+"</span>");
		return false;
	}else{
		$("#err_"+id).html("<span class='success'>验证通过。</span>");
		return true;
	}
}

function startPost(){
	var ipts=["article_title","nav_id","article_date"];
	var lens=[2,1,10];
	var msg=["请输入标题，至少两个字符。","请选择新闻类别","请输入发布时间"];
	var flag=true;
	for(var i=0;i<ipts.length;i++){
		flag = valiInput(ipts[i],msg[i],lens[i])&&flag;
	}
	if(!flag)return;
	
	var url="article/addArticle.do";
	var params={
			article_date:$("#article_date").val(),
			article_title:$("#article_title").val(),
			nav_id:$("#nav_id").val(),
			article_content:$("#content").val()
		}
	$.post(url,params,function(result){
		if(result.state==1){
			doback()
		}else{
			alert(result.message)
		}
	})
}


	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
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
		var obj = null;
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
  			location="${basePath}deleteNews?article_id="+obj.value;
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