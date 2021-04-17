/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import convert.SharedLib;
import dao.RoomDAO;
import dto.RoomDTO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name = "SearchController", urlPatterns = {"/SearchController"})
public class SearchController extends HttpServlet {

    private static final String SEARCH = "search.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = SEARCH;
        try {
            double price = Double.parseDouble(request.getParameter("txtPrice"));
            Date checkin = SharedLib.convertStringToDate(request.getParameter("txtCheckIn"));
            Date checkout = SharedLib.convertStringToDate(request.getParameter("txtCheckOut"));
            int people = Integer.parseInt(request.getParameter("txtPeople"));
            RoomDAO dao = new RoomDAO();
            ArrayList<RoomDTO> listRoom = (ArrayList<RoomDTO>) dao.getListSearchRoom(SharedLib.converDateToString(checkin), SharedLib.converDateToString(checkout), price, people);
            HttpSession session = request.getSession();
            ArrayList<RoomDTO> listInCart = null;
            listInCart = (ArrayList<RoomDTO>) session.getAttribute("CART");
            if (listInCart != null) {
                for (int i = 0; i < listRoom.size(); i++) {
                    for (RoomDTO roomInCart : listInCart) {
                        if (listRoom.get(i).getRoomID() == roomInCart.getRoomID()) {
                            if (checkin.equals(roomInCart.getCheckin()) || checkout.equals(roomInCart.getCheckout()) || checkin.equals(roomInCart.getCheckout()) || checkout.equals(roomInCart.getCheckin())) {
                                listRoom.remove(i);
                            }
                        }
                    }
                }
            }
            session.setAttribute("LIST_SEARCH", listRoom);
        } catch (Exception e) {
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
