/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Product;

import customer.Customer;
import customer.Register;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Meeru
 */

//DATABASE SQL functions class for items
public class ItemDataAccess implements ItemInterface {

    private final String connectionURL = "jdbc:derby://localhost:1527/shopmedb";

    /**
     *
     * @return
     */
    public boolean getConnection() {
        boolean connected = false;
        try {
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            } catch (InstantiationException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }

            Connection conn = DriverManager.getConnection(connectionURL);
            connected = true;
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            connected = false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            connected = false;
        }
        return connected;
    }

    @Override
    public void addItem(String itemname, String itemdescription, Integer itemquanity, float itemprice, int sellerid) {
        try {
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            } catch (InstantiationException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }

            Connection conn = DriverManager.getConnection(connectionURL);
            PreparedStatement statement = conn.prepareStatement("INSERT INTO ITEM (itemname,itemdescription,itemquanity,itemprice,sellerid) VALUES (?,?,?,?,?)");
            statement.setString(1, itemname);
            statement.setString(2, itemdescription);
            statement.setInt(3, itemquanity);
            statement.setFloat(4, itemprice);
            statement.setInt(5, sellerid);
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
    public ArrayList<Item> getAllProducts(Customer seller) {
        ArrayList<Item> allProducts = new ArrayList<Item>();
        try {
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            } catch (InstantiationException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }

            Connection conn = DriverManager.getConnection(connectionURL);
            PreparedStatement statement;
            if (seller.id != null) {
                statement = conn.prepareStatement("SELECT * FROM ITEM WHERE ITEMQUANITY > 0 AND SELLERID = " + seller.id);
                System.out.println("");
            } else {
                statement = conn.prepareStatement("SELECT * FROM ITEM WHERE ITEMSTATUS = TRUE AND  ITEMQUANITY > 0");
                System.out.println("");
            }
            ResultSet rs;
            rs = statement.executeQuery();
            while (rs.next()) {
                int itemid = rs.getInt("itemid");
                String itemname = rs.getString("itemname");
                String itemdescription = rs.getString("itemdescription");
                int itemquanity = rs.getInt("itemquanity");
                float itemprice = rs.getFloat("itemprice");
                boolean itemstatus = rs.getBoolean("itemstatus");
                int sellerid = rs.getInt("sellerid");
                Item item = new Item(itemid, itemname, itemdescription, itemquanity, itemprice, itemstatus, sellerid);
                allProducts.add(item);
            }
            rs.close();
            statement.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allProducts;
    }

    @Override
    public void deleteItem(int id) {
        try {
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            } catch (InstantiationException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }

            Connection conn = DriverManager.getConnection(connectionURL);
            PreparedStatement statement;
            statement = conn.prepareStatement("DELETE FROM ITEM WHERE itemid = " + id);
            System.out.println("");
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
    public void UpdateItem(int itemid, String itemname, String itemdescription, Integer itemquanity, float itemprice, boolean itemstatus, int sellerid) {
        try {
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            } catch (InstantiationException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }

            Connection conn = DriverManager.getConnection(connectionURL);
            PreparedStatement statement = conn.prepareStatement("UPDATE ITEM SET itemname=? ,itemdescription=? ,itemquanity=? ,itemprice= ?,itemstatus=?,sellerid=? Where itemid=?");
            statement.setString(1, itemname);
            statement.setString(2, itemdescription);
            statement.setInt(3, itemquanity);
            statement.setFloat(4, itemprice);
            statement.setBoolean(5, itemstatus);
            statement.setInt(6, sellerid);
            statement.setInt(7, itemid);
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
    public Item getItemById(int id) {
        Item item = null;
        try {
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            } catch (InstantiationException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }

            Connection conn = DriverManager.getConnection(connectionURL);
            PreparedStatement statement;
            statement = conn.prepareStatement("SELECT * FROM ITEM WHERE ITEMID = " + id);
            System.out.println("");

            ResultSet rs;
            rs = statement.executeQuery();
            while (rs.next()) {
                int itemid = rs.getInt("itemid");
                String itemname = rs.getString("itemname");
                String itemdescription = rs.getString("itemdescription");
                int itemquanity = rs.getInt("itemquanity");
                float itemprice = rs.getFloat("itemprice");
                boolean itemstatus = rs.getBoolean("itemstatus");
                int sellerid = rs.getInt("sellerid");
                item = new Item(itemid, itemname, itemdescription, itemquanity, itemprice, itemstatus, sellerid);
            }
            rs.close();
            statement.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        return item;
    }

    @Override
    public void AddItemToCart(int itemid) {
        Item tempitem = new Item();
        tempitem = getItemById(itemid);
        String itemname = tempitem.getItemname();
        String itemdescription = tempitem.getItemdescription();
        Integer itemquanity = tempitem.getItemquanity();
        float itemprice = tempitem.getItemprice();
        boolean itemstatus = tempitem.getItemstatus();
        int sellerid = tempitem.getSellerid();
        itemquanity = itemquanity - 1;
        System.out.println(itemquanity);
        try {
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            } catch (InstantiationException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }

            Connection conn = DriverManager.getConnection(connectionURL);
            PreparedStatement statement = conn.prepareStatement("UPDATE ITEM SET itemname=? ,itemdescription=? ,itemquanity=? ,itemprice= ?,itemstatus=?,sellerid=? Where itemid=?");
            statement.setString(1, itemname);
            statement.setString(2, itemdescription);
            statement.setInt(3, itemquanity);
            statement.setFloat(4, itemprice);
            statement.setBoolean(5, itemstatus);
            statement.setInt(6, sellerid);
            statement.setInt(7, itemid);
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
    public void RemoveItemFromCart(int itemid) {
        Item tempitem = new Item();
        tempitem = getItemById(itemid);
        String itemname = tempitem.getItemname();
        String itemdescription = tempitem.getItemdescription();
        Integer itemquanity = tempitem.getItemquanity();
        float itemprice = tempitem.getItemprice();
        boolean itemstatus = tempitem.getItemstatus();
        int sellerid = tempitem.getSellerid();
        itemquanity = itemquanity + 1;
        System.out.println(itemquanity);
        try {
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            } catch (InstantiationException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }

            Connection conn = DriverManager.getConnection(connectionURL);
            PreparedStatement statement = conn.prepareStatement("UPDATE ITEM SET itemname=? ,itemdescription=? ,itemquanity=? ,itemprice= ?,itemstatus=?,sellerid=? Where itemid=?");
            statement.setString(1, itemname);
            statement.setString(2, itemdescription);
            statement.setInt(3, itemquanity);
            statement.setFloat(4, itemprice);
            statement.setBoolean(5, itemstatus);
            statement.setInt(6, sellerid);
            statement.setInt(7, itemid);
            statement.executeUpdate();
            statement.close();
            conn.close();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
}
