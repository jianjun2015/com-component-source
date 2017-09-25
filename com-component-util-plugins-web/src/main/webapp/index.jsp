<%--
  Created by IntelliJ IDEA.
  User: wangjianjun
  Date: 2017/8/4
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<input type="button" value="跳转" onclick="skipCalender()">

</body>
<script type="application/javascript">
    function skipCalender() {
        <jsp:forward page="WEB-INF/views/calendar.jsp"/>
    }
</script>
</html>
