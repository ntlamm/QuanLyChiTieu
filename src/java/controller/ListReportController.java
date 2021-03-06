/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.CalculateDBContext;
import dal.GroupDBContext;
import dal.ReportDBContext;
import dal.TypeDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Group;
import model.List;
import model.Type;

/**
 *
 * @author Admin
 */
public class ListReportController extends HttpServlet {

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
        TypeDBContext tc = new TypeDBContext();
        ReportDBContext rc = new ReportDBContext();
        CalculateDBContext cc = new CalculateDBContext();
        GroupDBContext gc = new GroupDBContext();

        String raw_typeid = request.getParameter("typeid");
        raw_typeid = (raw_typeid == null || raw_typeid.isEmpty()) ? "-1" : raw_typeid;
        int id = Integer.parseInt(raw_typeid);

        int pagesize=10;
        String raw_page=request.getParameter("page");
        if(raw_page==null||raw_page.isEmpty()){
            raw_page="1";
        }
        int pageindex=Integer.parseInt(raw_page);
        int totalrecords = rc.countAll();
        int totalpage=(totalrecords%pagesize==0)?totalrecords/pagesize:(totalrecords/pagesize)+1;
        
        ArrayList<List> lists = rc.getlists(id,pageindex,pagesize);
        ArrayList<Type> types = tc.getTypes();
        ArrayList<Group> groups = gc.getGroups();
        int TotalGet = cc.getMoney(1);
        int TotalPay = cc.getMoney(2);
        int Total = TotalGet - TotalPay;
        
        request.setAttribute("totalpage", totalpage);
        request.setAttribute("pageindex", pageindex);
        request.setAttribute("types", types);
        request.setAttribute("lists", lists);
        request.setAttribute("groups", groups);
        request.setAttribute("typeid", id);
        request.setAttribute("TotalGet", TotalGet);
        request.setAttribute("TotalPay", TotalPay);
        request.setAttribute("Total", Total);
        request.getRequestDispatcher("view/report.jsp").forward(request, response);
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
