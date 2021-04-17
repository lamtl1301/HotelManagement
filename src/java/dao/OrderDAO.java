/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import utils.DBIUtils;

/**
 *
 * @author Admin
 */
public class OrderDAO {

    public void setOrder(int orderID, String userID, double totalPrice) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBIUtils.getConnection();
            String sql = "INSERT tblOrders(orderID,userID,totalPrice,date)\n"
                    + "VALUES (?,?,?,CURRENT_TIMESTAMP)";
            stm = conn.prepareStatement(sql);
            stm.setInt(1, orderID);
            stm.setString(2, userID);
            stm.setDouble(3, totalPrice);
            stm.executeUpdate();
        } catch (Exception e) {
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}
