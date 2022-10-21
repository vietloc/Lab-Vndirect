<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring Jazz Application</title>
</head>
<body>
	<h1>Welcome to Spring Jazz </h1>
	<p><a href="/">Trang Chủ</a>
	<sec:authorize access="!hasAnyRole('ROLE_USER')">
		<a href="/login" style="margin-left: 30px">Login</a>
	</sec:authorize>
	<sec:authorize access="hasAnyRole('ROLE_USER')">
		<a href="/user" style="margin-left: 30px">Ca Nhan</a>
		<a href="javascript:document.getElementById('logout').submit();">Logout</a>
	</sec:authorize>
		<form action="/j_spring_security_logout" id="logout" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
	</p>
	<tiles:insertAttribute name="body" />
</body>
</html>