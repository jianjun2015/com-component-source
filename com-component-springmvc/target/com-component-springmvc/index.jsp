<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Hello World!</h2>
<%--${request.contextPath}--%>
<a href="<%=request.getContextPath()%>index/welcome">跳转index</a>
<form action="/index/welcome">
    <input type="submit" value="submit">
</form>
${request.contextPath}
<%=request.getContextPath() %>
</body>
</html>
