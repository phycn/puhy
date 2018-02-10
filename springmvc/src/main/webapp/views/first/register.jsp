<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>蒲红宇springmvc学习</title>
</head>
<body>
${id}
<form method="get" action="<c:url value="/first/login"/>">
    <table>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="userName" value="${userName}"/></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password" value="${password}"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" name="提交"/></td>
        </tr>
    </table>
</form>
</body>
</html>