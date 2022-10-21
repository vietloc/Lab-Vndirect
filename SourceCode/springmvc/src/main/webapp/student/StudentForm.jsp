<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 03/10/2022
  Time: 10:18 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
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
<c:if test="${id != null}">
    <h1>Please upload a image</h1>
    <form method="post" action="../avatar/save" enctype="multipart/form-data">
        <input type="hidden" name="id" value="${id}" />
        <input type="file" name="file" />
        <input type="submit" value="Upload" />
    </form>
</c:if>
</body>
</html>
