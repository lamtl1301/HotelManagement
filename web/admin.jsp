<%-- 
    Document   : admin.jsp
    Created on : Oct 24, 2020, 2:32:45 PM
    Author     : Admin
--%>

<%@page import="dto.UserDTO"%>
<%@page import="dto.TypeDTO"%>
<%@page import="java.util.List"%>
<%@page import="dao.RoomDAO"%>
<%@page import="dto.RoomDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrator</title>
    </head>
    <body>
        <%  UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
            if (user == null) {
                response.sendRedirect("login.html");
            } else if (user.getRoleID().equals("AD")) {
        %>
        <h1>Welcome <%=user.getFullName()%> </h1>
        <a href="MainController?btnAction=LogOut"> Log out</a><br>
        <div><a href="createroom.jsp">Create New Room</a> </div>
        <%
            List<RoomDTO> listRoom = (List<RoomDTO>) session.getAttribute("FULL_LIST_ROOM");
            List<TypeDTO> listType = (List<TypeDTO>) session.getAttribute("LIST_TYPE");
            if (listRoom != null) {
                int number = 1;
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>ID</th>
                    <th>Image</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Type Name</th>
                    <th>Max</th>
                    <th>Status</th>
                    <th>Rented</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (RoomDTO dto : listRoom) {
                        String typeName = "";
                        for (TypeDTO type : listType) {
                            if (dto.getTypeID().equals(type.getTypeID())) {
                                typeName = type.getTypeName();
                            }

                        }

                %><form action="MainController">
                <tr>
                    <td><%=number++%></td>
                    <td><input type="hidden" name="txtRoomID" value="<%=dto.getRoomID()%>" /><%=dto.getRoomID()%></td>
                    <td><img src="/Project/img/<%=dto.getImg()%>" width="200" height="200"/>
                    </td>

                    <td><%=dto.getDescription()%>
                    <td><%=dto.getPrice()%> $</td>
                    <td><%=typeName%></td>
                    <td><%=dto.getMax()%></td>
                    <td><input type="checkbox" name="cbxStatus" disabled="disabled"
                               <%
                                   if (dto.isStatus()) {
                               %> checked="checked" <% }%>
                               />
                    </td>
                    <td><input type="checkbox" name="cbxIsRented" disabled="disabled"
                               <%
                                   if (dto.isRented()) {
                               %> checked="checked" <% }%>
                               />
                    </td>
                    <td><input type="submit" value="Update" name="btnAction" /></td>
                    <td><input type="submit" value="Delete" name="btnAction" 
                               <%
                                   if (dto.isRented() || !dto.isStatus()) {
                               %> disabled="disabled" <% }%>
                               />
                    </td>
                </tr>
            </form>

            <%
                    }
                }
            %>
        </tbody>
    </table>
    <% } else {
            response.sendRedirect("notfound.html");
        }
    %>
</body>
</html>
