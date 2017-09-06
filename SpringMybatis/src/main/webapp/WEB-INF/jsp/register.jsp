<%--
 Created by demos on 2017/9/6.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/userAction/reg" method="post" accept-charset="UTF-8">
    <label for="loginId">用户名：</label>
    <input type="text" id="loginId" name="loginId"> <br>
    <label for="name">姓名：</label>
    <input type="text" id="name" name="name"> <br>
    <label for="password">密码：</label>
    <input type="password" id="password" name="pwd"> <br>
    <label for="password1">确认密码：</label>
    <input type="password" id="password1" name=""> <br>
    <label for="phone">手机号：</label>
    <input type="text" id="phone" name="cellNumber"> <br>
    <label for="sex">性别：</label>
    <input type="text" name="sex" id="sex"> <br>
    <label for="age">年龄：</label>
    <input type="text" name="age" id="age"> <br>
    <input type="submit" value="提交">
</form>
</body>
</html>
