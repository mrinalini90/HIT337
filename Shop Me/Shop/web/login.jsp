<%-- 
  Login page
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <!--  <link rel="stylesheet" href="library/bootstrap/css/bootstrap.min.css">  
          <script src="library/bootstrap/js/jquery-3.2.1.min.js"></script>  
          <script src="library/bootstrap/js/bootstrap.min.js"></script> -->
    </head>
    <body>
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
                        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class = "Container"><br> 
            <div class="jumbotron">
                <h2> Sign In </h2>
                <h3>Welcome Back to Shop Me</h3>                     
            </div>

            <form class="form-group "   action="Login" method="GET" enctype="text/plain">

                <div style="color: #FF0000;">${errorMessage}</div><br>
                <div class="row">

                    <label  class="col-sm-2 col-form-label">Enter Email</label>
                    <div class="col-sm-8">
                        <input type="email" class="form-control" name ="email" placeholder="email" required data-fv-notempty-message="Please enter an email address" >               
                    </div>
                </div>
                <div class="row">
                    <label  class="col-sm-2 col-form-label">Enter Password</label>
                    <div class="col-sm-8">
                        <input type="password" class="form-control" name ="password" placeholder="password" required data-fv-notempty-message="Please enter a password" >
                    </div>
                </div>
                <div class="form-group row">
                    <br>
                    <div class="col-sm-3"></div>
                    <div class="col-sm-5"></div>
                    <div class="col-sm-4">
                        <button type="submit" class="btn btn-info btn-lg" value ="submit">Sign in</button>
                    </div>
                </div> 
            </form>
        </div>
    </body>
</html>
