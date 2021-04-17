<%-- 
    Document   : create
    Created on : Oct 26, 2020, 10:55:40 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create a account</title>
    </head>
    <body>
        <h3>Create new account </h3>
        <form action="btnAction" method="POST">
            User ID:<input type="text" name="txtUserID" value="" />
            Full Name:<input type="text" name="txtFullName" value="" />
            Password:<input type="text" name="txtPassword" value="" />
            Confirm Password:<input type="text" name="txtConfirm" value="" />
            <input type="submit" value="Register" name="btnAction" />
            <input type="reset" value="Reset" />
        </form>
    </body>
</html>
