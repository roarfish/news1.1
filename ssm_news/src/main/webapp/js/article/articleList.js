$(function(){
	$("#search").click(doSearch);
	doGetObjects();
	var idname="#nav_id";
	doSetProjects(idname)
})

// 分页查询
function doGetObjects(){
	var url="article/queryArticleList.do";
	var pageCurrent=$("#pageId").data("pageCurrent");
	var params={
			"pageCurrent":pageCurrent == null ? 0 : pageCurrent,
			"nav_id":$("#nav_id").val(),
			"article_title":$("#article_title").val()
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
		var id=result[i].article_id
		var articleName=result[i].article_title
		var navName=result[i].nav_name
		var date=result[i].article_date
		var tr=$("<tr></tr>");
		tr.append('<td class="text-center"><input type="radio" name="box" value="'+id+'"></td>');
		tr.append("<td class='text-center'>"+((i++)+1)+"</td>");
		tr.append("<td class='text-center'>"+articleName+"</td>");
		tr.append("<td class='text-center'>"+navName+"</td>");
		tr.append("<td class='text-center'>"+date+"</td>");
		tbody.append(tr);
	}
}

function deleteNews(){
	var objs = $("input[name='box']");
  	var id="";
  	objs.each(function(){
  		if($(this)[0].checked == true){
  			id=$(this).val()
  		}
  	})
  	var url="article/deleteArticleById.do";
  	$.post(url,{id:id},function(result){
  		if(result.state==1){
  			doGetObjects();
  		}else{
  			alert(result.message)
  		}
  	})
}

function doSearch(){
	$("#pageCurrent").data("pageCurrent",0);
	doGetObjects();
}









$("#addA").click(function(){
	$(".admin").empty();
	var url="article/addUI.do?t="+Math.random(1000);
	$(".admin").load(url,function(){
			var editor1 = KindEditor.create('textarea[name="content1"]', {
				cssPath : "kindeditor/plugins/code/prettify.css",
				uploadJson : 'kindeditor/jsp/upload_json.jsp',
				fileManagerJson : 'kindeditor/jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterBlur:function(){ 
		            this.sync(); 
		        },
				afterCreate : function() {
					var self = this;
					KindEditor.ctrl(document, 13, function() {
						self.sync();
						document.forms['frm'].submit();
					});
					KindEditor.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['frm'].submit();
					});
				}
			});
			prettyPrint();
	});
})

$("#updateA").click(function(){
	$(".admin").removeData();
	var objs = $("input[name='box']");
  	var id="";
  	objs.each(function(){
  		if($(this)[0].checked == true){
  			id=$(this).val()
  		}
  	})
  	$(".admin").data("id",id);
  	var url="article/queryArticleById.do";
	$.ajaxSettings.async = false;
  	$.post(url,{id:id},function(result){
  		if(result.state==1){
  			$(".admin").data("article",result.data);
  		}else{
  			alert(result.message)
  		}
  	})
	$(".admin").empty();
	var url="article/editUI.do?t="+Math.random(1000)+"&id="+id;
	$(".admin").load(url,function(){
			var editor1 = KindEditor.create('textarea[name="content1"]', {
				cssPath : "kindeditor/plugins/code/prettify.css",
				uploadJson : 'kindeditor/jsp/upload_json.jsp',
				fileManagerJson : 'kindeditor/jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterBlur:function(){ 
		            this.sync(); 
		        },
				afterCreate : function() {
					var self = this;
					KindEditor.ctrl(document, 13, function() {
						self.sync();
						document.forms['frm'].submit();
					});
					
					KindEditor.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['frm'].submit();
					});
				}
			});
			prettyPrint();
	});
})