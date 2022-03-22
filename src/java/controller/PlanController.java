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
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class PlanController extends HttpServlet {

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
        GroupDBContext gc = new GroupDBContext();
        PlanDBContext pc = new PlanDBContext();
        CalculateDBContext cc = new CalculateDBContext();
        EditDBContext ec = new EditDBContext();

        ArrayList<Group> groups = gc.getGroups();
        ArrayList<Plan> plans = pc.getPlans();
        int budget = cc.getPricePlan();

        for (Plan plan : plans) {
            plan.setPaypprice(cc.getMoneyInRange(plan.getFrom(), plan.getTo(), plan.getGroup().getCgroupid()));
            ec.EditPlan(plan);
        }
        
        ArrayList<Plan> plansUpdate = pc.getPlans();
        for (Plan plan : plansUpdate) {
            plan.setDayleft(cc.getDate(plan.getTo()));
            plan.setDaypass(cc.getDatePass(plan.getFrom()));
            if (plan.getDaypass() > cc.getDateBetween(plan.getFrom(), plan.getTo())) {
                plan.setDaypass(cc.getDateBetween(plan.getFrom(), plan.getTo()));
            }
        }
        int TotalPay = cc.getPricePay();

        request.setAttribute("TotalPay", TotalPay);
        request.setAttribute("budget", budget);
        request.setAttribute("groups", groups);
        request.setAttribute("plans", plansUpdate);
        request.getRequestDispatcher("view/plan.jsp").forward(request, response);
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
