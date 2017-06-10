
<!-- my Products Page displays users specific items -->



<%@ taglib uri="WEB-INF/tlds/Items.tld" prefix = "a"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Products</title>
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
                        <li><a href="Home">Home</a></li>
                        <li class="active"><a href="myProducts">My Products</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href=""  data-toggle="modal" data-target="#cart"><span class="glyphicon glyphicon-user"></span> Shopping cart</a></li>
                         <li><a href="userProfile.jsp"><span class="glyphicon glyphicon-user"></span>User Profile</a></li>
                        <li><a href="Logout"><span class="glyphicon glyphicon-log-out"></span>Sign out</a></li>
                    </ul>
                </div>
            </div>
        </nav>



        <div class="container">
            <div><h5>${deleteError}</h5></div>
            
            <h3>Your Products</h3>
            <h5>You can put them up for sale by editing the product</h5>
            
            <br>
            
            <!-- Trigger the modal with a button -->
            <button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal">Add Product</button>
            <br><br>
            <div class="container">
                <table class="table table-condensed">
                    <thead>
                        <tr>
                            <th>Product Name</th>
                            <th>Product Description</th>
                            <th>Product Quantity</th>
                            <th>Product Price</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${myProducts}" var="item">
                            <tr>
                                <td><c:out value="${item.itemname}" /></td>
                                <td><c:out value="${item.itemdescription}" /></td>
                                <td><c:out value="${item.itemquanity}" /></td>
                                <td><c:out value="${item.itemprice}" /></td>
                                <td>
                                    <form  action="DeleteItem" method="GET" enctype="text/plain">    
                                        <button type="submit" value ="${item.itemid}" name="delete" class="btn btn-warning btn-sm" >Delete</button> | 
                                        <button type="submit" value ="${item.itemid}" name="view" class="btn btn-primary btn-sm" >Edit</button> 
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>            
                    </tbody>
                </table>
            </div>




            <!-- Modal -->
            <div class="modal fade" id="myModal" role="dialog">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <form class="form-horizontal" action="AddItem" method="GET" enctype="text/plain">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4 class="modal-title">New Item</h4>
                            </div>
                            <div class="modal-body">                      
                                <div class="form-group">
                                    <label class="control-label col-sm-2" for="itemname">Product name:</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="itemname" placeholder="Enter Product name" name="itemname" required data-fv-notempty-message="Please enter an item name">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-2" for="itemdescription">Product description:</label>
                                    <div class="col-sm-10">          
                                        <input type="text" class="form-control" id="itemdescription" placeholder="Enter Product description" name="itemdescription" required data-fv-notempty-message="Please enter an item description">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-2" for="itemquantity">Product quantity:</label>
                                    <div class="col-sm-10">          
                                        <input type="number" class="form-control" id="itemquantity" placeholder="Enter Product quantity" name="itemquantity" required data-fv-notempty-message="Please enter an item quantity">
                                    </div>
                                </div>   
                                <div class="form-group">
                                    <label class="control-label col-sm-2" for="itemprice">Product price:</label>
                                    <div class="col-sm-10">          
                                        <input type="decimal" class="form-control" id="itemprice" placeholder="Enter Product price" name="itemprice" required data-fv-notempty-message="Please enter an item price">
                                    </div>
                                </div>                         
                            </div>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-default">Add Item</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>                   
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <!-- Cart Modal -->
            <div class="modal fade" id="cart" role="dialog">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <form class="form-horizontal" action="CheckOut" method="GET" enctype="text/plain">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4 class="modal-title">New Item</h4>
                            </div>
                            <div class="modal-body">      


                                <div class="container">
                                    <table class="table-responsive table-condensed">
                                        <thead>
                                            <tr>
                                                <th class="col-md-1">Product Name</th>
                                                <th class="col-md-1">Product Quantity</th>
                                                <th class="col-md-1">Product Price</th>
                                                <th class="col-md-2"></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${cart}" var="item">
                                                <tr>
                                                    <td class="col-md-1"><c:out value="${item.itemname}" /></td>
                                                    <td class="col-md-1"><c:out value="${item.itemquanity}" /></td>
                                                    <td class="col-md-1"><c:out value="${item.itemprice}" /></td>
                                                    <td class="col-md-2">   
                                                        <button type="submit" value ="${item.itemid}" name="deleteCart" class="btn btn-warning btn-sm" >Remove</button> 
                                                    </td>
                                                </tr>
                                            </c:forEach>              
                                        </tbody>
                                    </table>
                                </div>                                
                            </div>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-default" value="checkout" name="checkout">Check Out</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>                   
                            </div>
                        </form>
                    </div>
                </div>
            </div>


        </div>

    </body>
</html>
