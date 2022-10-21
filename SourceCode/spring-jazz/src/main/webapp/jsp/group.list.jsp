<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 09/10/2022
  Time: 3:55 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tiles:insertDefinition name="template">
    <tiles:putAttribute name="body">
        <h1>Group List</h1>
        <table style="width: 100%">
            <tr>
                <td>Name</td>
                <td>id</td>
                <td>#</td>
                <td>#</td>
            </tr>
            <tr>
                <td colspan="2">
                    <form method="get" action="/group/list">
                        <input type="text" name="q">
                    </form>
                </td>
            </tr>
            <c:forEach items="${groups}" var="item" varStatus="loop">
                <tr>
                    <td><a href="/account/list?group=${item.id}">${item.name}</a>
                        <ul>
                            <c:forEach items="${item.users}" var="user" varStatus="loop">
                                <li>${user.username} - ${user.age}</li>
                            </c:forEach>
                        </ul>
                    </td>
                    <td>${item.id}</td>
                    <td><a href="../group/delete/${item.id}">Delete</a></td>
                    <td><a href="../group/edit?id=${item.id}">Update</a></td>
                </tr>
            </c:forEach>
        </table>
    </tiles:putAttribute>
</tiles:insertDefinition>