package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class DBIUtils {
    public static Connection getConnection() throws SQLException{
        Connection conn=null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost;databasename=ResortManagement";
            conn = DriverManager.getConnection(url, "sa", "se1456");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBIUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return conn;
    }


}
