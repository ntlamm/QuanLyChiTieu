/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Group;
import model.Plan;

/**
 *
 * @author Admin
 */
public class PlanDBContext extends DBContext{

    public ArrayList<Plan> getPlans() {
        ArrayList<Plan> plans = new ArrayList<>();
        try {
            String sql = "select a.pid,b.cgroupid,b.cgroupname,a.pdateF,a.pdateT,b.cgroupnote,a.pprice \n"
                    + "from [Plan] a join [Group] b on b.cgroupid=a.cgroupid";
            PreparedStatement stm = connect.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Plan d = new Plan();
                d.setPid(rs.getInt("pid"));
                d.setFrom(rs.getDate("pdateF"));
                d.setTo(rs.getDate("pdateT"));
                d.setPprice(rs.getInt("pprice"));               
                Group g = new Group();
                g.setCgroupid(rs.getInt("cgroupid"));
                g.setCgroupname(rs.getString("cgroupname"));
                g.setCgroupnote(rs.getString("cgroupnote"));
                d.setGroup(g);
                plans.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReportDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return plans;
    }

}
