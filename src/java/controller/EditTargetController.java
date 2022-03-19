/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.EditDBContext;
import dal.TargetDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Target;

/**
 *
 * @author Admin
 */
public class EditTargetController extends HttpServlet {

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
            out.println("<title>Servlet EditTargetController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditTargetController at " + request.getContextPath() + "</h1>");
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
        TargetDBContext pc = new TargetDBContext();

        int id = Integer.parseInt(request.getParameter("id"));
        Target target = pc.getTarget(id);
        
        request.setAttribute("target", target);
        request.getRequestDispatcher("view/edittarget.jsp").forward(request, response);
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

        String raw_tid = request.getParameter("tid");
        String raw_tname = request.getParameter("tname"); 
        String raw_from = request.getParameter("from");
        String raw_to = request.getParameter("to");
        String raw_tprice = request.getParameter("tprice");
           
        int tid = Integer.parseInt(raw_tid);
        int tprice = Integer.parseInt(raw_tprice);
        Date from = Date.valueOf(raw_from);
        Date to = Date.valueOf(raw_to);
        String tname = raw_tname; 
        
        Target l = new Target();
        l.setTid(tid);
        l.setFrom(from);
        l.setTo(to);
        l.setTprice(tprice);
        l.setTname(tname);
        
        EditDBContext ec = new EditDBContext();
        ec.UpdateTarget(l);
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
