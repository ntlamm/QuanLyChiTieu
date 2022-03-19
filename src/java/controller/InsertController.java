/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.EditDBContext;
import dal.GroupDBContext;
import dal.InsertDBContext;
import dal.ReportDBContext;
import dal.TypeDBContext;
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
import model.Type;

/**
 *
 * @author Admin
 */
public class InsertController extends BaseAuthenticationController {

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
            out.println("<title>Servlet InsertController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InsertController at " + request.getContextPath() + "</h1>");
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
        TypeDBContext tc = new TypeDBContext();
        GroupDBContext gc = new GroupDBContext();

        ArrayList<Group> groups = gc.getGroups();
        ArrayList<Type> types = tc.getTypes();

        request.setAttribute("types", types);
        request.setAttribute("groups", groups);
        request.getRequestDispatcher("view/insert.jsp").forward(request, response);
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

        ReportDBContext rc = new ReportDBContext();

        ArrayList<List> lists = rc.getlists();
        int id = 0;
        if (lists.isEmpty()) {
            id = 1;
        } else {
            id = lists.get(lists.size() - 1).getCid() + 1;
        }
        String raw_cdate = request.getParameter("cdate");
        String raw_cname = request.getParameter("cname");
        String raw_cprice = request.getParameter("cprice");
        String raw_cnote = request.getParameter("cnote");
        String raw_ctypeid = request.getParameter("ctypeid");
        String raw_cgroupid = request.getParameter("cgroupid");

        int cgroupid = Integer.parseInt(raw_cgroupid);
        int ctypeid = Integer.parseInt(raw_ctypeid);
        int cprice = Integer.parseInt(raw_cprice);
        String cname = raw_cname;
        String cnote = raw_cnote;
        Date cdate = Date.valueOf(raw_cdate);

        Type t = new Type();
        t.setCtypeid(ctypeid);
        Group g = new Group();
        g.setCgroupid(cgroupid);
        List l = new List();
        l.setCid(id);
        l.setCdate(cdate);
        l.setCname(cname);
        l.setCnote(cnote);
        l.setCprice(cprice);
        l.setType(t);
        l.setGroup(g);

        InsertDBContext ic = new InsertDBContext();
        ic.insertRecord(l);
        response.sendRedirect("baocao");
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
