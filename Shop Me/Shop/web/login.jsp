<%-- 
  Login page
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <title>Login</title>
    </head>
    <body>
        <!-- Nav Bar  -->
        <jsp:include page="generalNav.jsp" /> 

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
