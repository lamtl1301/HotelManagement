/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import convert.SharedLib;
import dao.RoomDAO;
import dto.CartDTO;
import dto.RoomDTO;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "BookingController", urlPatterns = {"/BookingController"})
public class BookingController extends HttpServlet {

    private static final String ERROR = "notfound.html";
    private static final String SUCCESS = "search.jsp";

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
        String url = ERROR;
        try {
            Date checkin = SharedLib.convertStringToDate(request.getParameter("txtCheckIn"));
            Date checkout = SharedLib.convertStringToDate(request.getParameter("txtCheckOut"));
            RoomDAO dao = new RoomDAO();
            int roomID = Integer.parseInt(request.getParameter("txtRoomID"));
            RoomDTO room = dao.getInfoRoom(roomID);
            room.setCheckin(checkin);
            room.setCheckout(checkout);
            HttpSession session = request.getSession();
            CartDTO cart = (CartDTO) session.getAttribute("CART");
            if (cart == null) {
                cart = new CartDTO(null);
            }
            cart.add(room);
            session.setAttribute("CART", cart);
            ArrayList<RoomDTO> listRoom = (ArrayList<RoomDTO>) session.getAttribute("LIST_SEARCH");
            ArrayList<RoomDTO> listInCart = new ArrayList<>();
            for (RoomDTO value : cart.getCart().values()) {
                listInCart.add(value);
            }
            if (listInCart.size() >0) {
                for (int i = 0; i < listRoom.size(); i++) {
                    for (RoomDTO roomInCart : listInCart) {
                        if (listRoom.get(i).getRoomID() == roomInCart.getRoomID()) {
                            listRoom.remove(i);
                        }
                    }
                }
            url = SUCCESS;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
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
