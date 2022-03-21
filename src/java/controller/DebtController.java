/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.CalculateDBContext;
import dal.DebtDBContext;
import dal.EditDBContext;
import dal.GroupDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Debt;
import model.Group;

/**
 *
 * @author Admin
 */
public class DebtController extends HttpServlet {

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
        DebtDBContext dc = new DebtDBContext();
        EditDBContext ec = new EditDBContext();
        GroupDBContext gc =new GroupDBContext();
        CalculateDBContext cc = new CalculateDBContext();
         
        int priceLeft = cc.getPriceLeft();
        
        int pagesize=10;
        String raw_page=request.getParameter("page");
        if(raw_page==null||raw_page.isEmpty()){
            raw_page="1";
        }
        int pageindex=Integer.parseInt(raw_page);
        int totalrecords = dc.countAll();
        int totalpage=(totalrecords%pagesize==0)?totalrecords/pagesize:(totalrecords/pagesize)+1;
        
        ArrayList<Debt> debts = dc.getDebts(pageindex,pagesize);
        ArrayList<Group> groups = gc.getGroups();
        for (Debt debt : debts) {
            int left = debt.getDebtprice() - debt.getDebtpay();
            if (left >= 0) {
                debt.setDebtleft(left);
            }
            ec.UpdateDebt(debt);
        }
        ArrayList<Debt> debtsUpdate = dc.getDebts();
        
        request.setAttribute("totalleft", priceLeft);
        request.setAttribute("totalpage", totalpage);
        request.setAttribute("pageindex", pageindex);
        request.setAttribute("groups", groups);
        request.setAttribute("debts", debtsUpdate);
        request.getRequestDispatcher("view/debt.jsp").forward(request, response);
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
