/**
 * Created by LZP on 2018/3/25.
 */
var send_message_board = function () {
    var result = "null";
    var data = '{"name":"name","email":"0","content":"2018525"}';
    var x=$("#form_message").serializeArray();
    var t="{";
    $.each(x, function(i, field){
        t+="\""+field.name+"\":\""+field.value+"\"";
        if(x.length-1!=i){t+=',';}
    });
    t+="}";
    $.ajax({
        type:"POST",
        contentType : 'application/json',
        url :"/ajax",
        cache: false,
        async : false,
        dataType:"json",
        data : t,
        success:function(json){
            // alert(json['message_board_insert']);
        },
        error:function () {
            alert("留言失败");
        }
    });
    return result;
}


function getCurrentTime() {
    var format = "";
    //构造符合datetime-local格式的当前日期
    var nTime = new Date();
    format += nTime.getFullYear() + "-";
    format += (nTime.getMonth() + 1) < 10 ? "0" + (nTime.getMonth() + 1) : (nTime.getMonth() + 1);
    format += "-";
    format += nTime.getDate() < 10 ? "0" + (nTime.getDate()) : (nTime.getDate());
    format += "T";
    format += nTime.getHours() < 10 ? "0" + (nTime.getHours()) : (nTime.getHours());
    format += ":";
    format += nTime.getMinutes() < 10 ? "0" + (nTime.getMinutes()) : (nTime.getMinutes());
    format += ":";
    format += nTime.getSeconds() < 10 ? "0" + (nTime.getSeconds()) : (nTime.getSeconds());
    // format += ":49";
    return format;
}
