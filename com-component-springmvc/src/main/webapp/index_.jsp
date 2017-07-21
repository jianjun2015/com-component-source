<%--
  Created by IntelliJ IDEA.
  User: wangjianjun
  Date: 2017/7/21
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--默认跳转--%>
<%--${request.contextPath}--%>
<script type="text/javascript">
    window.location.href='<%=request.getContextPath() %>/welcome.action';
</script>
</body>
</html>
