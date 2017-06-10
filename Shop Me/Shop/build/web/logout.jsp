<!-- Logout page -->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> Logout</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        
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
                    <a class="navbar-brand" href="#">ShopMe</a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">            
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="index.jsp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                        <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                    </ul>
                </div>
            </div>
        </nav>

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
