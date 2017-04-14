/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Catalogue;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Home extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Test</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Test at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
      String value = request.getParameter("username");
                   DatabaseConnection connection = new DatabaseConnection();
      
        
        try {
            boolean conn = connection.getConnection();
            if(conn == true){
            
            ArrayList<Item> con =  connection.getAllItems();
              
                PrintWriter out = response.getWriter();
                out. print("<h2>Welcome</h2>\n"+"<div class=\"row\">\n" +
                        "  <div class=\"col-sm-8\"></div>\n" +
                        "  <div class=\"col-sm-4\">  <a href=\"AddItems\" class=\"btn btn-primary \" role=\"button\" > + Add Item </a></div>\n" +
                        "</div>\n" +
                        "  \n" +
                        " \n" +
                        "   <table class=\"table\">\n" +
                        "    <thead>\n" +
                        "      <tr>\n" +
                        "       <th>Product name</th>\n" +
                        "       <th>Product Number</th>\n" +
                        "       <th>Product Description</th>\n" +
                                               "              </tr>\n" +
                        "    </thead>"                  
                    );
              
                out.print("<tbody>");
                for(int i=0;i<con.size();i++){
                 out.println("<tr><td>"+con.get(i).getId()+"</td><td>"+con.get(i).getItemName()+"</td><td>"+con.get(i).getItemDescription()+"</td></tr>");           
                }
                out.println(" </tbody>\n" +
"  </table>");
        } 
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
                
            String user=request.getParameter("user");         
 RequestDispatcher rd = request.getRequestDispatcher("List.html");
                rd.include(request, response);  
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response); 
         
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
