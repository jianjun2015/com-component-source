<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Hello World!</h2>
<%--<%=request.getContextPath() %>--%>
<%--${request.contextPath()}--%>
<a href="<%=request.getContextPath()%>/index/welcome">跳转index</a>
<a href="<%=request.getContextPath()%>/userInfo/addPage">添加</a>
<form action="<%=request.getContextPath()%>/index/welcome">
    <input type="submit" value="submit">
</form>
<form action="${request.contextPath()}/index/welcome">
    <input type="submit" value="submit">
</form>
</body>
</html>
