<%--
  Created by IntelliJ IDEA.
  User: lhf
  Date: 2019/1/11
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>RFID在线设备</title>
    <script src="/js/jquery-1.4.2.min.js" type="application/javascript"></script>
</head>
<body>
        <div id="daca">
            <br/>
            总设备:<span id="wcdevicesize"></span><br/>
            已保洁:<span id="toiletcleansize"></span><br/>
            在线设备:<span id="wcdeviceonlinesize"></span><br/>
        </div>


        <br/>
        <div id="onlinedevice">
            <table >
                <tr>
                    <td>公厕名称</td>
                    <td>设备编号</td>
                    <td>状态</td>
                </tr>
            <tr>
                <td>test</td>
                <td>test</td>
                <td>test</td>
            </tr>
            </table>
        </div>
        <br/>
        <div id="cadalist">
            <table  cellspacing="50px">
                <tr>
                    <td>公厕名称</td>
                    <td>心跳时间</td>
                    <td>延迟ms</td>
                    <td>保洁开始时间</td>
                    <td>最后时间</td>
                    <td>延迟ms</td>
                </tr>
                <tr>
                    <td>test</td>
                    <td>test</td>
                    <td>test</td>
                    <td>test</td>
                    <td>test</td>
                    <td>test</td>
                </tr>
            </table>
        </div>

    <script type="application/javascript">
        $(function () {
            setInterval(pushpage,500);
           // pushpage();
        });

        function pushpage(){
            //统计
            getcada();
            //在线设备
            getonline();
            //详细列表
            getcadalist();

        }

        /**
         * 统计
         */
        function getcada(){

            $.ajax({
                type:"post",
                url:"/cada/toilet",
                success:function (data) {
                    console.log("统计:"+data);
                    $("#wcdevicesize").html(data.wctoiletsize);
                    $("#toiletcleansize").html(data.toiletcleansize);
                    $("#wcdeviceonlinesize").html(data.wcdeviceonlinesize);
                }
            });
        }
        /**
         *
         * 统计列表
         */
        function getcadalist(){

            $.ajax({
                type:"post",
                url:"/rfid/cadalist",
                success:function (data) {

                    console.log("列表:"+data);
                    var domstr='<table cellspacing="30px"  border="1">';
                        domstr+='<tr>';
                        domstr+='<td>公厕名称</td>';
                        domstr+='<td>心跳时间</td>';
                        domstr+='<td>延迟ms</td>';
                        domstr+='<td>保洁开始时间</td>';
                        domstr+='<td>最后时间</td>';
                        domstr+='<td>延迟ms</td>';
                        domstr+='</tr>';
                    if(data.length>0)
                    for(var i=0;i<data.length;i++){
                       var tname= data[i].wcToilet.tname;
                       var hearttime= data[i].wcDeviceHeart.params.timeStamp;
                       var heartdelay= data[i].heartdelay;

                       var cleantime=0;
                        var lasttime=0;
                       if(data[i].wcToiletClean!=null){
                           cleantime= data[i].wcToiletClean.starttime;
                           lasttime= data[i].wcToiletClean.params.timeStamp
                       }
                       var cleandelay= data[i].cleandelay;

                           domstr+='<tr>';
                           domstr+='<td>'+tname+'</td>';
                           domstr+='<td>'+hearttime+'</td>';
                           domstr+='<td>'+heartdelay+'</td>';
                           domstr+='<td>'+cleantime+'</td>';
                           domstr+='<td>'+lasttime+'</td>';
                           domstr+='<td>'+cleandelay+'</td>';
                           domstr+='</tr>';
                    }
                    domstr+='</table>';
                    console.log(domstr);
                    $("#cadalist").html(domstr);
                },
                error:function (e) {
                    console.log(e);
                }
            });
        }

        /**
         * 获取在线设备，一条一条的展示
         */
        function getonline(){
           // console.log("获取在线设备");
            $.ajax({
                type:"post",
                url:"/rfid/getOline",
                success:function (data) {
                    console.log("在线:"+data);

                    var domstr='<table >';
                    domstr+='<tr>';
                    domstr+='<td>公厕名称</td>';
                    domstr+='<td>设备编号</td>';
                    domstr+='<td>状态</td>';
                    domstr+='</tr>';
                    for(var i=0;i<data.length;i++){
                        var tname= data[i].tname;
                        var devno= data[i].devno;
                        domstr+='<tr>';
                        domstr+='<td>'+tname+'</td>';
                        domstr+='<td>'+devno+'</td>';
                        domstr+='<td>在线</td>';
                        domstr+='</tr>';
                    }
                    domstr+='</table>';
                   // console.log(domstr);
                    $("#onlinedevice").html(domstr);

                },
                error:function (e) {
                    console.log(e);
                }
            });
        }

    </script>
</body>
</html>
