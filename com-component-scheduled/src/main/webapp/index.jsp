<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>
<h2>Hello World!</h2>
<a href="<%=request.getContextPath()%>/index/welcome">跳转index</a>
1:${request.contextPath}
2:<%=request.getContextPath() %>
3:<p><a href="<%= request.getContextPath() %>/ongoing">Ongoing task list</a></p>
</body>
</html>
