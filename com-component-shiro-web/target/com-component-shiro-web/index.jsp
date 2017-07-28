<html>
<body>
<%--<script>--%>
    <%--初次访问只有第一种有效--%>
    <%--alert("<%=request.getContextPath()%>"+"1")--%>
    <%--alert("${request.contextPath}"+"2")--%>
    <%--alert("${request.getContextPath()}"+"3")--%>
<%--</script>--%>
<script>
    window.location.href='<%=request.getContextPath() %>/${request.contextPath}index/welcome';
</script>
</body>
</html>
