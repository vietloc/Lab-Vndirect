<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 29/09/2022
  Time: 9:55 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Add New Student</title>
</head>
<body>
  <h2>Please Input Student Information</h2>
<form:form method="post" action="save">
  <form:hidden path="id"/>
  <table>
    <tr>
      <td>Name: </td>
<%--      <td><form:input path="name"/></td>--%>
      <td><form:input path="name"/><form:errors path="name"/></td>
    </tr>
    <tr>
      <td>Age: </td>
<%--      <td><form:input path="age" type="number"/>--%>
      <td><form:input path="age" type="number"/><form:errors path="age"/></td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="Submit"/>
      </td>
    </tr>
  </table>
</form:form>

<%--  <form method="post" action="save">--%>
<%--    <table>--%>
<%--      <tr>--%>
<%--        <td>Name: </td>--%>
<%--        <td><input name="name" type="text"/></td>--%>
<%--      </tr>--%>
<%--      <tr>--%>
<%--        <td>Age: </td>--%>
<%--        <td><input name="age" type="number"/></td>--%>
<%--      </tr>--%>
<%--      <tr>--%>
<%--        <td colspan="2">--%>
<%--          <input type="submit" value="Submit"/>--%>
<%--        </td>--%>
<%--      </tr>--%>
<%--    </table>--%>
<%--  </form>--%>
</body>
</html>
