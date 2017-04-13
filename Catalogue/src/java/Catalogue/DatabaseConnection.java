/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Meeru
 */
public class DatabaseConnection implements Users {

//    private String jdbcConnectionString;
//    
//    public DatabaseConnection(String jdbcConnectionString){
//    this.jdbcConnectionString = jdbcConnectionString;
//    }
    //jdbc:derby://localhost:1527/Catalogue
    @Override
    public boolean getConnection() throws SQLException {
        boolean connected;
        try {
            Class.forName("com.derby.jdbc.Catalogue");
            System.out.println("class");
        } catch (ClassNotFoundException ex) {
            System.out.println("classerror"+ex);
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String connectionURL = "jdbc:derby://localhost:1527/Catalogue [ on APP]";
        //ConnectionURL, username and password should be specified in getConnection()
        try {
        Connection conn = DriverManager.getConnection(connectionURL);
        System.out.println("Connect successfully ! ");
        connected = true;
        conn.close();
        } catch (SQLException ex) {
        System.out.println("Connect failed ! ");
            System.out.println(ex);
        connected = false;
        }
        
        return connected;
      
    }
    
    @Override
    public List<User> getAllUsers() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int addUser(int id, String userName, String Password) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
