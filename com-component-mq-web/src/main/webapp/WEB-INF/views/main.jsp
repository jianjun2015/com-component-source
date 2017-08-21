<%--
  Created by IntelliJ IDEA.
  User: wangjianjun
  Date: 2017/7/21
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>

<h2>Welcome!</h2>
<a href="<%=request.getContextPath()%>/producer">跳转发消息</a>
<a href="<%=request.getContextPath()%>/receive">队列取消息</a>

</body>
</html>
