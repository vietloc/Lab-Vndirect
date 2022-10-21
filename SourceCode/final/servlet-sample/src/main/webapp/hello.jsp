<%@page isELIgnored="false" %>
<html>
    <head>
        <title>Welcome to our Website</title>
    </head>
    <body>
        <marquee>
<%--            <font size="3" color="#FF0033">Hello World<%=request.getParameter("j_username")%></font>--%>
                <font size="3" color="#FF0033">Hello World${param["j_username"]}!!</font>
                <h1>${say}</h1>
        </marquee>
        <font color="red"> Hostname: <%= request.getRemoteHost() %><br>
        <font color="red"> Session Id:<%= session.getId() %>
        <% %>
    </body>
</html>