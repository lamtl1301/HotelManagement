package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import convert.SharedLib;
import dto.RoomDTO;
import java.util.ArrayList;
import dto.UserDTO;

public final class search_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"datepicker/css/bootstrap.min.css\" rel=\"stylesheet\" />\n");
      out.write("        <link href=\"datepicker/css/datepicker.css\" rel=\"stylesheet\" />\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <title>Search</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
            ArrayList< RoomDTO> listRoomSearch = (ArrayList<RoomDTO>) session.getAttribute("LIST_SEARCH");
            if (user == null) {
      out.write("\n");
      out.write("        <h1>Welcome to hotel</h1>\n");
      out.write("        <a href=\"login.html\"> Login</a>\n");
      out.write("        ");

        } else {
        
      out.write("\n");
      out.write("        <h1>Welcome ");
      out.print(user.getFullName());
      out.write(" to hotel</h1>\n");
      out.write("        <a href=\"MainController?btnAction=LogOut\"> Log out</a>\n");
      out.write("        ");
        } 
      out.write("\n");
      out.write("        <a href=\"view.jsp\"> View Cart</a>\n");
      out.write("        <div class=\"container\" style=\"padding-top:10px\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                ");

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
                
      out.write("\n");
      out.write("                <table class=\"table\">\n");
      out.write("                    <tr>\n");
      out.write("                    <form action=\"MainController\">\n");
      out.write("                        <td>\n");
      out.write("                            Price: <input name=\"txtPrice\" type=\"number\" step=\"10\" min=\"0\" value=\"");
      out.print(price);
      out.write("\"/>\n");
      out.write("                        </td>\n");
      out.write("                        <td>Check In:</td>\n");
      out.write("                        <td>\n");
      out.write("                            <input type=\"text\" name=\"txtCheckIn\" id=\"timeCheckIn\" required=\"required\" value=\"");
      out.print(checkin);
      out.write("\" />\n");
      out.write("                        </td>\n");
      out.write("                        <td>Check Out:</td>\n");
      out.write("                        <td>\n");
      out.write("                            <input type=\"text\" name=\"txtCheckOut\" id=\"timeCheckOut\" required=\"required\" value=\"");
      out.print(checkout);
      out.write("\" />\n");
      out.write("                        </td>\n");
      out.write("                        <td> People: <input type=\"number\" name=\"txtPeople\" min=\"1\" max=\"8\" step=\"1\" value=\"");
      out.print(people);
      out.write("\"></td><!--nguoi-->  \n");
      out.write("                        <td> <input type=\"submit\" value=\"Search\" name=\"btnAction\" /> </td>\n");
      out.write("                    </form>\n");
      out.write("                    </tr>\n");
      out.write("                </table>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        ");

            if (listRoomSearch != null) {
        
      out.write("\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th></th>\n");
      out.write("                    <th>Name</th>\n");
      out.write("                    <th>For</th>\n");
      out.write("                    <th>Price</th>\n");
      out.write("                    <th>Description</th>\n");
      out.write("                    <th></th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                <tr>\n");
      out.write("                    ");
    for (RoomDTO dto : listRoomSearch) {
      out.write("\n");
      out.write("\n");
      out.write("            <form action=\"MainController\">\n");
      out.write("                <td><img src=\"/Project/img/");
      out.print(dto.getImg());
      out.write("\" width=\"150\" height=\"150\"/></td>\n");
      out.write("                <td>");
      out.print(dto.getName());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(dto.getMax());
      out.write(" people</td>\n");
      out.write("                <td>");
      out.print(dto.getPrice());
      out.write("$</td>\n");
      out.write("                <td>");
      out.print(dto.getDescription());
      out.write("</td>\n");
      out.write("                <td><a href=\"MainController?btnAction=Booking&txtRoomID=");
      out.print(dto.getRoomID());
      out.write("&txtCheckIn=");
      out.print(checkin);
      out.write("&txtCheckOut=");
      out.print(checkout);
      out.write("\" />Booking\n");
      out.write("                </td>\n");
      out.write("                </tr>\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("            ");
 }
      out.write("\n");
      out.write("        </tbody>\n");
      out.write("    </table>\n");
      out.write("    ");

        }
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    <script src=\"datepicker/js/jquery.min.js\"></script>\n");
      out.write("    <script src=\"datepicker/js/bootstrap.min.js\"></script>\n");
      out.write("    <script src=\"datepicker/js/bootstrap-datepicker.js\"></script>\n");
      out.write("    <script>\n");
      out.write("        $(function () {\n");
      out.write("            'use strict';\n");
      out.write("            var nowTemp = new Date();\n");
      out.write("            var now = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), nowTemp.getDate(), 0, 0, 0, 0);\n");
      out.write("\n");
      out.write("            var checkin = $('#timeCheckIn').datepicker({\n");
      out.write("                onRender: function (date) {\n");
      out.write("                    return date.valueOf() < now.valueOf() ? 'disabled' : '';\n");
      out.write("                }\n");
      out.write("            }).on('changeDate', function (ev) {\n");
      out.write("                if (ev.date.valueOf() > checkout.date.valueOf()) {\n");
      out.write("                    var newDate = new Date(ev.date)\n");
      out.write("                    newDate.setDate(newDate.getDate() + 1);\n");
      out.write("                    checkout.setValue(newDate);\n");
      out.write("                }\n");
      out.write("                checkin.hide();\n");
      out.write("                $('#timeCheckOut')[0].focus();\n");
      out.write("            }).data('datepicker');\n");
      out.write("            var checkout = $('#timeCheckOut').datepicker({\n");
      out.write("                onRender: function (date) {\n");
      out.write("                    return date.valueOf() <= checkin.date.valueOf() ? 'disabled' : '';\n");
      out.write("                }\n");
      out.write("            }).on('changeDate', function (ev) {\n");
      out.write("                checkout.hide();\n");
      out.write("            }).data('datepicker');\n");
      out.write("        });\n");
      out.write("    </script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
