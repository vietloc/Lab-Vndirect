<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 22/09/2022
  Time: 2:35 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP Example</title>
</head>
<body>
  <h1>Displaying sum</h1>
  <%
    int sum = 0;
    for (int i = 0;i < 25; i++){
        sum+=i;
    }
  %>
    <h2>Sum of number is <%=sum%></h2>

</body>
</html>
