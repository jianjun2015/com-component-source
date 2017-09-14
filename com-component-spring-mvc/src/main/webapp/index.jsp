<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<<<<<<< HEAD

<html>
<body>
<h2>Hello World!</h2>
<a href="<%=request.getContextPath()%>/index/welcome">跳转index</a>
1:${request.contextPath}
2:<%=request.getContextPath() %>
=======
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Hello World!</h2>
<%--<%=request.getContextPath() %>--%>
<%--${request.contextPath()}--%>
<a href="<%=request.getContextPath()%>/index/welcome">跳转index</a>
<form action="<%=request.getContextPath()%>/index/welcome">
    <input type="submit" value="submit">
</form>
<form action="${request.contextPath()}/index/welcome">
    <input type="submit" value="submit">
</form>

>>>>>>> origin/jdk_1.8
</body>
</html>
