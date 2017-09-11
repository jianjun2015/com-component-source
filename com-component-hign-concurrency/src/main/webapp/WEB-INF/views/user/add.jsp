<%--
  Created by IntelliJ IDEA.
  User: wangjianjun
  Date: 2017/7/7
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add</title>
    <%--request  xml中有配置--%>
    <form method="post" action="${request.contextPath}/user/add">
        userName:<input type="text" name="userName"><br>
        <input type="submit" value="提交">
    </form>
</head>
<body>

</body>
</html>
