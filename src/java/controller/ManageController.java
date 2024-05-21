/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.DAOBrand;
import dal.DAOCategory;
import dal.DAOProduct;
import entity.Account;
import entity.Brand;
import entity.Category;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

/**
 *
 * @author HP
 */
@WebServlet(name="ManageController", urlPatterns={"/ManageProduct"})
public class ManageController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
          PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
            DAOProduct d = new DAOProduct();
            long miliSeconds = System.currentTimeMillis();
            Date currentDate = new Date(miliSeconds);
            
        try {
            String service = request.getParameter("Service");
            if (service == null) {
                service = "getAll";
            }
             if (service.equals("getAll")) {
                Vector<Product> list = new Vector<>();
                list = d.getAllProduct("");
                request.setAttribute("listProduct", list);
                request.getRequestDispatcher("/views/Admin.jsp").forward(request, response);
            }
            if(service.equals("SearchProduct")) {
                int pid = -1;
                String pid_raw = request.getParameter("searchId");
                try {
                    pid = Integer.parseInt(pid_raw);
                } catch (Exception e) {
                    pid = -1;
                }
                Product p = d.getProductById(pid);
                Vector<Product> list = new Vector<>();
                if(p == null) {
                    request.setAttribute("mess", "Not found this product");
                    list = d.getAllProduct("");
                } else {
                    list.add(p);
                }
                request.setAttribute("listProduct", list);
                request.setAttribute("valueSearch", pid_raw);
                request.getRequestDispatcher("/views/Admin.jsp").forward(request, response);
            }
            
            if(service.equals("addProduct")) {
                String mess = "";
                String addBtn = request.getParameter("add");
                setCommonAttributes(request, d);
                //dieu huong toi trang add
                if(addBtn == null) {
                  request.getRequestDispatcher("/views/InsertProduct.jsp").forward(request, response);
                } else {  
                //thuc hien insert du lieu
                  String proName = request.getParameter("productName");
                  String proImage = request.getParameter("productImage");
                  //update not have value in input
                  if(proImage.equals("") || proImage == null) {
                    proImage = request.getParameter("beforeImage");
                  }
                  String categoryId_raw = request.getParameter("category");
                  String brand_raw = request.getParameter("brand");
                  String pro_price = request.getParameter("pro_price");
                  String discount_raw = request.getParameter("discount");
                  String productDesc = request.getParameter("productDesc");
                  String quantity_raw = request.getParameter("quantity");

                  int discount = Integer.parseInt(discount_raw);
                  int brandId = Integer.parseInt(brand_raw);
                  int catId = Integer.parseInt(categoryId_raw);
                  int quantity = Integer.parseInt(quantity_raw);
                  double proPrice = Double.parseDouble(pro_price);
                  //will get last id
                  int prId = d.getAllProduct("").get(d.getAllProduct("").size()-1).getProduct_id()+1;
                  Product pro = new Product(prId, catId, brandId, discount, proName, proImage, productDesc, proPrice, currentDate, quantity);
                  d.addProduct(pro);
                  response.sendRedirect("ManageProduct");
                }
            }
            
           
            if (service.equals("Delete")) {
                String pid_raw = request.getParameter("pid");
                int pid = Integer.parseInt(pid_raw);
                int rs = d.deleteProduct(pid);
                String mess;
                if(rs == 0) {
                  mess = "Delete success";
                } else {
                  mess = "Delete Success";
                }
                request.setAttribute("mess", mess);
                response.sendRedirect("ManageProduct");
            }
         if (service.equals("Update")) {
                //check is direct or update
                String submit = request.getParameter("Submit");
                if(submit != null) {
                  String proId_raw = request.getParameter("productId");
                  String proName = request.getParameter("productName");
                  String proImage = request.getParameter("productImage");
                  //update not have value in input
                  if(proImage.equals("") || proImage == null) {
                    proImage = request.getParameter("beforeImage");
                  }
                  String categoryId_raw = request.getParameter("category");
                  String brand_raw = request.getParameter("brand");
                  String pro_price = request.getParameter("price");
                  String discount_raw = request.getParameter("discount");
                  String productDesc = request.getParameter("productDesc");
                  String quantity_raw = request.getParameter("quantity");

                  int discount = Integer.parseInt(discount_raw);
                  int brandId = Integer.parseInt(brand_raw);
                  int catId = Integer.parseInt(categoryId_raw);
                  int proId = Integer.parseInt(proId_raw);
                  int quantity = Integer.parseInt(quantity_raw);
                  double proPrice = Double.parseDouble(pro_price);
                  Product pro = new Product(proId, catId, brandId, discount, proName, proImage, productDesc, proPrice, currentDate, quantity);
                  d.updateProduct(pro);
                  request.setAttribute("mess", "update success");
                  response.sendRedirect("ManageProduct");
               } else {
               String pid_raw = request.getParameter("pid");
               int pid = Integer.parseInt(pid_raw);
               Product pro = d.getProductById(pid);
               request.setAttribute("product", pro);
               setCommonAttributes(request, d);
               request.getRequestDispatcher("/views/UpdateProduct.jsp").forward(request, response);
               }
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
          
    } 
   public String getFormatDate() {
        LocalDateTime myDateObj = LocalDateTime.now();  
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        String formattedDate = myDateObj.format(myFormatObj);  
        return formattedDate;
   }
private void setCommonAttributes(HttpServletRequest request, DAOProduct d) throws SQLException {
        DAOCategory dCat = new DAOCategory();
        DAOBrand dbrand = new DAOBrand();
        Vector<Brand> list_brand = dbrand.getAllBrand();
        Vector<Category> list_category = dCat.getAllCategory();
        int[] Listdiscount = {1, 10, 20, 30, 40};
        request.setAttribute("listBrand", list_brand);
        request.setAttribute("listCategory", list_category);
        request.setAttribute("ListDiscount", Listdiscount);
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
            HttpSession session = request.getSession();
            Account acc = (Account)session.getAttribute("account");
            if(acc != null) {
             if(acc.getIs_admin()) {
              processRequest(request, response);
             } else {
              response.sendRedirect("ProductURL");
             }
            } else {
             response.sendRedirect("login");
            }
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


    public static void main(String[] args) throws SQLException {
       
    }
    
}
