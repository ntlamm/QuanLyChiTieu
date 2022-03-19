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
public class PlanDBContext extends DBContext {

    public ArrayList<Plan> getPlans() {
        ArrayList<Plan> plans = new ArrayList<>();
        try {
            String sql = "select * from(select a.pid,b.cgroupid,b.cgroupname,a.pdateF,a.pdateT,b.cgroupnote,a.pprice,a.paypprice,\n"
                    + "ROW_NUMBER() OVER (ORDER BY a.pid ASC) as stt from [Plan] a join [Group] b on b.cgroupid=a.cgroupid) tb";
            PreparedStatement stm = connect.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Plan d = new Plan();
                d.setStt(rs.getInt("stt"));
                d.setPid(rs.getInt("pid"));
                d.setFrom(rs.getDate("pdateF"));
                d.setTo(rs.getDate("pdateT"));
                d.setPprice(rs.getInt("pprice"));
                d.setPaypprice(rs.getInt("paypprice"));
                Group g = new Group();
                g.setCgroupid(rs.getInt("cgroupid"));
                g.setCgroupname(rs.getString("cgroupname"));
                g.setCgroupnote(rs.getString("cgroupnote"));
                d.setGroup(g);
                plans.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlanDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return plans;
    }

    public ArrayList<Plan> getPlansByGid(int id) {
        ArrayList<Plan> plans = new ArrayList<>();
        try {
            String sql = "select a.pid,b.cgroupid,b.cgroupname,a.pdateF,a.pdateT,b.cgroupnote,a.pprice \n"
                    + "from [Plan] a join [Group] b on b.cgroupid=a.cgroupid where b.cgroupid =?";
            PreparedStatement stm = connect.prepareStatement(sql);
            stm.setInt(1, id);
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
            Logger.getLogger(PlanDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return plans;
    }

    public Plan getPlanByPid(int id) {
        try {
            String sql = "select a.pid,b.cgroupid,b.cgroupname,a.pdateF,a.pdateT,b.cgroupnote,a.pprice \n"
                    + "from [Plan] a join [Group] b on b.cgroupid=a.cgroupid where a.pid=?";
            PreparedStatement stm = connect.prepareStatement(sql);
            stm.setInt(1, id);
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
                return d;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlanDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
