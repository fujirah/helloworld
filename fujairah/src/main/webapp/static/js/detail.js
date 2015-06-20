$(document).ready(function(){
	$(".pay_left").html(
			"<ul><li><a href='./feeDetail.html'>费用详情查询</a></li>"+
				"<li><a href='./feeDetailItem.html'>类目收费列表</a></li>"+
			"</ul>");
	$(".search-picker").change(function(){
		$(this).next().next().attr("placeholder",$(this).attr("name").split('@')[parseInt($(this).val())-1]);
	});
	pagination(1,1,100,STATICS().SHOW_SIZE,true);
});