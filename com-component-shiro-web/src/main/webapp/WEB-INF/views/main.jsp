<%--
  Created by IntelliJ IDEA.
  User: wangjianjun
  Date: 2017/7/21
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Title</title>

</head>
<body>

main.jsp
<shiro:hasAnyRoles name="superAdmin">
    <shiro:principal/>拥有角色superAdmin
</shiro:hasAnyRoles>
</body>
</html>
