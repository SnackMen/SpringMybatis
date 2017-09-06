<%--
 Created by demos on 2017/9/6.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录页面</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/userAction/login" method="post" accept-charset="UTF-8">
    账号：<label>
    <input type="text"/>
</label>
    密码：<label>
    <input type="password"/>
</label>
    <input type="submit" value="提交" />
</form>
</body>
</html>
