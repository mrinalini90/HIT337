/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Catalogue;

/**
 *
 * @author Meeru
 */
public class Item {

private String ItemId;
private String ItemName;
private String ItemDescription;
private String UserName;

public Item(String ItemId, String ItemName, String ItemDescription,String UserName){
this.ItemId = ItemId;
this.ItemName = ItemName;
this.ItemDescription = ItemDescription;
this.UserName = UserName;
}

   public Item() {
       
    }

  
public String getId(){ return this.ItemId;}
public String getItemName(){ return this.ItemName;}
public String getItemDescription(){return this.ItemDescription;} 
public String getUserName(){ return this.UserName;}

public void setId(String ItemId){this.ItemId=ItemId;}
public void setItemName(String ItemName){this.ItemName=ItemName;}
public void setItemDescription(String ItemDescription){this.ItemDescription=ItemDescription;}
public void setUserName(String userName){this.UserName=userName;}
}


