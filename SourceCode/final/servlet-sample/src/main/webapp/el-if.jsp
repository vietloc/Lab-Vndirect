<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 22/09/2022
  Time: 4:49 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>EL Example</h1>
    <c:if test="${param.person != null}">
        <c:out value="hello ${param.person}" escapeXml="true"/></c:if>
</body>
</html>
