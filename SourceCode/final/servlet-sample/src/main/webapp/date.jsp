<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 22/09/2022
  Time: 3:07 CH
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP Example</title>
</head>
<body>
    <% response.setHeader("Refresh", "6");%>
    <LI>Today's date is:<%= new Date()%></LI>
    <LI>Session Id: <%=session.getId()%></LI>
</body>
</html>
