/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Catalogue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Meeru
 */
public class DatabaseConnection implements Items{
  
    private  String connectionURL = "jdbc:derby://localhost:1527/Catalogue";
    private ArrayList<Item> ItemList  ;
    private String id,name,description,userName;
    @Override
    public boolean getConnection() throws SQLException {
          //Creates Connection
        boolean connected;
                
        
        try {
            try {
              Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            } catch (InstantiationException ex) {
                Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
             Connection conn = DriverManager.getConnection(connectionURL);
        connected = true;
        conn.close();
        } catch (SQLException ex) {
           System.out.println(ex);
        connected = false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        connected = false;
        }
        return connected;
      
    }
    
    

    public int addItem(String ItemId,String ItemName,String ItemDescription , String userName) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    public int addItem(int id, String userName, String Password) throws Exception {
//        Connection conn = DriverManager.getConnection(connectionURL); 
//       String sql = "INSERT INTO IS2560.DEMO (ID, NAME) VALUES (3, 'demo3')";
//        Statement st = conn.createStatement();
//        st.executeUpdate(sql);
//        st.close();
//        conn.close(); 
//        return 0;
//           }

    @Override
    public ArrayList<Item> getAllItems() throws Exception {
        ItemList = new ArrayList<Item>();
              Connection conn = DriverManager.getConnection(connectionURL); 
        String query = "SELECT * FROM items";
        Statement statement = conn.createStatement();
        ResultSet rs=null;
        rs=statement.executeQuery(query);
        while(rs.next()){
            id= rs.getString("itemid");            
            name= rs.getString("itemname");
            description= rs.getString("itemdescription");
            userName = rs.getString("username");
            Item itemobject = new Item(id,name,description,userName);
            ItemList.add(itemobject);
            }
        rs.close();
        statement.close();
        conn.close();
        return ItemList;

    }
}
