<%-- 
  user profiles of user to update
--%>

<%@ taglib uri="WEB-INF/tlds/Items.tld" prefix = "a"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>User Profile</title>    
    </head>
    <body>
        <!--navBar inserted -->
        <jsp:include page="navBar.jsp" />   
        
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
