<%-- 
    Document   : createroom
    Created on : Nov 8, 2020, 1:56:16 AM
    Author     : Admin
--%>

<%@page import="java.util.List"%>
<%@page import="dto.UserDTO"%>
<%@page import="dto.TypeDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Room Page</title>
    </head>
    <body>
        <%  UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
            if (user == null) {
                response.sendRedirect("login.html");
            } else if (user.getRoleID().equals("AD")) {
                String error = (String) request.getAttribute("ERROR_ROOM");
                if (error == null){
                    error ="";
                }
                List<TypeDTO> listType = (List<TypeDTO>) session.getAttribute("LIST_TYPE");
        %>
        <h3>Create Room</h3>
        <form action="MainController">
            Name: <input type="text" name="txtName" value="" required="" /> <br>
            Image: <input type="file" name="txtImg" value="" accept="image/*" /> <%=error%><br>
            Description: <input type="text" name="txtDescription" value="" required="" /> <br>
            Price: <input type="number" step="10" min="10" name="txtPrice" value=""required="" />$  <br>
            Type Room: <select name="cmbTypeName">
                <%  for (TypeDTO type : listType) {
                %>
                <option value="<%=type.getTypeID()%>"><%=type.getTypeName()%> </option>
                <%
                    }
                %>
            </select> <br>
            Max of people: <input type="number" name="txtMax" min="1" max="8" step="1" required="" value="" /> <br>
            <input type="submit" value="Create Room" name="btnAction" />
        </form>
            <% } else {
                    response.sendRedirect("notfound.html");
                }
            %>
    </body>
</html>
