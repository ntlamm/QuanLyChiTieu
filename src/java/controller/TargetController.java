/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.CalculateDBContext;
import dal.EditDBContext;
import dal.GroupDBContext;
import dal.TargetDBContext;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Group;
import model.Target;

/**
 *
 * @author Admin
 */
public class TargetController extends HttpServlet {

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
        TargetDBContext pc = new TargetDBContext();
        CalculateDBContext cc = new CalculateDBContext();
        EditDBContext ec = new EditDBContext();
        GroupDBContext gc = new GroupDBContext();
        
        int pagesize=5;
        String raw_page=request.getParameter("page");
        if(raw_page==null||raw_page.isEmpty()){
            raw_page="1";
        }
        int pageindex=Integer.parseInt(raw_page);
        int totalrecords = pc.countAll();
        int totalpage=(totalrecords%pagesize==0)?totalrecords/pagesize:(totalrecords/pagesize)+1;
        
        ArrayList<Target> targets = pc.getTargets(pageindex,pagesize);
        
        for (Target target : targets) {
            int price = cc.getPriceInRange(target.getFrom(), target.getTo(), 1) - cc.getPriceInRange(target.getFrom(), target.getTo(), 2);
            if (price <= 0) {
                price = 0;
            }
            target.setPricesave(price);
            target.setDayleft(cc.getDate(target.getTo()));
        }
        ArrayList<Group> groups = gc.getGroups();
        
        request.setAttribute("groups", groups);
        request.setAttribute("totalpage", totalpage);
        request.setAttribute("pageindex", pageindex);
        request.setAttribute("targets", targets);
        request.getRequestDispatcher("view/target.jsp").forward(request, response);
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
