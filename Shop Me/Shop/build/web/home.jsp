<!-- Items to buy page -->

<!-- direct cdn or online scripts were added as its design looks better -->
<%@ taglib uri="WEB-INF/tlds/Items.tld" prefix = "a"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  


<!DOCTYPE html>
<html>
    <head>
         <title>Home</title>
    </head>
    <body>
        <!--navBar inserted -->
        <jsp:include page="navBar.jsp" />   
        <div class="container">
            <div><h5>${deleteError}</h5></div>
            <h3>Welcome!</h3>
            <h4>Check out these products available</h4>

            <br><br>

            <div class="container">
                <table class="table table-condensed">
                    <thead>
                        <tr>
                            <th class="col-md-2">Product Name</th>
                            <th class="col-md-6">Product Description</th>
                            <th class="col-md-2">Product Quantity</th>
                            <th class="col-md-2">Product Price</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${allProducts}" var="item">
                            <tr>
                                <td class="col-md-2"><b><c:out value="${item.itemname}" /></b></td>
                                <td class="col-md-6"><c:out value="${item.itemdescription}" /></td>
                                <td class="col-md-2"><c:out value="${item.itemquanity}" /></td>
                                <td class="col-md-2">$ <c:out value="${item.itemprice}" /></td>
                                <td>
                                    <form  action="AddCart" method="GET" enctype="text/plain">    
                                        <button type="submit" value ="${item.itemid}" name="AddCart" class="btn btn-info btn-sm" >Add to cart</button> 
                                    </form>
                                    <br>
                                </td>

                            </tr>
                        </c:forEach>            
                    </tbody>
                </table>
            </div>
          
        </div>

    </body>
</html>
