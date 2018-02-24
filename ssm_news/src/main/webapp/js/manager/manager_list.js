$(function(){
	doGetObjects();
})

// 分页查询
function doGetObjects(){
	var url="manager/queryManagerList.do";
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
		var id=result[i].manager_id
		var name=result[i].manager_name
		var tr=$("<tr></tr>");
		tr.append('<td class="text-center"><input type="radio" name="box" value="'+id+'"></td>');
		tr.append("<td class='text-center'>"+((i++)+1)+"</td>");
		tr.append("<td class='text-center'>"+id+"</td>");
		tr.append("<td class='text-center'>"+name+"</td>");
		tr.append("<td class='text-center'><button type='button' class='btn-update' onclick='go2UpdatePage(this);' value='"+id+"'>修改</button></td>");
		tbody.append(tr);
	}
}


function go2UpdatePage(a){
	$(".admin").empty();
	var id=$(a).val()
	$(".admin").data("id",id)
	var url="manager/editUI.do?t="+Math.random(1000);
	$.ajaxSettings.async = false;
	$(".admin").load(url);
	
}




/* 删除被选中的管理员 */
function onDeleteManager(){
  	var objs = $("input[name='box']");
  	var id="";
  	objs.each(function(){
  		if($(this)[0].checked == true){
  			id=$(this).val()
  		}
  	})
  	var url="manager/deleteManagerById.do";
  	$.post(url,{id:id},function(result){
  		if(result.state==1){
  			doGetObjects();
  		}else{
  			alert(result.message)
  		}
  	})
 }