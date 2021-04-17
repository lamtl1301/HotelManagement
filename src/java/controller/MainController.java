/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class MainController extends HttpServlet {

    private final static String LOGIN = "LoginController";
    private final static String LOGOUT = "LogOutController";
    private final static String CREATE = "create.jsp";
    private final static String CREATE_ROOM = "CreateRoomController";
    private final static String REGISTER = "RegisterController";
    private final static String ADD = "AddController";
    private final static String VIEW = "viewcart.jsp";
    private final static String UPDATE = "UpdateController";
    private final static String UPDATE_ROOM = "UpdateRoomController";
    private final static String SEARCH = "SearchController";
    private final static String BOOKING = "BookingController";
    private final static String DELETE_ROOM = "DeleteController";
    private final static String RESERVE = "CheckLoginController";
    private final static String REMOVE = "RemoveController";
    private final static String DEFAULT = "LoadCategoryController";
    

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
        String url = DEFAULT;
        String action = request.getParameter("btnAction");
        try {
            if ("Login".equals(action)) {
                url = LOGIN;
            } else if ("LogOut".equals(action)) {
                url = LOGOUT;
            } else if ("Create".equals(action)) {
                url = CREATE;
            } else if ("Register".equals(action)) {
                url = REGISTER;
            } else if ("Add".equals(action)) {
                url = ADD;
            } else if ("View Order".equals(action)) {
                url = VIEW;
            } else if ("Update".equals(action)) {
                url = UPDATE;
            } else if ("Update Room".equals(action)) {
                url = UPDATE_ROOM;
            } else if ("Search".equals(action)) {
                url = SEARCH;
            } else if ("Booking".equals(action)) {
                url = BOOKING;
            } else if ("Delete".equals(action)) {
                url = DELETE_ROOM;
            } else if ("Reserve".equals(action)) {
                url = RESERVE;
            } else if ("Remove".equals(action)) {
                url = REMOVE;
            } else if ("Create Room".equals(action)) {
                url = CREATE_ROOM;
            }
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
