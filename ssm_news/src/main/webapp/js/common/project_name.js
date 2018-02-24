function doSetProjects(idname){
	var url="nav/doQueryAllNavName.do";
	$.ajaxSettings.async = false;
	$.getJSON(url,function(result){
		if(result.state==1){
			doSetProject(idname,result.data);
		}else{
			alert(result.message);
		}
	})
}

function doSetProject(idname,data){
	var select=$(idname);
	select.append('<option value="">==请选择新闻类型==</option>');
	for(var i in data){
		select.append("<option value="+data[i].nav_id+">"+data[i].nav_name+"</option>");
	}
}