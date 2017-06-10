<!-- Edit Items page -->


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> 

        <!-- local scripts -->
        <!--  <link rel="stylesheet" href="library/bootstrap/css/bootstrap.min.css">  
        <script src="library/bootstrap/js/jquery-3.2.1.min.js"></script>  
        <script src="library/bootstrap/js/bootstrap.min.js"></script> -->
    </head>
    <body>
        <!-- Nav Bar  -->
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>                        
                    </button>
                    <a class="navbar-brand" href="Home">ShopMe</a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar"> 
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="Home">Home</a></li>
                        <li><a href="myProducts">My Products</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="userProfile.jsp"><span class="glyphicon glyphicon-user"></span>User Profile</a></li>
                        <li><a href="Logout"><span class="glyphicon glyphicon-log-out"></span>Sign out</a></li>
                    </ul>
                </div>
            </div>
        </nav>

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
