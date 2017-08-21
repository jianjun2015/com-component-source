<%--
  Created by IntelliJ IDEA.
  User: wangjianjun
  Date: 2017/8/21
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>JMS-Producer!!!</h1>
<form action="onsend" method="post">

    MessageText:<textarea name="message">${time }</textarea>

    <input type="submit" value="提交" />
</form>
<h2><a href="<%=request.getContextPath()%>/index/welcome">返回主页</a></h2>
</body>
</html>
