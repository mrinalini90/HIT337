/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 *
 * @author Meeru
 */
public class CartItem implements Serializable {

    private int itemid;
    private String itemname;
    private int quantity;
    private float itemprice;
    private int buyer;

    public CartItem() {
    }

    public CartItem(int itemid, String itemname, int quantity, float itemprice, int buyer) {
        this.itemid = itemid;
        this.itemname = itemname;
        this.quantity = quantity;
        this.itemprice = itemprice;
        this.buyer = buyer;
    }

    public int getItemid() {
        return itemid;
    }

    public String getItemname() {
        return itemname;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getItemprice() {
        return itemprice;
    }

    public int getBuyer() {
        return buyer;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setItemprice(float itemprice) {
        this.itemprice = itemprice;
    }

    public void setBuyer(int buyer) {
        this.buyer = buyer;
    }

//    @Override
//    public void valueBound(HttpSessionBindingEvent event) {
//        System.out.println("meeru working"+event.getSession().getServletContext().getAttribute("cart"));
//        cart = (ArrayList<CartItem>) event.getSession().getServletContext().getAttribute("cart"); 
//    }
//    ArrayList<CartItem> cart ;
//    ItemDataAccess access = new ItemDataAccess(); 
//    @Override
//    public void valueUnbound(HttpSessionBindingEvent event) {
//        
//        System.out.println("Meeru"+event.getSession().getServletContext().getAttribute("cart"));
////           cart = (ArrayList<CartItem>) event.getSession().getServletContext().getAttribute("cart"); 
////        for(CartItem item : cart)
////            {
////                try {
////                    int id =item.getItemid();
////                    access.RemoveItemFromCart(id);
////                } catch (ClassNotFoundException ex) {
////                    Logger.getLogger(AddCart.class.getName()).log(Level.SEVERE, null, ex);
////                } catch (SQLException ex) {
////                    Logger.getLogger(AddCart.class.getName()).log(Level.SEVERE, null, ex);
////                }
////            }
    //  }
}
