/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Product;

import customer.Customer;
import java.util.ArrayList;

/**
 *
 * @author Meeru
 */
public interface ItemInterface {

    public boolean getConnection();

    public void addItem(String itemname, String itemdescription, Integer itemquanity, float itemprice, int sellerid);

    public ArrayList<Item> getAllProducts(Customer seller);

    public void deleteItem(int id);

    public void UpdateItem(int itemid, String itemname, String itemdescription, Integer itemquanity, float itemprice, boolean itemstatus, int sellerid);

    public Item getItemById(int id);

    public void AddItemToCart(int itemid);

    public void RemoveItemFromCart(int itemid);
}
