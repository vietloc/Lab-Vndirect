<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 23/09/2022
  Time: 9:52 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.io.*, java.util.*, java.sql.*" %>
<%@page import="javax.servlet.http.*, javax.servlet.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <sql:setDataSource var="user_db" driver="org.apache.derby.jdbc.EmbeddedDriver" url="jdbc:derby:C://java//servlet-sample//user_db" user="" password=""/>
    <sql:query dataSource="${user_db}" var="result"> SELECT * from hanoi_user</sql:query>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Password</th>
            <th>Email</th>
            <th>Action</th>
        </tr>
        <c:forEach var="row" items="${result.rows}">
            <tr>
                <td>${row.username}</td>
                <td><c:out value="${row.password}"/></td>
                <td>${row.email}</td>
                <td><a href="save?action=del&username=${row.username}">Del</a></td>
            </tr>
        </c:forEach>
    </table>
    <div><a href="register.html">Add new</a> </div>
</body>
</html>
