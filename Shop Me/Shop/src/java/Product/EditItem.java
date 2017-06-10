/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Product;

import customer.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Meeru
 */
public class EditItem extends HttpServlet {

    ItemDataAccess access = new ItemDataAccess();
    Customer user = new Customer();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            //check for update button clicks
        if (request.getParameter("update") != null) {
            
            //get upated values from jsp
            String updatename = request.getParameter("updatedname");
            String updateddescription = request.getParameter("updateddescription");
            int updatedquantity = Integer.parseInt(request.getParameter("updatedquantity").trim());
            float updatedprice = Float.parseFloat(request.getParameter("updatedprice").trim());
            int updatedid = Integer.parseInt(request.getParameter("update").trim());
            String status = request.getParameter("updatedstatus");
            boolean updatedstatus = validateItemStatus(status);
            
            //get session information
            HttpSession session = request.getSession(false);
            user = (Customer) session.getAttribute("currentSessionUser");
            
            //update the db
            access.UpdateItem(updatedid, updatename, updateddescription, updatedquantity, updatedprice, updatedstatus, user.id);
            
            
            response.sendRedirect(request.getContextPath() + "/myProducts");
        
        } 
        // check for cancel button clicks
        else if (request.getParameter("cancel") != null) {
        
            response.sendRedirect(request.getContextPath() + "/myProducts");
        
        }
        else //onload set the editItem attribute to load modal
        {
            Item tempItem = new Item();
            HttpSession session = request.getSession(false);
            int updateId = (int) session.getAttribute("updateId");

            if (updateId != 0) {
                tempItem = access.getItemById(updateId);
                request.setAttribute("editItem", tempItem);
                System.out.println("");
            } else {
                response.sendRedirect(request.getContextPath() + "/Home"); //Home page}
            }
            request.getRequestDispatcher("edit.jsp").forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public boolean validateItemStatus(String status) {
        boolean updatedstatus;
        if (status.equals("Selling")) {
            updatedstatus = true;
        } else {
            updatedstatus = false;
        }
        return updatedstatus;
    }
}
