/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class DBUtils {
    public static Connection getConnection() throws Exception{
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionString = "jdbc:sqlserver://localhost:1433;database=Assignment_Data";
            
            Connection cnn = DriverManager.getConnection(connectionString,"sa","12345");
            return cnn;
        }catch(ClassNotFoundException | SQLException ex){
            throw ex;
        }
    }
}
