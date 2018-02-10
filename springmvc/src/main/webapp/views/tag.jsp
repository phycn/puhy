<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- 使用spring标签 -->
<html>
<head>
    <title>spring标签</title>
</head>
<body>
<form:form modelAttribute="user">
    用户名：<form:input path="userName"/>
    密码：<form:password path="password"/>
    <input type="submit" value="登录" name="testSubmit"/>
    <input type="reset" value="重置"/>
</form:form>
</body>
</html>