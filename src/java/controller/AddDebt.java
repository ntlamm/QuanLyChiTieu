/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.DebtDBContext;
import dal.InsertDBContext;
import dal.TargetDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Debt;

/**
 *
 * @author Admin
 */
public class AddDebt extends HttpServlet {

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
            out.println("<title>Servlet AddDebt</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddDebt at " + request.getContextPath() + "</h1>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("view/adddebt.jsp").forward(request, response);
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        String raw_name = request.getParameter("name");
        String raw_date = request.getParameter("date");
        String raw_price = request.getParameter("price");
        String raw_pay = request.getParameter("pay");

        int price = Integer.parseInt(raw_price);
        int pay = Integer.parseInt(raw_pay);
        Date date = Date.valueOf(raw_date);      
        String name = raw_name;

        DebtDBContext  pc = new DebtDBContext();
        ArrayList<Debt> debts = pc.getDebts();
        int id = 0;
        if (debts.isEmpty()) {
            id = 1;
        } else {
            id = debts.get(debts.size() - 1).getDebtid()+ 1;
        }

        Debt l = new Debt();
        l.setDebtid(id);
        l.setDebtdate(date);
        l.setDebtname(name);
        l.setDebtprice(price);
        l.setDebtpay(pay);

        InsertDBContext ic = new InsertDBContext();
        ic.InsertDebt(l);
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
