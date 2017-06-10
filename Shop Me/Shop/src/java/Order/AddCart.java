/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order;

import Order.Finalorder;
import Product.Item;
import Product.ItemDataAccess;
import customer.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class AddCart extends HttpServlet {

    ItemDataAccess access = new ItemDataAccess();
    ArrayList<Finalorder> cart;
    Item temp = new Item();
    Finalorder item = new Finalorder();
    Customer user = new Customer();
    String result = "";

    /* This function adds the item to the cart  */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        HttpSession session = request.getSession(false); //validate the session
        
        //check for  Add cart buttton click my Products page
        if ((request.getParameter("AddCart") != null) && (request.isRequestedSessionIdValid())) {
           
            user = (Customer) session.getAttribute("currentSessionUser");
            cart = (ArrayList<Finalorder>) session.getAttribute("cart");
            int itemid = Integer.parseInt(request.getParameter("AddCart").trim());
            temp = access.getItemById(itemid);
            
           // Add items to cart and update the database
            if (cart == null) {
                cart = new ArrayList<Finalorder>();
            }
            item = new Finalorder(itemid, temp.getItemname(), 1, temp.getItemprice(), user.id);
            cart.add(item);
            access.AddItemToCart(itemid);
        } else {
            cart = new ArrayList<Finalorder>();
        }
            
        session.setAttribute("cart", cart);
        response.sendRedirect(request.getContextPath() + "/Home"); //Home page   
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

}
