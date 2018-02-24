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
/* 验证两次输入的密码是否一致 */
function validPwd(){
	if($("#manager_pwd").val()!=$("#re_manager_pwd").val()){
		$("#err_re_manager_pwd").html("<span class='err'>两次输入的密码不一致.</span>");
		return false;
	}
		return true;
}
/* 调用相关方法处理是否符合提交要求 */
function startPost(){
	var ids=["manager_id","manager_name","manager_pwd","re_manager_pwd"];
	var msg=["请输入登录账号,至少3位","请输入登录姓名,至少2位","请输入登录密码,至少8位","确认密码与登录密码不一致!"];
	var n=[3,2,8,8];
	var flag=true;
	var url="manager/addManager.do";
	for(i=0;i<4;i++){
		flag=validInput(ids[i],msg[i],n[i]) && flag;
	}
	flag=validPwd() && flag;
	if(flag){
		var params={
				manager_id:$("#manager_id").val(),
				manager_name:$("#manager_name").val(),
				manager_pwd:$("#manager_pwd").val()
			}
		$.post(url,params,function(result){
			if(result.state==1){
				doback()
			}else{
				alert(result.message)
			}
		})
	}
}