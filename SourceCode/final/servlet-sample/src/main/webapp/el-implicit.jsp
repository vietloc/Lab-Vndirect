<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 22/09/2022
  Time: 5:04 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %>


<html>
<head>
    <title>Title</title>
</head>
<body>
  <c:forEach var="reqHeader" items="${header}">${reqHeader.key} = ${reqHeader.value} <br/></c:forEach>
    request value - length = ${fn:length(reqHeader.value)} <br/>
</body>
</html>
