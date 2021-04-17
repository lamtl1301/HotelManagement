/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import convert.SharedLib;
import dao.OrderDAO;
import dao.OrderDetailDAO;
import dao.RoomDAO;
import dto.CartDTO;
import dto.RoomDTO;
import dto.UserDTO;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
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
@WebServlet(name = "CheckoutController", urlPatterns = {"/CheckoutController"})
public class CheckoutController extends HttpServlet {

    private static final String ERROR = "view.jsp";
    private static final String FAIL = "notfound.ht";
    private static final String SUCCESS = "thanks.jsp";

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
        String url = FAIL;
        try {
            HttpSession session = request.getSession();
            UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");

            CartDTO cart = (CartDTO) session.getAttribute("CART");
            RoomDAO daoRoom = new RoomDAO();
            Long temp = new Date().getTime();
            int orderID = Math.abs(temp.intValue());
            for (RoomDTO value : cart.getCart().values()) {
                RoomDTO dto = daoRoom.getInfoRoom(value.getRoomID());
                if (dto.isRented(    )) {
                    url = ERROR;
                    request.setAttribute("ERROR_CHECKOUT", "Having room been rented");
                    request.setAttribute("ERROR_ROOM", dto);
                }
            }
            if (!url.equals(ERROR)) {
                double totalPrice = Double.parseDouble(request.getParameter("txtTotalMoney"));
                String userID = user.getUserID();
                OrderDetailDAO daoOrderDetail = new OrderDetailDAO();
                OrderDAO daoOrder = new OrderDAO();
                daoOrder.setOrder(orderID, userID, totalPrice);
                for (HashMap.Entry<Integer, RoomDTO> entry : cart.getCart().entrySet()) {
                    daoOrderDetail.setOrderDetail(entry.getValue().getRoomID(),
                            entry.getValue().getPrice(), SharedLib.converDateToString(entry.getValue().getCheckin()),
                            SharedLib.converDateToString(entry.getValue().getCheckout()), orderID);
                    daoRoom.setRentedRoom(  entry.getValue().getRoomID());
                }
                url = SUCCESS;
                session.setAttribute("CART",null);

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
