<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 22/09/2022
  Time: 3:22 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP Example</title>
</head>
<body>
  <LI>The path of this JSP file is: <%= request.getRequestURI()%></LI>
  <LI>The Hostname is: <%= request.getRemoteHost()%></LI>
</body>
</html>
