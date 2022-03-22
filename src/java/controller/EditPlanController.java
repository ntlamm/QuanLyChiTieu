/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.CalculateDBContext;
import dal.EditDBContext;
import dal.GroupDBContext;
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
import model.List;
import model.Plan;
import model.Type;

/**
 *
 * @author Admin
 */
public class EditPlanController extends BaseAuthenticationController {

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
            out.println("<title>Servlet EditPlan</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditPlan at " + request.getContextPath() + "</h1>");
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
        GroupDBContext gc = new GroupDBContext();
        PlanDBContext pc = new PlanDBContext();

        int id = Integer.parseInt(request.getParameter("id"));
        ArrayList<Group> groups = gc.getGroups();
        Plan plan = pc.getPlanByPid(id);

        request.setAttribute("groups", groups);
        request.setAttribute("plan", plan);
        request.getRequestDispatcher("view/editplan.jsp").forward(request, response);
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

        String raw_pid = request.getParameter("pid");
        String raw_cgroupid = request.getParameter("cgroupid");
        String raw_from = request.getParameter("from");
        String raw_to = request.getParameter("to");
        String raw_pprice = request.getParameter("pprice");
        
        int cgroupid = Integer.parseInt(raw_cgroupid);
        int pid = Integer.parseInt(raw_pid);
        int pprice = Integer.parseInt(raw_pprice);
        Date from = Date.valueOf(raw_from);
        Date to = Date.valueOf(raw_to);
        CalculateDBContext cc = new CalculateDBContext();
        int moneyInRange = cc.getMoneyInRange(from, to, cgroupid);
        
        Group g = new Group();
        g.setCgroupid(cgroupid);
        Plan l = new Plan();
        l.setGroup(g);
        l.setPid(pid);
        l.setFrom(from);
        l.setTo(to);
        l.setPprice(pprice);
        l.setPaypprice(moneyInRange);

        EditDBContext ec = new EditDBContext();
        ec.EditPlan(l);
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
