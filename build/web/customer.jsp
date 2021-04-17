<%-- 
    Document   : customer
    Created on : Oct 24, 2020, 2:32:10 PM
    Author     : Admin
--%>

<%@page import="dto.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
    </head>
    <body>
        <%  UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
            if (user == null) {
                response.sendRedirect("login.html");
            } else if (user.getRoleID().equals("US")) {
                String name = user.getFullName();
                if (name == null) {
                    name = "";
                }
        %>
        <h1>Welcome back <%=name%></h1>
        <h3>What do you want???</h3>
        <a href="search.jsp"> <button type="button">Home</button> </a> <br>
        <a href="view.jsp"> <button type="button">Your order</button> </a><br>
        <input type="submit" value="Logout" name="btnAction" />
        <% } else {
                response.sendRedirect("notfound.html");
            }
        %>
    </body>
</html>
