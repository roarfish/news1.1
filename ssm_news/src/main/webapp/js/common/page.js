$(function(){
	$("#pageId").on('click','.first,.pre,.next,.last',JumpToPage);
	$(".first,.pre").hide();
});

function setPagination(pageObject){
	var pageCount=pageObject.pageCount;
	var pageCurrent=pageObject.pageCurrent;
	$(".pageCount").html("总页数("+pageCount+")").data("pageCount",pageCount);
	if(pageCount==1){
		$(".first,.pre,.next,.last").hide();
	}else if(pageCount == pageCurrent + 1){
		$(".next,.last").hide();
		$(".first,.pre").show();
	}else if(pageCurrent == 0){
		$(".first,.pre").hide();
		$(".next,.last").show() ;
	}
	$(".pageCurrent").html("当前页("+(pageCurrent+1)+")").data("pageCurrent",pageCurrent);
	$(".rowCount").html("共"+pageObject.rowCount+"条记录");
	$("#select").empty();
	for(j=1;j<=pageCount;j++){
		$("#select").append("<option "+(j==(pageCurrent+1)?"selected='selected'":"")+">"+j+"</option>");
	}
}

function JumpToPage(){
	var clazz=$(this).attr("class");
	$("#pageId").removeData();
	var pageCount=$(".pageCount").data("pageCount");
	var pageCurrent=$(".pageCurrent").data("pageCurrent");
	if(clazz=="first"){
		$("#pageId").data("pageCurrent",0);
		$(".first,.pre").hide();
		$(".next,.last").show() ;
	}
	if(clazz=="last"){
		$("#pageId").data("pageCurrent",pageCount-1);
		$(".next,.last").hide();
		$(".first,.pre").show();
	}
	if(clazz=="pre"){
		$("#pageId").data("pageCurrent",--pageCurrent);
		pageCurrent<=0?$(".first,.pre").hide():"";
		$(".next,.last").show() ;
	}
	if(clazz=="next"){
		$("#pageId").data("pageCurrent",++pageCurrent);
		pageCurrent+1>=pageCount?$(".next,.last").hide():"";
		$(".first,.pre").show();
	}
	doGetObjects();
}

function go2page(val){
	$("#pageId").removeData().data("pageCurrent",val-1);
	doGetObjects();
}
