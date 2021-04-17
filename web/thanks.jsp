<%-- 
    Document   : thanks
    Created on : Nov 8, 2020, 5:47:38 PM
    Author     : Admin
--%>

<%@page import="dto.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thanks for Booking</title>
    </head>
    <body>
        <% UserDTO user =(UserDTO)session.getAttribute("LOGIN_USER");
           
        %>
        <h1>Thanks for booking <%=user.getFullName()%></h1>
        <a href="search.jsp">Home</a>
    </body>
</html>
