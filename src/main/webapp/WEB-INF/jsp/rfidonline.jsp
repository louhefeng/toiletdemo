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

    <script type="application/javascript">
        $(function () {
            setInterval(getonline,50);

        });
        /**
         * 获取在线设备，一条一条的展示
         */
        function getonline(){
            console.log("获取在线设备");
            $.ajax({
                type:"post",
                url:"/rfid/getOline",
                success:function (data) {
                    console.log(data);

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
                    console.log(domstr);
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
