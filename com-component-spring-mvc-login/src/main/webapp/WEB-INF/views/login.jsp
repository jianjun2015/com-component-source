<%--
  Created by IntelliJ IDEA.
  User: wangjianjun
  Date: 2017/9/19
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <meta charset="utf-8">
    <link href="${request.contextPath}/css/style.css" rel='stylesheet' type='text/css' />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
</head>
<body>
<div class="main">
    <div class="login-form">
        <h1>Member Login</h1>
        <div class="head">
            <img src="${request.contextPath}/images/user.png" alt=""/>
        </div>
        <form action="${request.contextPath}/index/login" method="post">
            <label style="color: red">${loginMsg}</label>
            <input name="username" type="text" class="text" value="USERNAME" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'USERNAME';}" >
            <input name="password" type="password" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}">
            <div class="submit">
                <input type="submit" value="LOGIN" >
            </div>
        </form>
    </div>
</div>
</body>
</html>
