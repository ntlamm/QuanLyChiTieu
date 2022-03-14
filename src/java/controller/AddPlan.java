/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.GroupDBContext;
import dal.InsertDBContext;
import dal.PlanDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Group;
import model.Plan;

/**
 *
 * @author Admin
 */
public class AddPlan extends HttpServlet {

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
            out.println("<title>Servlet AddPlan</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddPlan at " + request.getContextPath() + "</h1>");
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
        GroupDBContext gc = new GroupDBContext();

        int id = Integer.parseInt(request.getParameter("id"));
        ArrayList<Group> groups = gc.getGroups();

        request.setAttribute("id", id);
        request.setAttribute("groups", groups);
        request.getRequestDispatcher("view/addplan.jsp").forward(request, response);
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
        String raw_from = request.getParameter("from");
        String raw_to = request.getParameter("to");
        String raw_cgroupid = request.getParameter("cgroupid");
        String raw_pprice = request.getParameter("pprice");

        Date dateF = Date.valueOf(raw_from);
        Date dateT = Date.valueOf(raw_to);
        int cgroupid = Integer.parseInt(raw_cgroupid);
        int pprice = Integer.parseInt(raw_pprice);
        
        PlanDBContext pc = new PlanDBContext();
        ArrayList<Plan> plans = pc.getPlans();
        int id = 0;
        if(plans.isEmpty()){
           id = 1;
        } else {
            id = plans.get(plans.size() - 1).getPid()+ 1;
        }
        
        Group g = new Group();
        g.setCgroupid(cgroupid);
        
        Plan p = new Plan();
        p.setFrom(dateF);
        p.setTo(dateT);
        p.setPid(id);
        p.setPprice(pprice);
        p.setGroup(g);
        
        InsertDBContext ic = new InsertDBContext();
        ic.InsertPlan(p);
        response.sendRedirect("kehoach");
        
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
