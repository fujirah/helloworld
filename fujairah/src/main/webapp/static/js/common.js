$(document).ready(function(){
	//顶部菜单栏
	$("#topList").html("<div class='navbar-header'>"+
	    "<a class='navbar-brand' style='color:#fff'>FUJAIRAH-数据中心</a></div>"+
	  		"<div class='collapse navbar-collapse titlemain' id='bs-example-navbar-collapse-1'>"+
	    		"<ul class='nav navbar-nav'>"+
			      "<li><a class='record' href='./catcher.html'>Catcher</a></li>"+
			      "<li><a class='record' href='./feeDetail.html'>定位规则</a></li>"+
			      "<li><a class='record' href='./feeStatistics.html'>数据统计</a></li>"+
			      "<li><a class='record' href='./question.html'>答疑&维权</a></li></ul></div>");

	//顶部菜单字体颜色
	$(".record").css("color","#fff");

	//顶部菜单样式选择设置
	var location = $("#topList").attr("name");
	$(".record[href='./"+location+".html']").attr("isshow","true");
	$(".record[isshow='true']").css("border-bottom","6px solid #b10e00");
	$(".record[isshow='true']").parent().css("background-color","#d52717");

	//select框初始化
	if($(".selectpicker").length!=0){
		$('.selectpicker').selectpicker();
	}
	//启用时间选择控件
	if($(".datetimepicker").length!=0){
		$('.datetimepicker').datetimepicker();
	}

});

/**
*静态类
*/
function STATICS(){ 
var ocar = new Object; 
ocar.SHOW_SIZE = 4;
ocar.DEFAULT_SIZE =10;
return ocar; 
}

/**
*分页操作
*（1）页面上需要引入：<ul class="pagination"></ul>
*@pageOld 当前页数
*@pageNew 新页数
*@totalPage 总页数
*@showSizeSide 当前页数一侧显示的最多页数：例如：showSizeSide=2，page=5 那么显示结果为：3,4,5,6,7
*/
function pagination(pageOld,pageNew,totalPage,showSizeSide,getData){
	if(pageOld == parseInt(pageNew))
		return;
	pageNew = parseInt(pageNew);
	var totalPage = parseInt(totalPage);
	var showSize = parseInt(showSizeSide);
	var left = (pageNew-showSize <= 0)? 1:pageNew-showSize;
	var right = (pageNew+showSize>totalPage)?totalPage:pageNew+showSize;

	var str = "<li><a href='#' class='page' page='1'>首页</a><li><a href='#' class='pre'>&laquo;</a></li></li>"
	for(var i=left;i<=right;i++)
		str += "<li><a href='#' class='page' page='"+i+"'>"+i+"</a></li>";
	str += "<li><a href='#' class='next'>&raquo;</a></li><li><a href='#' class='page' page='"+totalPage+"'>末页</a></li>";
	str += "<li><a>共"+totalPage+"页</a><li>";
	$(".pagination").html(str);
	pageClickListener(pageNew,totalPage,showSizeSide,getData);
	$(".pagination li a[page='"+pageNew+"']").css("background-color","#EEEEEE");
}

/**
*页数变化监听
*/
function pageClickListener(pageNow,totalPage,showSizeSide,getData){
	$(".pagination li a").click(function(){
		var page;
	if($(this).hasClass("page")){
		page = $(this).attr("page");
		pagination(pageNow,page,totalPage,showSizeSide,getData);
        getData(page,showSizeSide);
	}
	if($(this).hasClass("pre")){
		if(pageNow-1<=0)
			return;
		pagination(pageNow,pageNow-1,totalPage,showSizeSide,getData);
        getData(page,showSizeSide);
	}else if($(this).hasClass("next")){
		if(pageNow+1>totalPage)
			return;
		pagination(pageNow,pageNow+1,totalPage,showSizeSide,getData);
        getData(page,showSizeSide);
	}});
}
//默认方法，展示5个
function paginationDefault(pageOld,pageNew,totalPage,getData){
    pagination(pageOld,pageNew,totalPage,5,getData);
}

function AjaxJson(url, param, success) {
    $.ajax({
        type : "post",
        contentType : "application/x-www-form-urlencoded;charset=UTF-8",
        url : url,
        async : false,
        data : param,
        dataType : 'json',
        success : success
    });
}

function AjaxJsonGet(url, param, success) {
    $.ajax({
        type : "get",
        contentType : "application/x-www-form-urlencoded;charset=UTF-8",
        url : url,
        async : false,
        data : param,
        dataType : 'json',
        success : success
    });
}
//定制菜单栏
function customTabe(tableClass,content){
    var con = "<tr>";
    for(var i=0;i<content.length;i++){
        con+="<th class=\"success\">"+content[i]+"</th>"
    }
    con+="</tr>";
    $(tableClass).html(con);
}

//去除未定义的标签 removeUndefine
function ruf(data){
    if(data==undefined){
        data="";
    }
    return data;
}

function Get(target){
    return $(target).val().trim();
}

//定制select
function dynamicSelect(data,target){
    var content = "";
    content += "<select class=\"selectpicker\" data-live-search=\"true\""+
    "data-style=\"btn-primary\" id=\"ruleId\">";
    for(var i=0;i<data.length;i++){
        content += "<option value="+data[i].value+">"+data[i].name+"</option>";
    }
    content += "</select>";
    $(target).html(content);
    if($(".selectpicker").length!=0){
        $('.selectpicker').selectpicker();
    }
}

//定制select for bind
function dynamicSelectCallback(data,target,callback){
    var content = "";
    content += "<select class=\"selectpicker\" style=\"display: none;\" data-live-search=\"true\""+
        "data-style=\"btn-primary\">";
    for(var i=0;i<data.length;i++){
        content += "<option value="+data[i].value+">"+data.name+"</option>";
    }
    content += "</select>";
    $(target).html(content);
    $(target+" select").change(callback());
    if($(".selectpicker").length!=0){
        $('.selectpicker').selectpicker();
    }
}