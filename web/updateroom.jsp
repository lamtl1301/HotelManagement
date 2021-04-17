<%-- 
    Document   : updateroom
    Created on : Nov 6, 2020, 4:44:35 PM
    Author     : Admin
--%>

<%@page import="dto.UserDTO"%>
<%@page import="java.util.List"%>
<%@page import="dto.RoomDTO"%>
<%@page import="dto.TypeDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Room</title>
    </head>
    <body>
        <%  UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
            if (user == null) {
                response.sendRedirect("login.html");
            } else if (user.getRoleID().equals("AD")) {
                RoomDTO dto = (RoomDTO) request.getAttribute("ROOM_INFO");
                if (dto == null) {
                    response.sendRedirect("admin.jsp");
                }
                List<TypeDTO> listType = (List<TypeDTO>) session.getAttribute("LIST_TYPE");
        %>
        <h3>Update Room</h3>
        <form action="MainController">
            Room ID: <input type="hidden" name="txtRoomID" value="<%=dto.getRoomID()%>" /><%=dto.getRoomID()%> <br>
            Name: <input type="text" name="txtName" value="<%=dto.getName()%>" required="" /> <br>
            Image: <input type="file" name="txtImg" value="<%=dto.getImg()%>" accept="image/*" /><br>
            Description: <input type="text" name="txtDescription" value="<%=dto.getDescription()%>" required="" /> <br>
            Price: <input type="number" step="10" min="10" name="txtPrice" value="<%=dto.getPrice()%>"required="" />$  <br>
            Type Room: <select name="cmbTypeName">
                <%  for (TypeDTO type : listType) {
                        if (dto.getTypeID().equals(type.getTypeID())) {
                %>
                <option value="<%=dto.getTypeID()%>"><%=type.getTypeName()%></option>
                <%      }
                    } %>
                <%  for (TypeDTO type : listType) {
                        if (!type.getTypeID().equals(dto.getTypeID())) {
                %>
                <option value="<%=type.getTypeID()%>"><%=type.getTypeName()%> </option>
                <%      }
                    }
                %>
            </select> <br>
            Max of people: <input type="number" name="txtMax" min="1" max="8" step="1" required="" value="<%=dto.getMax()%>" /> <br>
            Status <input type="checkbox" name="cbxStatus" 
                          <%
                              if (dto.isStatus()) {
                          %> checked="checked" disabled="disabled" />
            <% }%>  <br>
            <input type="submit" value="Update Room" name="btnAction" />
            <% } else {
                    response.sendRedirect("notfound.html");
                }
            %>
    </body>
</html>
