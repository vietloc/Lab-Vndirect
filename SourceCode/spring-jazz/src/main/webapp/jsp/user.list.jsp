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
        <script>
            window.fbAsyncInit = function() {
                FB.init({
                    appId      : '877587853404792',
                    xfbml      : true,
                    version    : 'v15.0'
                });
                FB.AppEvents.logPageView();
            };

            (function(d, s, id){
                var js, fjs = d.getElementsByTagName(s)[0];
                if (d.getElementById(id)) {return;}
                js = d.createElement(s); js.id = id;
                js.src = "https://connect.facebook.net/en_US/sdk.js";
                fjs.parentNode.insertBefore(js, fjs);
            }(document, 'script', 'facebook-jssdk'));
        </script>
        <h1>User List</h1>
        <table style="width: 100%" border="1">
            <tr>
                <td>Name</td>
                <td>GroupID</td>
                <td>Age</td>
                <td>Email</td>
            </tr>
<%--            <tr>--%>
<%--                <td colspan="2">--%>
<%--                    <form method="get" action="/account/list">--%>
<%--                        <input type="text" name="s">--%>
<%--                    </form>--%>
<%--                </td>--%>
<%--            </tr>--%>
            <c:forEach items="${users}" var="item" varStatus="loop">
                <tr>
                    <td><a href="/account/detail/${item.username}">{item.username}</a> </td>
                    <td>${item.groupId}</td>
                    <td>${item.age}</td>
                    <td>${item.email}</td>
                    <td><a href="../account/delete/${item.username}">Delete</a></td>
<%--                    <td><a href="../group/edit?id=${item.id}">Update</a></td>--%>
                </tr>
            </c:forEach>
            <h3>Average of Age is ${average}</h3>
        </table>
    </tiles:putAttribute>
</tiles:insertDefinition>