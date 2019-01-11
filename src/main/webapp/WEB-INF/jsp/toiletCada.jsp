<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/10
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>公厕统计页面</title>
    <script src="/js/jquery-1.4.2.min.js" type="application/javascript"></script>
</head>
<body>
    hello guy!
    <br/>
    总保洁:${toiletsize}<br/>
    已保洁:${toiletcleansize}<br/>
    保洁率:<br/>
    <hr/>
    总设备:${wcdevicesize}<br/>
    在线设备:${wcdeviceonlinesize}<br/>
    在线比例:<br/>

    <script>setTimeout("location=location; ", 50); </script>
</body>
</html>
