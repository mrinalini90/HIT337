/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

/**
 *
 * @author Meeru
 */
public class User {
private int id;
private String userName;
private String password;

public User(int id, String userName, String password){
this.id = id;
this.userName = userName;
this.password = password;        
}

public int getId(){ return this.id;}
public String getUserName(){ return this.userName;}
public String getPassword(){return this.password;} 

public void setId(int id){this.id=id;}
public void setUserName(String userName){this.userName=userName;}
public void setPassword(String password){this.password=password;}
}

