$(function(){
	$(".back-btn").click(doback)
})

function doback(){
	$(".admin").empty();
	var url="article/listUI.do?t="+Math.random(1000);
	$(".admin").load(url);
}