<%-- 
    Document   : generalNav
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
    </body>
</html>
