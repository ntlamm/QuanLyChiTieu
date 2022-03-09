/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.EditDBContext;
import dal.GroupDBContext;
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
public class EditController extends BaseAuthenticationController {

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
            out.println("<title>Servlet EditController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditController at " + request.getContextPath() + "</h1>");
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
        ReportDBContext rc = new ReportDBContext();

        int id = Integer.parseInt(request.getParameter("id"));
        List Rc = rc.getRc(id);
        ArrayList<Type> types = tc.getTypes();
        ArrayList<Group> groups = gc.getGroups();

        request.setAttribute("Rc", Rc);
        request.setAttribute("types", types);
        request.setAttribute("groups", groups);
        request.getRequestDispatcher("view/edit.jsp").forward(request, response);
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
        
        String raw_cgroupid = request.getParameter("cgroupid");
        String raw_cid = request.getParameter("cid");
        String raw_ctypeid = request.getParameter("ctypeid");
        String raw_cname = request.getParameter("cname");
        String raw_cdate = request.getParameter("cdate");
        String raw_cnote = request.getParameter("cnote");
        String raw_cprice = request.getParameter("cprice");

        
        int cid = Integer.parseInt(raw_cid);
        int ctypeid = Integer.parseInt(raw_ctypeid);
        int cgroupid = Integer.parseInt(raw_cgroupid);
        int cprice = Integer.parseInt(raw_cprice);
        String cname = raw_cname;
        String cnote = raw_cnote;
        Date cdate = Date.valueOf(raw_cdate);

        Type t = new Type();
        t.setCtypeid(ctypeid);
        Group g = new Group();
        g.setCgroupid(cgroupid);
        List l = new List();
        l.setCid(cid);
        l.setCdate(cdate);
        l.setCname(cname);
        l.setCnote(cnote);
        l.setCprice(cprice);
        l.setType(t);
        l.setGroup(g);
        
        EditDBContext ec = new EditDBContext();
        ec.EditRecord(l);
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
