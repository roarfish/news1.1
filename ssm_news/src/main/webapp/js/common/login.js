$(document).ready(function(){
	//回车按钮
	$(document).keyup(function(event) {
		if (event.keyCode == 13) {
			//触发btn-login绑定的submit事件
			$("#submit").trigger("click");
		}
	});
	//点击登录按钮
	$('#submit').click(doLogin);
})
function doLogin(){
	var userName = $('#manager_name').val();
	var userPwd = $('#manager_pwd').val();
	if(userName==''){
		$('#msg').text('用户名不能为空！');
		return false;
	}
	if(userPwd==''){
		$('#msg').text('密码不能为空！');
		return false;
	}
	//判断此用户是否存在于数据库中
	var url = 'login.do';
	var params = {'username':userName,'pwd':userPwd};
	$.post(url,params,function(result){
		console.log(result)
		if(result.state==1){  
			// 用户校验成功，跳转到主页面
			console.log("ok")
			location.href='indexUI.do';
		}else{
			$('#msg').text(result.message);
		}
	})
}