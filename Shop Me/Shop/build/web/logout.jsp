<!-- Logout page -->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> Logout</title>
    </head>
    <body>
        <!-- Nav Bar  -->
        <jsp:include page="generalNav.jsp" /> 

        <div class="container">
            <div class="jumbotron">
                <h1>You have successfully logged out</h1>      
                <p>Thank You for Shopping with us. </p>
            </div>
            <p>To Continue Shopping. Please Login!</p>  

            <a href="login.jsp" class="btn btn-info btn-lg" role="button">Login again</a>
        </div>

    </body>
</html>
