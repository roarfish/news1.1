$(function(){
	doGetObjects();
})

// 分页查询
function doGetObjects(){
	var url="nav/queryNavList.do";
	var pageCurrent=$("#pageId").data("pageCurrent");
	var params={
			"pageCurrent":pageCurrent == null ? 0 : pageCurrent
	}
	$.post(url,params,function(result){
		if(result.state==1){
			// 设置表格
			showList(result.data.List)
			// 设置分页信息
			setPagination(result.data.Page)
		}else{
			alert(result.message)
		}
	})
}


// 设置表格信息
function showList(result){
	var tbody=$("#tbodyId");
	tbody.empty();
	for(var i in result){
		var id=result[i].nav_id
		var feight=result[i].nav_feight
		var name=result[i].nav_name
		var tr=$("<tr></tr>");
		tr.append('<td class="text-center"><input type="radio" name="box" value="'+id+'"></td>');
		tr.append("<td class='text-center'>"+name+"</td>");
		tr.append("<td class='text-center'>"+feight+"</td>");
		tr.append("<td class='text-center'><button type='button' class='btn-update' onclick='go2UpdatePage(this);' value='"+id+"'>修改</button></td>");
		tbody.append(tr);
	}
}

function go2UpdatePage(a){
	var id=$(a).val()
	$(".admin").data("id",id)
	var url="nav/editUI.do?t="+Math.random(1000);
	$("#win-box").css("display","block");
	$("#win-box").load(url);
	
}

function closeNavWindow(f){
	$("#win-box").css("display","none");
	if(f==1){
		location=location;
	}
}












/* 修改管理员信息 */
	function updateNav(btn){
		var tr=btn.parentNode.parentNode;
		var tds=tr.getElementsByTagName("input");
		var id=tds[0].value;
		updateNavWindow("admin/editNav.jsp?nav_id="+id);
	}
	function updateNavWindow(url){
		document.getElementById("win-box").style.display="block";
		document.getElementById("update-win").src=url;
	}
	function closeNavWindow(f){
		document.getElementById("win-box").style.display="none";
		if(f==1){
			location=location;
		}
	}
	/* 查看被选中的管理员 */
	function selectedRow(){
		var ms=document.getElementsByName("box");
		var obj=null;
		for(i=0;i<ms.length;i++){
			if(ms[i].checked){
				obj=ms[i];
				break;
			}
		}
		if(null==obj){
			alert("请选择要删除的新闻信息!");
			return;
		}
		return obj;
	}
	/* 删除被选中的管理员 */
	function onDeleteNav(){
		var objs = $("input[name='box']");
	  	var id="";
	  	objs.each(function(){
	  		if($(this)[0].checked == true){
	  			id=$(this).val()
	  		}
	  	})
	  	var url="nav/deleteNavById.do";
	  	$.post(url,{id:id},function(result){
	  		if(result.state==1){
	  			doGetObjects();
	  		}else{
	  			alert(result.message)
	  		}
	  	})
  	}