/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.DAOOrder;
import dal.DAOProduct;
import entity.Account;
import entity.Item;
import entity.OrderItem;
import entity.Product;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author HP
 */
@WebServlet(name="CartServlet", urlPatterns={"/CartURL"})
public class CartServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //create constant ship price
        double shipPrice = 30000;
        DAOOrder d = new DAOOrder();
        DAOProduct dp = new DAOProduct();
        HttpSession session = request.getSession();
        String service = request.getParameter("Service");
        if(service == null) {
            request.getRequestDispatcher("views/Cart.jsp").forward(request, response);return;
        }
        //if add to cart check have cart exist before
        if(service.equals("addToCart")) {
            String pid_raw = request.getParameter("product_id");
            String key = "cart-" + pid_raw;
            String quantity_raw = request.getParameter("quantity");
            int pid = Integer.parseInt(pid_raw);
            int quantity = Integer.parseInt(quantity_raw);
            Product p = (Product)session.getAttribute(key);
            //IF DONT EXIST
            if(p == null) {
            Product p_root = dp.getProductById(pid);
            Product pAdd = new Product(
                    pid,
                    p_root.getProduct_name(),
                    p_root.getProduct_img(),
                    p_root.getList_price(),
                    p_root.getBrand(),
                    p_root.getCategory(),
                    quantity, p_root.getDiscount());
            session.setAttribute(key, pAdd);
            } else {
            //IF HAVE EXIST create a new p and set in old key
            Product pAdd = new Product(
                    pid,
                    p.getProduct_name(),
                    p.getProduct_img(),
                    p.getList_price(),
                    p.getBrand(),
                    p.getCategory(),
                    p.getQuantity()+quantity, p.getDiscount());
	    session.setAttribute(key, pAdd);
            }
            response.sendRedirect("CartURL"); return;
        }
        
        if(service.equals("addQuantity")) {
         String pid_raw = request.getParameter("product_id");
         int pid = Integer.parseInt(pid_raw);
         String key = "cart-" + pid_raw;
         Product p_root = dp.getProductById(pid);
         Product p = (Product)session.getAttribute(key);
         int quantity = 0;
            //IF DONT EXIST
            if(p != null) {
            if ((p.getQuantity() + 1) == p_root.getQuantity()) {
                    quantity = p_root.getQuantity();
            } else {
              quantity = p.getQuantity()+1;
            }
           // create a new p and set in old key
            Product pAdd = new Product(
                    pid,
                    p.getProduct_name(),
                    p.getProduct_img(),
                    p.getList_price(),
                    p.getBrand(),
                    p.getCategory(),
                    quantity, p.getDiscount()
            );
            session.setAttribute(key, pAdd);
            } 
           response.sendRedirect("CartURL");
        }
        if(service.equals("minusQuantity")) {
         String pid_raw = request.getParameter("product_id");
         int pid = Integer.parseInt(pid_raw);
         String key = "cart-" + pid_raw;
         Product p = (Product)session.getAttribute(key);
            //IF DONT EXIST
            if (p != null) {
                // create a new p and set in old key
                //check is delete
                if ((p.getQuantity() - 1) == 0) {
                    session.removeAttribute(key);
                } else {
                    Product pAdd = new Product(
                            pid,
                            p.getProduct_name(),
                            p.getProduct_img(),
                            p.getList_price(),
                            p.getBrand(),
                            p.getCategory(),
                            p.getQuantity() - 1, p.getDiscount()
                    );
                    session.setAttribute(key, pAdd);
                }
            }
          response.sendRedirect("CartURL");
        }
        
        if(service.equals("deleteInCart")) {
          String pid_raw = request.getParameter("product_id");
          String key = "cart-" + pid_raw;
          session.removeAttribute(key);
          response.sendRedirect("CartURL");
        }
        
        if (service.equals("checkout")) {
            Vector<Product> listItem = new Vector<>();
            Account acc = (Account) session.getAttribute("account");
            if(acc != null) {
            java.util.Enumeration em = session.getAttributeNames();
            while (em.hasMoreElements()) {
                //when get from session id is cart-id
                String id = em.nextElement().toString();
                if (id.startsWith("cart")) {
                    //add product into list before remove in session
                    Product pro_session = (Product) session.getAttribute(id);
                    //get product in database but the quantity is number want to order
                    Product pAdd = dp.getProductById(pro_session.getProduct_id());
                    pAdd.setQuantity(pro_session.getQuantity());
                    listItem.add(pAdd);
                    session.removeAttribute(id);
                }
            }
            if(listItem.size() > 0) {
              d.checkcount(acc, listItem);
            }
            response.sendRedirect("CartURL");
            } else {
             response.sendRedirect("login");
            }
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public static void main(String[] args) {
        DAOOrder dob = new DAOOrder();
        int newOrderId = dob .getAllOrders().get(dob .getAllOrders().size() - 1).getOrder_id() + 1;
        System.out.println(newOrderId);
    }
}
