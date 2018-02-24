$(function(){
	var idname="#nav_id";
	doSetProjects(idname);
	doSetUpdatePage();
})


function doSetUpdatePage(){
	var data=$(".admin").data("article");
	$("#article_title").val(data.article_title)
	$("#article_date").val(data.article_date)
	$("#nav_id").val(data.nav_id)
}

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
	
	var url="article/updateArticle.do";
	var params={
			article_id:$(".admin").data("id"),
			article_date:$("#article_date").val(),
			article_title:$("#article_title").val(),
			nav_id:$("#nav_id").val(),
			article_content:$("#article_content").val()
		}
	console.log(params)
	$.post(url,params,function(result){
		if(result.state==1){
			doback()
		}else{
			alert(result.message)
		}
	})
}