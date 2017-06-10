<%-- 
  user profiles of user to update
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Profile</title>
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
                        <li><a href=""  data-toggle="modal" data-target="#cart"><span class="glyphicon glyphicon-user"></span> Shopping cart</a></li>
                        <li><a href="userProfile.jsp"><span class="glyphicon glyphicon-user"></span>User Profile</a></li>
                        <li><a href="Logout"><span class="glyphicon glyphicon-log-out"></span>Sign out</a></li>
                    </ul>
                </div>
            </div>
        </nav>


        <div class="container-fluid">
            <div class="jumbotron">
                <h3>User Profile</h3> 
                <p></p> 
            </div>
            <div class="form-group row">
                <div class="col-sm-3"></div>
                <div class="col-sm-5"></div>
                <div class="col-sm-4">    
                    <button type="button" class="btn btn-info" data-toggle="modal" data-target="#editModal">Edit</button> 
                </div>
            </div> 


            <div class="form-group row">
                <div class="col-sm-3"></div>
                <div class="col-sm-2">
                    <label for="">User Name :</label>
                </div>
                <div class="col-sm-4">
                    <label for="">${currentSessionUser.name}</label>
                </div>
            </div> 
            <div class="form-group row">
                <div class="col-sm-3"></div>
                <div class="col-sm-2">
                    <label for="">User Email :</label>
                </div>
                <div class="col-sm-4">
                    <label for="">${currentSessionUser.email}</label>
                </div>
            </div> 
            <div class="form-group row">
                <div class="col-sm-3"></div>
                <div class="col-sm-2">
                    <label for="">User Password :</label>
                </div>
                <div class="col-sm-4">
                    <label for="">${currentSessionUser.password}</label>
                </div>
            </div> 
            <div class="form-group row">
                <div class="col-sm-3"></div>
                <div class="col-sm-2">
                    <label for="">Is Admin :</label>
                </div>
                <div class="col-sm-4">
                    <label for="">${currentSessionUser.isadmin}</label>
                </div>
            </div> 




            <!-- Modal -->
            <div class="modal fade" id="editModal" role="dialog">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <form class="form-horizontal" action="UpdateUser" method="GET" enctype="text/plain">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4 class="modal-title">Update User</h4>
                            </div>
                            <div class="modal-body">                      
                                <div class="form-group">
                                    <label class="control-label col-sm-2" for="name">Name :</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="name" placeholder="Enter your name" value="${currentSessionUser.name}" name="name" required data-fv-notempty-message="Please enter your name">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-2" for="email">Email :</label>
                                    <div class="col-sm-10">          
                                        <input type="text" class="form-control" id="email"  placeholder="Enter your email" value="${currentSessionUser.email}" name="email" required data-fv-notempty-message="Please enter your email"  disabled>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-2" for="password">Password :</label>
                                    <div class="col-sm-10">          
                                        <input type="text" class="form-control" id="password" placeholder="Enter Password" value="${currentSessionUser.password}"  name="password" required data-fv-notempty-message="Please enter your password">
                                    </div>
                                </div>   
                                <div class="form-group">
                                    <label class="control-label col-sm-2" for="isadmin">Is Admin :</label>
                                    <div class="col-sm-10">       
                                        <select class="form-control" id="isadmin"  disabled>
                                            <option>True</option>
                                            <option selected="">False</option>
                                        </select>
                                    </div>
                                </div>                         
                            </div>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-default" value ="${currentSessionUser.id}" name ="updateuser">Update</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>                   
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>
    </body>
</html>
