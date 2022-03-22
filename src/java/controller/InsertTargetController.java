/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.CalculateDBContext;
import dal.GroupDBContext;
import dal.InsertDBContext;
import dal.PlanDBContext;
import dal.ReportDBContext;
import dal.TargetDBContext;
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
import model.Target;
import model.Type;

/**
 *
 * @author Admin
 */
public class InsertTargetController extends BaseAuthenticationController {

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
            out.println("<title>Servlet InsertTargetController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InsertTargetController at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("view/inserttarget.jsp").forward(request, response);
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

        String raw_tname = request.getParameter("tname");
        String raw_from = request.getParameter("from");
        String raw_to = request.getParameter("to");
        String raw_tprice = request.getParameter("tprice");

        int tprice = Integer.parseInt(raw_tprice);
        Date from = Date.valueOf(raw_from);
        Date to = Date.valueOf(raw_to);
        String tname = raw_tname;

        TargetDBContext  pc = new TargetDBContext();
        ArrayList<Target> targets = pc.getTargets();
        int id = 0;
        if (targets.isEmpty()) {
            id = 1;
        } else {
            id = targets.get(targets.size() - 1).getTid()+ 1;
        }

        Target l = new Target();
        l.setTid(id);
        l.setFrom(from);
        l.setTo(to);
        l.setTprice(tprice);
        l.setTname(tname);

        InsertDBContext ic = new InsertDBContext();
        ic.InsertTarget(l);
        response.sendRedirect("muctieu");
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
