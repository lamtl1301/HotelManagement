/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.TypeDTO;
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
public class TypeDAO {

    public List<TypeDTO> getTypeRoom() throws SQLException {
        List<TypeDTO> listType = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBIUtils.getConnection();
            String sql = "SELECT typeID, typeName\n"
                    + "FROM tblTypeRoom";
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while(rs.next()){
                String typeID = rs.getString("typeID");
                String typeName = rs.getString("typeName");
                TypeDTO type = new TypeDTO(typeID, typeName);
                if (listType == null){
                    listType = new ArrayList<>();
                }
                listType.add(type);
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
        return listType;
    }
}
