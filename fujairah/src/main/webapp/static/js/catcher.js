$(document).ready(function(){
    AjaxJson("../../handler/rule/listAll",{},function(data){
        dynamicSelect(adaptSelect(data.data.result),".select-fujairah");
    });

    $("#submit").click(dig);
});
function dig(){
    var link = $("#link").val();
    var ruleId = $("#ruleId").val();
    var deep = $("#deep").val();
    var location = $("#location").val();

    var data={
        link:link,
        ruleId:ruleId,
        deep:deep,
        location:location
    }
    console.log(link+" "+ruleId+" "+" "+deep+" "+location);
    AjaxJson("../../handler/catcher/catch",data,function(data){
//        console.log(data);
        console.log("finish");
    });

}

function adaptSelect(data){
    var arrayObj = new Array();
    for(var i=0;i<data.length;i++){
        var temp = {
            name:data[i].name,
            value:data[i].id
        };
        arrayObj.push(temp);
    }
    return arrayObj;
}