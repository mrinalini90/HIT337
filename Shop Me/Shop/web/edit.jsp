<!-- Edit Items page -->


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Update</title>        
    </head>
    <body>
           <!--navBar inserted -->
        <jsp:include page="navBar.jsp" />   
        <div class="Container">
            <form class="form-horizontal" action="EditItem" method="GET" enctype="text/plain">

                <div class="form-group">
                    <label class="control-label col-sm-2" for="itemname">Product name:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="itemname"   name="updatedname" value="${editItem.itemname}" required data-fv-notempty-message="Please enter an item name">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="itemdescription">Product description:</label>
                    <div class="col-sm-10">          
                        <input type="text" class="form-control" id="itemdescription" value ="${editItem.itemdescription}" name="updateddescription" required data-fv-notempty-message="Please enter an item description">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="itemquantity">Product quantity:</label>
                    <div class="col-sm-10">          
                        <input type="integer" class="form-control" id="itemquantity" value ="${editItem.itemquanity} " name="updatedquantity" required data-fv-notempty-message="Please enter an item quantity">
                    </div>
                </div>   
                <div class="form-group">
                    <label class="control-label col-sm-2" for="itemprice">Product price:</label>
                    <div class="col-sm-10">          
                        <input type="decimal" class="form-control" id="itemprice" value ="${editItem.itemprice}" name="updatedprice" required data-fv-notempty-message="Please enter an item price">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="itemstatus">Product status</label>
                    <div class="col-sm-10"> 
                        <select class="form-control" id="itemstatus" name="updatedstatus">
                            <option selected="${editItem.itemstatus}">Not Selling</option>
                            <option selected="${editItem.itemstatus}">Selling</option>
                        </select>  
                    </div>
                </div>   
                <div class="row">   
                    <div class="col-sm-9"></div><div class="col-sm-3">
                        <button type="submit" value ="${editItem.itemid}" name="update" class="btn btn-info btn-sm" >Update</button> 
                        <button type="submit" value ="cancel" name="cancel" class="btn btn-info btn-sm" >Cancel</button> 
                    </div></div>
            </form>
        </div>

    </body>
</html>
