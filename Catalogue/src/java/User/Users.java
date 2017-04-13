/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import java.util.List;

/**
 *
 * @author Meeru
 */
public interface Users {
    public List<User> getAllUsers() throws Exception;
    public int addUser(int id,String userName, String Password) throws Exception;
}
