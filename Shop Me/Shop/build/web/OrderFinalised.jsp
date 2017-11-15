<%-- 
    Order Placed page
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> Finalised</title>    
    </head>
    <body>
            <!-- Nav Bar  -->
           <jsp:include page="navBar.jsp" />     

        <div class="container">
            <div class="jumbotron">
                <h1>Your Order has been Processed</h1>      
                <p>Thank You for Shopping with us. </p>
            </div>
            <p>To Continue Shopping. Please click the button below</p>      
            <a href="Home" class="btn btn-info btn-lg" role="button">Continue Shopping</a> 
            
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
