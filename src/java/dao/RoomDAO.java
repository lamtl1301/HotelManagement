/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import convert.SharedLib;
import dto.RoomDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBIUtils;

/**
 *
 * @author Admin
 */
public class RoomDAO {

    public RoomDTO getInfoRoom(int roomID) throws SQLException {
        RoomDTO room = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBIUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT description,img,isRented,name, typeID, status, price, max\n"
                        + "FROM tblRoom \n"
                        + "WHERE roomID = ?";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, roomID);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String description = rs.getString("description");
                    String typeID = rs.getString("typeID");
                    String img = rs.getString("img");
                    String name = rs.getString("name");
                    double priceRoom = rs.getDouble("price");
                    boolean status = rs.getBoolean("status");
                    boolean rented = rs.getBoolean("isRented");
                    int max = rs.getInt("max");
                    room = new RoomDTO(roomID, name, description, typeID, img, status, rented, priceRoom, max);
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return room;
    }

    public List<RoomDTO> getListRoom() throws SQLException {
        ArrayList<RoomDTO> list = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBIUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT roomID, isRented,description,img,name, typeID, status, price, max\n"
                        + "FROM tblRoom ";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int roomID = rs.getInt("roomID");
                    String description = rs.getString("description");
                    String typeID = rs.getString("typeID");
                    String img = rs.getString("img");
                    String name = rs.getString("name");
                    double priceRoom = rs.getDouble("price");
                    boolean status = rs.getBoolean("status");
                    boolean rented = rs.getBoolean("isRented");
                    int max = rs.getInt("max");
                    RoomDTO room = new RoomDTO(roomID, name, description, typeID, img, status, rented, priceRoom, max);
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    list.add(room);
                }
            }

        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public List<RoomDTO> getListRoomCanBook() throws SQLException {
        ArrayList<RoomDTO> list = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBIUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT roomID, description, img, name, typeID, status, price, max\n"
                        + "FROM tblRoom \n"
                        + "WHERE status = 1 "
                        + "AND roomID NOT IN (SELECT roomID FROM tblOrders b, tblOrderDetail c\n"
                        + "WHERE b.orderID = c.orderID\n";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int roomID = rs.getInt("roomID");
                    String description = rs.getString("description");
                    String typeID = rs.getString("typeID");
                    String img = rs.getString("img");
                    String name = rs.getString("name");
                    double priceRoom = rs.getDouble("price");
                    boolean status = rs.getBoolean("status");
                    boolean rented = false;
                    int max = rs.getInt("max");
                    RoomDTO room = new RoomDTO(roomID, name, description, typeID, img, status, rented, priceRoom, max);
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    list.add(room);
                }
            }

        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public List<RoomDTO> getListSearchRoom(String checkin, String checkout, double price, int people) throws SQLException {
        List<RoomDTO> listRoom = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBIUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT roomID, name, description, typeID, img, status, price, max\n"
                        + "FROM tblRoom\n"
                        + "WHERE price <= " + price + " "
                        + "AND status = 1 "
                        + "AND max >= " + people + " "
                        + "AND roomID NOT IN (SELECT roomID FROM tblOrderDetail \n"
                        + "                     WHERE checkin >= '" + checkin + "' \n"
                        + "			AND checkin <= '" + checkout + "' \n"
                        + "			AND checkout >= '" + checkin + "' \n"
                        + "			AND checkout <= '" + checkout + "' ) ";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int roomID = rs.getInt("roomID");
                    String description = rs.getString("description");
                    String typeID = rs.getString("typeID");
                    String img = rs.getString("img");
                    String name = rs.getString("name");
                    boolean status = rs.getBoolean("status");
                    double priceRoom = rs.getDouble("price");
                    int max = rs.getInt("max");
                    boolean rented = false;
                    RoomDTO room = new RoomDTO(roomID, name, description, typeID, img, status, rented, price, max, SharedLib.convertStringToDate(checkin), SharedLib.convertStringToDate(checkout));
                    if (listRoom == null) {
                        listRoom = new ArrayList<>();
                    }
                    listRoom.add(room);
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return listRoom;
    }

    public boolean updateRoom(RoomDTO room) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            conn = DBIUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE tblRoom\n"
                        + "SET name = ?, description = ?, typeID = ?, img =?, \n"
                        + "max = ?, price = ? "
                        + "WHERE roomID = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, room.getName());
                stm.setString(2, room.getDescription());
                stm.setString(3, room.getTypeID());
                stm.setString(4, room.getImg());
                stm.setInt(5, room.getMax());
                stm.setDouble(6, room.getPrice());
                stm.setInt(7, room.getRoomID());
                stm.executeUpdate();
                result = true;
            }
        } catch (Exception e) {
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    public void addNewRoom(RoomDTO room) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBIUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT into tblRoom(roomID,name,description,typeID,img,price,max)\n"
                        + "values (?,?,?,?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, room.getRoomID());
                stm.setString(2, room.getName());
                stm.setString(3, room.getDescription());
                stm.setString(4, room.getTypeID());
                stm.setString(5, room.getImg());
                stm.setDouble(6, room.getPrice());
                stm.setInt(7, room.getMax());
                stm.executeUpdate();
            }
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

    public void removeRoom(int roomID) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBIUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE tblRoom\n"
                        + "SET status = 0"
                        + "WHERE roomID = ?";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, roomID);
                stm.executeUpdate();
            }
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

    public void activeRoom(int roomID) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBIUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE tblRoom\n"
                        + "SET status = 1"
                        + "WHERE roomID = ?";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, roomID);
                stm.executeUpdate();
            }
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
    public void setRentedRoom(int roomID) throws SQLException{
                Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBIUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE tblRoom\n"
                        + "SET isRented = 1"
                        + "WHERE roomID = ?";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, roomID);
                stm.executeUpdate();
            }
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

    public boolean insertNewRoom(RoomDTO room) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        boolean rs = false;
        try {
            conn = DBIUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO tblRoom(description,price,typeID,img,max,name) \n"
                        + "VALUES  (?, ?, ?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, room.getDescription());
                stm.setDouble(2, room.getPrice());
                stm.setString(3, room.getTypeID());
                stm.setString(4, room.getImg());
                stm.setInt(5, room.getMax());
                stm.setString(6, room.getName());
                stm.executeUpdate();
                rs = true;
            }
        } catch (Exception e) {

        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return rs;
    }}
