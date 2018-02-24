$(function(){
	doSetUpdatePage();
})

function doSetUpdatePage(){
	var url="nav/queryNavById.do";
	var params={
			id:$(".admin").data("id")
	}
	$.post(url,params,function(result){
		if(result.state==1){
			setUpdatePage(result.data);
		}else{
			alert(result.message)
		}
	})
}

function setUpdatePage(data){
	$("#nav_feight").val(data.nav_feight)
	$("#nav_name").val(data.nav_name)
}








function startPost(){
	var nav_name=$("#nav_name").val();
	var nav_feight=$("#nav_feight").val();
	$("#err_nav_name").html("")
	$("#err_nav_feight").html("")
	if(nav_name==""){
		$("#err_nav_name").html("<span class='err'>请输入类别名称!</span>");
		return;
	}
	if(nav_feight==""){
		$("#err_nav_feight").html("<span class='err'>请输入类别排序权重,越小越靠前!</span>");
		return;
	}
	if(isNaN(nav_feight)){
		$("#err_nav_feight").html("<span class='err'>类别排序权重必须为整数!</span>");
		return;
	}
	var url="nav/updateNav.do";
	var params={
			nav_id:$(".admin").data("id"),
			nav_name:nav_name,
			nav_feight:nav_feight
	}
	$.post(url,params,function(result){
		if(result.state==1){
			doback()
		}else{
			alert(result.message)
		}
	})
}