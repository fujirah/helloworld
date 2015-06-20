var tableI;
var tableI1;

$(document).ready(function(){

    var str = "";
    var str1 = "";
    tableI = "0,0,0,0,0,0,0,1,0," +
             "4,0,0,0,0,0,0,0,0," +
             "0,2,0,0,0,0,0,0,0," +
             "0,0,0,0,5,0,4,0,7," +
             "0,0,8,0,0,0,3,0,0," +
             "0,0,1,0,9,0,0,0,0," +
             "3,0,0,4,0,0,2,0,0," +
             "0,5,0,1,0,0,0,0,0," +
             "0,0,0,8,0,6,0,0,0,"
    tableI1 = "0,0,1,0,0,4,0,0,0," +
              "0,0,0,0,6,0,3,0,5," +
              "0,0,0,9,0,0,0,0,0," +
              "8,0,0,0,0,0,7,0,3," +
              "0,0,0,0,0,0,0,2,8," +
              "5,0,0,0,7,0,6,0,0," +
              "3,0,0,0,8,0,0,0,6," +
              "0,0,9,2,0,0,0,0,0," +
              "0,4,0,0,0,1,0,0,0,"
    var t = tableI.split(",")
    var t1 = tableI1.split(",")
    for(var i = 0;i < 81 ;i++){
        if(i % 9 == 0){
            str += '<tr>';
            str1 += '<tr>';
        }
        if(t[i] == 0){
            str += '<td>  </td>';
        }
        else{
            str += '<td bgcolor="yellow">'+t[i]+'</td>';
        }

        if(t1[i] == 0){
            str1 += '<td>  </td>';
        }
        else{
            str1 += '<td>'+t1[i]+'</td>';
        }


        if(i % 9 == 8){
            str += '</tr>';
            str1 += '</tr>';
        }
    }

    $("#inputT").html(str);
    $("#inputT1").html(str1);
    $("#submit1").on("click",function(){
        var param = {tableI:tableI};
        AjaxJson("../../handler/code/submit",param,function(data){
            show(data,"#outputT","#running");
        });
    });
    $("#submit2").on("click",function(){
        var param = {tableI:tableI1};
        AjaxJson("../../handler/code/submit",param,function(data){
            show(data,"#outputT1","#running1");
        });
    });
    $("#submitJZ").on("click",function(){
        var param = {tableI:tableI};
        AjaxJson("../../handler/code/submitJZ",param,function(data){
            show(data,"#outputT","#runningJZ");
        });
    });
    $("#submitJZ2").on("click",function(){
        var param = {tableI:tableI1};
        AjaxJson("../../handler/code/submitJZ",param,function(data){
            show(data,"#outputT1","#runningJZ1");
        });
    });
    $("#submitDancing").on("click",function(){
        var param = {tableI:tableI};
        AjaxJson("../../handler/code/submitDancing",param,function(data){
            show(data,"#outputT","#runningDC");
        });
    });
    $("#submitDancing2").on("click",function(){
        var param = {tableI:tableI1};
        AjaxJson("../../handler/code/submitDancing",param,function(data){
            show(data,"#outputT1","#runningDC2");
        });
    });


    $("#submitDancingCut").on("click",function(){
        var param = {tableI:tableI};
        AjaxJson("../../handler/code/submitDancingCut",param,function(data){
            show(data,"#outputT","#runningDCCut");
        });
    });
    $("#submitDancingCut2").on("click",function(){
        var param = {tableI:tableI1};
        AjaxJson("../../handler/code/submitDancingCut",param,function(data){
            show(data,"#outputT1","#runningDCCut2");
        });
    });

    function show(data,target,timing){
        var d = data.data.data;
        var str = "";
        if("fail" == d){
            alert("fail")
        }else{
            var t = d.split(",")
            for(var i = 0;i < 81 ;i++){
                if(i % 9 == 0){
                    str += '<tr>';
                }
                if(t[i] == 0){
                    str += '<td>  </td>';
                }
                else{
                    str += '<td>'+t[i]+'</td>';
                }
                if(i % 9 == 8){
                    str += '</tr>';
                }
            }
            $(target).html(str);
            $(timing).html("计算完毕,耗时"+data.data.time+"ms");
        }
    }


});
