/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order;

import Order.Finalorder;
import Order.OrderDataAccess;
import Product.Item;
import Product.ItemDataAccess;
import customer.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
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
public class CheckOut extends HttpServlet {

    ItemDataAccess access = new ItemDataAccess();
    OrderDataAccess orderacess = new OrderDataAccess();
    ArrayList<Finalorder> cart;
    Item temp = new Item();
    Finalorder item = new Finalorder();
    Customer user = new Customer();
    String result = "";

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

        HttpSession session = request.getSession(false);
        
        //check for cart remove button clicks
        if ((request.getParameter("deleteCart") != null) && (request.isRequestedSessionIdValid())) {
            
            //delete item from session and update database
            int id = Integer.parseInt(request.getParameter("deleteCart"));
            cart = (ArrayList<Finalorder>) session.getAttribute("cart");
            for (Finalorder citem : cart) {
                if (citem.getItemid() == id) {
                    cart.remove(citem);
                    access.RemoveItemFromCart(citem.getItemid());
                    break;
                }
            }
            response.sendRedirect(request.getContextPath() + "/Home");
        } 
        //check for check out button clicks shopping cart modal
        else if (request.getParameter("checkout") != null) {
            
            //update db and clear the shopping cart
            user = (Customer) session.getAttribute("currentSessionUser");
            cart = (ArrayList<Finalorder>) session.getAttribute("cart");
            if(cart != null){
                orderacess.addItemsToOrder(cart, user);
            
            cart.clear();
            session.setAttribute("cart", cart);
            request.getRequestDispatcher("OrderFinalised.jsp").forward(request, response);}
            else{
              response.sendRedirect( request.getContextPath()+"/Home"); //Home page 
            }
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

    public void removeFromCart(int id) {

    }
}
