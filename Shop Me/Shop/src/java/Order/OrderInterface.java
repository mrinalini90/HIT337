/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order;

import customer.Customer;
import java.util.ArrayList;

/**
 *
 * @author Meeru
 */
public interface OrderInterface {

    public void addItemsToOrder(ArrayList<Finalorder> addlist, Customer user);

    public void addItemToOrder(int itemid, String itemname, int quantity, float itemprice, int buyerid);
}
