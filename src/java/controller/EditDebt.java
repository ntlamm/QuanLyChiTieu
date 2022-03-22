/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.DebtDBContext;
import dal.EditDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Debt;


/**
 *
 * @author Admin
 */
public class EditDebt extends BaseAuthenticationController {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditDebt</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditDebt at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DebtDBContext pc = new DebtDBContext();

        int id = Integer.parseInt(request.getParameter("id"));
        Debt debt = pc.getDebt(id);
        
        request.setAttribute("debt", debt);
        request.getRequestDispatcher("view/editdebt.jsp").forward(request, response);
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
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        String raw_id = request.getParameter("id");
        String raw_name = request.getParameter("name"); 
        String raw_date= request.getParameter("date");
        String raw_pay = request.getParameter("pay");
        String raw_price = request.getParameter("price");
           
        int id = Integer.parseInt(raw_id);
        int price = Integer.parseInt(raw_price);
        int pay = Integer.parseInt(raw_pay);
        Date date = Date.valueOf(raw_date);
        String name = raw_name; 
        
        Debt l = new Debt();
        l.setDebtid(id);
        l.setDebtdate(date);
        l.setDebtpay(pay);
        l.setDebtprice(price);
        l.setDebtname(name);
        
        EditDBContext ec = new EditDBContext();
        ec.UpdateDebt(l);
        response.sendRedirect("sono");
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
