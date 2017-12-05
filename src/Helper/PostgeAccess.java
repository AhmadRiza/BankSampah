/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author riza
 */
public class PostgeAccess {
    private final String URL= "jdbc:postgresql://localhost/bank";
    private final String USER= "riza";
    private final String PASS= "root";
    
    protected Connection connect = null;

    public PostgeAccess() {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        
    }
    
    protected void openConection(){
        try {
            connect = DriverManager.getConnection(URL,USER,PASS);
        } catch (SQLException ex) {
            Logger.getLogger(MySQLAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void closeConnection() {
        try {
            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }
    
}
