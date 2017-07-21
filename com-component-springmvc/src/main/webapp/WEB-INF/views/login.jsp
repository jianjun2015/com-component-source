<%--
  Created by IntelliJ IDEA.
  User: wangjianjun
  Date: 2017/7/21
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${request.getContextPath()}/login" method="post">
        姓名:<input type="text" name="userName">
        密码:<input type="password" name="passwd">
        <input type="submit" value="submit">
    </form>
</body>
</html>
