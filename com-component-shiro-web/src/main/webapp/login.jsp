<%--
  Created by IntelliJ IDEA.
  User: wangjianjun
  Date: 2017/7/26
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <style>.error{color:red;}</style>
</head>
<body>

<div class="error">${error}</div>
<body>
<%--<%=request.getContextPath()%>--%>
<%--${request.contextPath}/user/login--%>
    <form action="" method="post">
        用户名：<input type="text" name="userName"><br/>
        密码：<input type="password" name="password"><br/>
        <input type="submit" value="登录">
    </form>
</body>
</html>
