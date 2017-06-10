/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer;

import java.util.ArrayList;

/**
 *
 * @author Meeru
 */
public interface UserInterface {

    public boolean getConnection();

    public void addUser(String name, String email, String password);

    public ArrayList<Customer> getAllUser();

    public ArrayList<String> getUserEmails();

    public void getUserNames();

    public Customer getUserByEmail(String email);

    public Customer getUserById(int id);
    
    public void updateUser(String name, String password,int id);
}
