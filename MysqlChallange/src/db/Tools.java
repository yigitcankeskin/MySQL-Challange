/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLException;

public class Tools {
    
    static String username="root"; 
    static String password="admin";
    static String dburl="jdbc:mysql://localhost:3306/assignment";   
                         
    public Connection getConnection() throws SQLException {
        return(Connection) DriverManager.getConnection(dburl,username,password);
    }
    public void ShowError(SQLException exception){
        System.out.println("Error : "+ exception.getMessage());
    }
}
