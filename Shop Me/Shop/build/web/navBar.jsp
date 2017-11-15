<%-- 
    Document   : navBar
    Created on : 16-Nov-2017, 02:06:34
    Author     : Meeru
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="WEB-INF/tlds/Items.tld" prefix = "a"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">        
            <!-- local scripts -->
        <link rel="stylesheet" href="Library/bootstrap/css/bootstrap.min.css">  
        <script src="Library/bootstrap/js/jquery.min.js"></script>  
        <script src="Library/bootstrap/js/bootstrap.min.js"></script>
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
                        <li><a href=""  data-toggle="modal" data-target="#cart"><span class="glyphicon glyphicon-user"></span> Shopping cart</a></li>
                        <li><a href="userProfile.jsp"><span class="glyphicon glyphicon-user"></span>User Profile</a></li>
                        <li><a href="Logout"><span class="glyphicon glyphicon-log-out"></span>Sign out</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        
        
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

    </body>
</html>
