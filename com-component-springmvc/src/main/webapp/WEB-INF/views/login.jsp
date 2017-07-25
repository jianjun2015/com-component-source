<%--
  Created by IntelliJ IDEA.
  User: wangjianjun
  Date: 2017/7/21
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="${request.getContextPath()}/srcipt/RSA.js"></script>
<script src="${request.getContextPath()}/srcipt/BigInt.js"></script>
<script src="${request.getContextPath()}/srcipt/Barrett.js"></script>
<script type="application/javascript">
    function rsalogin()
    {
        bodyRSA();
        var result = encryptedString(key, document.getElementById("pwd").value);
//        alert(result);
        document.getElementById("pwd").value = result;
//        loginForm.action="login.do?result="+result;
//        loginForm.submit();
    }
    var key ;
    function bodyRSA()
    {
        setMaxDigits(130);
        key = new RSAKeyPair("10001","","924fba1eb742abb576562cd6dd2d4eda85d9c844bdabe6c775a191792abb3f9c6b99e6abc36598573010bb58311a03cbf12dd48af66f7d79e4ee03c545ed180273e0c60a169039b8c5b416e67dae7c3eea174c3c2a9c65df9856fb9ffc7f02de28b117d2e6d1c6df8570f54f69e63c39537e86311b049c682e352047e8e26717");

    }
</script>
<body>
    <form action="${request.getContextPath()}/login" method="post">
        姓名:<input type="text" name="userName">
        密码:<input id="pwd" type="password" name="passwd" onblur="rsalogin()">
        <input type="submit" value="submit">
    </form>
</body>
</html>
