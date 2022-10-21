<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 03/10/2022
  Time: 10:56 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="false" import="java.io.*" %>
<html>
<head>
    <title>Student Error</title>
</head>
<body>
    <%
        Exception exp = (Exception) request.getAttribute("javax.servlet.error.exception");
        exp.printStackTrace(new java.io.PrintWriter(OutputStream.nullOutputStream()));
    %>
</body>
</html>
