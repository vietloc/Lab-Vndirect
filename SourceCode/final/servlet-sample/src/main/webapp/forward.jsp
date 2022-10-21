<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 22/09/2022
  Time: 3:27 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP Example</title>
</head>
<body>
  <%
    String agent = request.getHeader("User-Agent");
  %>

<% if(agent.indexOf("Firefox")>-1){ %>
  <jsp:forward page="path.jsp"/>
<%} else{%>
  <jsp:forward page="include.jsp"/>
<%}%>
</body>
</html>
