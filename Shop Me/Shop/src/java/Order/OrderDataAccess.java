/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order;

import customer.Customer;
import customer.Register;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Meeru
 */
public class OrderDataAccess implements OrderInterface {

    private final String connectionURL = "jdbc:derby://localhost:1527/shopmedb";
    ArrayList<Finalorder> list = new ArrayList<Finalorder>();

    @Override
    public void addItemToOrder(int itemid, String itemname, int quantity, float itemprice, int buyerid) {
        try {
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            } catch (InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }

            Connection conn = DriverManager.getConnection(connectionURL);
            PreparedStatement statement = conn.prepareStatement("INSERT INTO FINALORDER(itemid,itemname,itemquanity,itemprice,buyerid) VALUES (?,?,?,?,?)");
            statement.setInt(1, itemid);
            statement.setString(2, itemname);
            statement.setInt(3, quantity);
            statement.setFloat(4, itemprice);
            statement.setInt(5, buyerid);
            statement.executeUpdate();
            statement.close();
            conn.close();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @Override
    public void addItemsToOrder(ArrayList<Finalorder> addlist, Customer user) {

        try {

            String query = " INSERT INTO FINALORDER(itemid,itemname,itemquanity,itemprice,buyerid) VALUES (?,?,?,?,?)";
            Connection conn = null;
            conn = DriverManager.getConnection(connectionURL);

            // declare the preparedstatement reference
            PreparedStatement preparedStmt = null;
            try {
                preparedStmt = conn.prepareStatement(query);

                for (Finalorder n : addlist) {
                    preparedStmt.setInt(1, n.getItemid());
                    preparedStmt.setString(2, n.getItemname());
                    preparedStmt.setInt(3, n.getItemquanity());
                    preparedStmt.setFloat(4, n.getItemprice());
                    preparedStmt.setInt(5, user.id);
                    preparedStmt.execute();
                }
            } catch (SQLException se) {
                se.printStackTrace();
                try {
                    throw se;
                } catch (SQLException ex) {
                    Logger.getLogger(OrderDataAccess.class.getName()).log(Level.SEVERE, null, ex);
                }
            } finally {
                try {
                    // close the statement when all the INSERT's are finished
                    preparedStmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(OrderDataAccess.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
