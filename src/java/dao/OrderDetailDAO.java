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
public class OrderDetailDAO {

    public void setOrderDetail(int roomID, double price, String checkin, String checkout, int orderID) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBIUtils.getConnection();
            String sql = "INSERT tblOrderDetail(orderID,roomID,price,checkin,checkout)\n"
                    + "VALUES (?,?,?,?,?)";
            stm = conn.prepareStatement(sql);
            stm.setInt(1, orderID);
            stm.setInt(2, roomID);
            stm.setDouble(3, price);
            stm.setString(4, checkin);
            stm.setString(5, checkout);
            stm.executeUpdate();
        } catch (Exception e) {
        } finally{
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}
