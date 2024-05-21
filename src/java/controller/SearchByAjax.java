///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
// */
//package controller;
//
//import dal.DAO;
//import entity.Product;
//import java.io.IOException;
//import java.io.PrintWriter;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import java.util.Vector;
//
///**
// *
// * @author HP
// */
//@WebServlet(name = "SearchByAjax", urlPatterns = {"/SearchByAjax"})
//public class SearchByAjax extends HttpServlet {
//
//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        request.setCharacterEncoding("UTF-8");
//        String txtSearch = request.getParameter("txt");
//        DAO d = new DAO();
////        Vector<Product> list = d.searchByName(txtSearch);
//        PrintWriter out = response.getWriter();
//        for (Product product : list) {
//            out.println("<div class=\"col-sm-6 col-md-4 col-lg-3\">\n"
//                    + "                                    <a href=\"#\" class=\"d-block h-100 product-item text-decoration-none position-relative\">\n"
//                    + "                                        <div class=\"boder-radius-3 position-relative overflow-hidden\">\n"
//                    + "                                            <img src=\"./images/"+product.getProduct_img()+"\" alt=\"\" class=\"overflow-hidden\">\n"
//                    + "                                            <div class=\"d-flex justify-content-center align-items-center px-3 button-products\">\n"
//                    + "                                                <button class=\"button-product me-3\">\n"
//                    + "                                                    <i class='bx bx-shopping-bag'></i> \n"
//                    + "                                                    &ensp; Add to cart\n"
//                    + "                                                </button>\n"
//                    + "                                                <button class=\"button-product me-3\">\n"
//                    + "                                                    <i class=\"fa-solid fa-arrows-up-down-left-right\"></i>\n"
//                    + "                                                    &ensp; Qick view\n"
//                    + "                                                </button>\n"
//                    + "                                            </div>\n"
//                    + "                                            <div class=\"product-sale\">\n"
//                    + "                                                <span class=\"product-sale-percent\">"+product.getSale_percent()+"%</span>\n"
//                    + "                                                <span class=\"product-sale-label\">Giảm</span>\n"
//                    + "                                            </div>\n"
//                    + "                                        </div>\n"
//                    + "                                        <div class=\"p-4 d-flex flex-column\">\n"
//                    + "                                            <h3 class=\"fw-bold text-black product-title\">"+product.getProduct_name()+"</h3>\n"
//                    + "                                            <div class=\"flex-fill mt-auto\">\n"
//                    + "                                                <p class=\"fs-4 product-des\">"+product.getProduct_type()+"</p>\n"
//                    + "                                                <div class=\"\">\n"
//                    + "                                                    <p class=\"text-decoration-line-through text-black fs-4\">"+product.getProduct_price()+"₫</p>\n"
//                    + "                                                </div>\n"
//                    + "                                                <div class=\"d-flex align-items-center justify-content-between mt-4\">\n"
//                    + "                                                    <span class=\"product-price\">"+(product.getProduct_price() - (product.getProduct_price() * product.getSale_percent()/100))+"₫</span>\n"
//                    + "                                                    <div class=\"d-flex align-items-center\">\n"
//                    + "                                                        <i class=\"fa-solid fa-star text-warning me-3\"></i>\n"
//                    + "                                                        <h4 class=\"m-0 product-preview\">4.9(98 reviews)</h4>\n"
//                    + "                                                    </div>\n"
//                    + "                                                </div>\n"
//                    + "                                            </div>\n"
//                    + "                                        </div>\n"
//                    + "                                    </a>\n"
//                    + "                                </div>");
//        }
//
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//    public static void main(String[] args) {
//        DAO d = new DAO();
//        Vector<Product> list = d.searchByName("a");
//        for (Product product : list) {
//            System.out.println(product);
//        }
//    }
//}
