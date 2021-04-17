<%-- 
    Document   : view
    Created on : Oct 27, 2020, 8:43:11 PM
    Author     : Admin
--%>

<%@page import="dto.UserDTO"%>
<%@page import="convert.SharedLib"%>
<%@page import="dto.RoomDTO"%>
<%@page import="dto.CartDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Orders</title>
    </head>
    <body>
        <% UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
            if (user == null) {
        %> <h1>Welcome</h1> 
        <%
        } else if (user.getRoleID().equals("US")) {
        %> <h1>Welcome <%=user.getFullName()%> </h1> <%
            }
        %>
        <h1>Your Booking Room</h1>

        <%
            CartDTO cart = (CartDTO) session.getAttribute("CART");
            if (cart != null ) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>NO</th>
                    <th>Image</th>
                    <th>For</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Checkin</th>
                    <th>Checkout</th>
                    <th>Total</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <%
                    String message = (String) request.getAttribute("ERROR_CHECKOUT");
                    if (message == null) {
                        message = "";
                    }
                    RoomDTO roomError = (RoomDTO) request.getAttribute("ERROR_ROOM");
                    if (roomError == null) {
                        roomError = new RoomDTO();
                    }
                    int no = 1;
                    double totalMoney = 0;
                    double total = 0;
                    for (RoomDTO dto : cart.getCart().values()) {
                        totalMoney = dto.getPrice() * SharedLib.numOfDays(dto.getCheckin(), dto.getCheckout());
                %>
            <form action="MainController">
                <tr>
                    <td> <%=no++%></td>
                    <td> <img src="/Project/img/<%=dto.getImg()%>" width="200" height="200"/> </td>
                    <td><%=dto.getMax()%> people</td>
                    <td><%=dto.getName()%></td>
                    <td><%=dto.getPrice()%> $</td>
                    <td><%=convert.SharedLib.converDateToString(dto.getCheckin())%> </td>
                    <td><%=convert.SharedLib.converDateToString(dto.getCheckout())%> </td>
                    <td><%=totalMoney%> $
                        <% total += totalMoney;%>
                    </td>
                    <td><input type="submit" value="Remove" name="btnAction" />
                        <input type="hidden" name="txtRoomID" value="<%=dto.getRoomID()%>" />
                    </td>
                    <% if (roomError.getRoomID() == dto.getRoomID()) {
                    %>   <td><%=message%></td><% } %>
                </tr>
            </form>
            <%
                }
            %>

        </tbody>
    </table>
    <h1> Total: <%=total%><input type="hidden" name="txtTotalMoney" value="<%=total%>" />
    </h1><a href="MainController?btnAction=Reserve&txtTotalMoney=<%=total%>">Reserve</a><br>
    <%
    } else {
    %> <h2>You did not book any room</h2><%
        }
    %>
    <a href="search.jsp">Add more room</a>
</body>
</html>
