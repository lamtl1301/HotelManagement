<%-- 
    Document   : search
    Created on : Oct 26, 2020, 10:46:33 PM
    Author     : Admin
--%>

<%@page import="convert.SharedLib"%>
<%@page import="dto.RoomDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="datepicker/css/bootstrap.min.css" rel="stylesheet" />
        <link href="datepicker/css/datepicker.css" rel="stylesheet" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Search</title>
    </head>
    <body>
        <%
            UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
            ArrayList< RoomDTO> listRoomSearch = (ArrayList<RoomDTO>) session.getAttribute("LIST_SEARCH");
            if (user == null) {%>
        <h1>Welcome to hotel</h1>
        <a href="MainController?btnAction=Login"> Login</a>
        <%
        } else {
        %>
        <h1>Welcome <%=user.getFullName()%> to hotel</h1>
        <a href="MainController?btnAction=LogOut"> Log out</a>
        <%        } %>
        <a href="view.jsp"> View Cart</a>
        <div class="container" style="padding-top:10px">
            <div class="row">
                <%
                    String price = request.getParameter("txtPrice");
                    String checkin = request.getParameter("txtCheckIn");
                    String checkout = request.getParameter("txtCheckOut");
                    String people = request.getParameter("txtPeople");
                    if (price == null) {
                        price = "50";
                    } else {
                        price = price;
                    }
                    if (checkin == null) {
                        checkin = SharedLib.currentDay();
                    }else {
                        checkin = checkin;
                    }
                    if (checkout == null) {
                        checkout = SharedLib.nextDay();
                    }else {
                        checkout = checkout;
                    }
                    if (people == null) {
                        people = "1";
                    }else {
                        people = people;
                    }
                %>
                <table class="table">
                    <tr>
                    <form action="MainController">
                        <td>
                            Price: <input name="txtPrice" type="number" step="10" min="0" value="<%=price%>"/>
                        </td>
                        <td>Check In:</td>
                        <td>
                            <input type="text" name="txtCheckIn" id="timeCheckIn" required="required" value="<%=checkin%>" />
                        </td>
                        <td>Check Out:</td>
                        <td>
                            <input type="text" name="txtCheckOut" id="timeCheckOut" required="required" value="<%=checkout%>" />
                        </td>
                        <td> People: <input type="number" name="txtPeople" min="1" max="8" step="1" value="<%=people%>"></td><!--nguoi-->  
                        <td> <input type="submit" value="Search" name="btnAction" /> </td>
                    </form>
                    </tr>
                </table>

            </div>
        </div>
        <%
            if (listRoomSearch != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th></th>
                    <th>Name</th>
                    <th>For</th>
                    <th>Price</th>
                    <th>Description</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <%    for (RoomDTO dto : listRoomSearch) {%>

            <form action="MainController">
                <td><img src="/Project/img/<%=dto.getImg()%>" width="150" height="150"/></td>
                <td><%=dto.getName()%></td>
                <td><%=dto.getMax()%> people</td>
                <td><%=dto.getPrice()%>$</td>
                <td><%=dto.getDescription()%></td>
                <td><a href="MainController?btnAction=Booking&txtRoomID=<%=dto.getRoomID()%>&txtCheckIn=<%=checkin%>&txtCheckOut=<%=checkout%>" />Booking
                </td>
                </tr>
            </form>

            <% }%>
        </tbody>
    </table>
    <%
        }%>


    <script src="datepicker/js/jquery.min.js"></script>
    <script src="datepicker/js/bootstrap.min.js"></script>
    <script src="datepicker/js/bootstrap-datepicker.js"></script>
    <script>
        $(function () {
            'use strict';
            var nowTemp = new Date();
            var now = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), nowTemp.getDate(), 0, 0, 0, 0);

            var checkin = $('#timeCheckIn').datepicker({
                onRender: function (date) {
                    return date.valueOf() < now.valueOf() ? 'disabled' : '';
                }
            }).on('changeDate', function (ev) {
                if (ev.date.valueOf() > checkout.date.valueOf()) {
                    var newDate = new Date(ev.date)
                    newDate.setDate(newDate.getDate() + 1);
                    checkout.setValue(newDate);
                }
                checkin.hide();
                $('#timeCheckOut')[0].focus();
            }).data('datepicker');
            var checkout = $('#timeCheckOut').datepicker({
                onRender: function (date) {
                    return date.valueOf() <= checkin.date.valueOf() ? 'disabled' : '';
                }
            }).on('changeDate', function (ev) {
                checkout.hide();
            }).data('datepicker');
        });
    </script>
</body>
</html>
