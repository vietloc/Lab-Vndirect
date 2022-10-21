<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 10/10/2022
  Time: 2:41 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<tiles:insertDefinition name="template">
  <tiles:putAttribute name="body">
    <h1>User</h1>
    <p>Tài khoản: ${user.username}</p>
    <p>Mật khẩu: ${user.password}</p>
    <p>Email: ${user.email}</p>
    <p>Tuổi: ${user.age}</p>
<%--    <p>Nhóm: ${user.groupId}</p>--%>
    <p>Nhóm: ${user.group.name}</p>
  </tiles:putAttribute>
</tiles:insertDefinition>
