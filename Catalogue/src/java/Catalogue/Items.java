/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Catalogue;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Meeru
 */
public interface Items {
    public boolean getConnection() throws SQLException;
    public ArrayList<Item> getAllItems() throws Exception;
    public int addItem(String ItemId,String ItemName,String ItemDescription , String userName) throws Exception;  
}
