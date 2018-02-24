$(function(){
	doSetUpdatePage();
})

function doSetUpdatePage(){
	var url="manager/queryManagerById.do";
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
	$("#manager_id").val(data.manager_id)
	$("#manager_name").val(data.manager_name)
}

/* 验证所输入的信息是否都合法或规则 */
function validInput(id,msg,n){
	var val=$("#"+id).val();
	if(val="" || val.length<n){
		$("#err_"+id).html("<span class='err'>"+msg+"</span>");
		return false;
	}else{
		$("#err_"+id).html("<span class='success'>验证通过.</span>");
		return true;
	}
}
/* 调用相关方法处理是否符合提交要求 */
function startPost(){
	var ids=["manager_name"];
	var msg=["请输入登录姓名,至少2位"];
	var n=[2];
	var flag=true;
	for(i=0;i<n.length;i++){
		flag=validInput(ids[i],msg[i],n[i]) && flag;
	}
	if(flag){
		var url="manager/updateManager.do";
		var params={
				manager_id:$("#manager_id").val(),
				manager_name:$("#manager_name").val()
			}
	$.post(url,params,function(result){
			if(result.state==1){
				doback();
			}else{
				alert(result.message)
			}
		})
	}
}