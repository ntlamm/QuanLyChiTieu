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
import model.Target;

/**
 *
 * @author Admin
 */
public class TargetDBContext extends DBContext {

    public ArrayList<Target> getTargets(int pageindex, int pagesize) {
        ArrayList<Target> targets = new ArrayList<>();
        try {
            String sql = "select * from (select tid,tname,[from],[to],tprice, "
                    + "ROW_NUMBER() OVER (ORDER BY tid ASC) as stt from target) tb "
                    + "WHERE stt >=(?-1)* ? +1 AND stt <= ? * ?";
            PreparedStatement stm = connect.prepareStatement(sql);
            stm.setInt(1, pageindex);
            stm.setInt(2, pagesize);
            stm.setInt(3, pageindex);
            stm.setInt(4, pagesize);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Target d = new Target();
                d.setStt(rs.getInt("stt"));
                d.setTid(rs.getInt("tid"));
                d.setTname(rs.getString("tname"));
                d.setTo(rs.getDate("to"));
                d.setFrom(rs.getDate("from"));
                d.setTprice(rs.getInt("tprice"));
                targets.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TargetDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return targets;
    }

    public ArrayList<Target> getTargets() {
        ArrayList<Target> targets = new ArrayList<>();
        try {
            String sql = "select * from (select tid,tname,[from],[to],tprice, "
                    + "ROW_NUMBER() OVER (ORDER BY tid ASC) as stt from target) tb ";
            PreparedStatement stm = connect.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Target d = new Target();
                d.setStt(rs.getInt("stt"));
                d.setTid(rs.getInt("tid"));
                d.setTname(rs.getString("tname"));
                d.setTo(rs.getDate("to"));
                d.setFrom(rs.getDate("from"));
                d.setTprice(rs.getInt("tprice"));
                targets.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TargetDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return targets;
    }

    public Target getTarget(int id) {
        try {
            String sql = "select tid,tname,[from],[to],tprice from target where tid=?";
            PreparedStatement stm = connect.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Target d = new Target();
                d.setTid(rs.getInt("tid"));
                d.setTname(rs.getString("tname"));
                d.setTo(rs.getDate("to"));
                d.setFrom(rs.getDate("from"));
                d.setTprice(rs.getInt("tprice"));
                return d;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TargetDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int countAll() {
        try {
            String sql = "select count(*)as total from [Target]";
            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReportDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
}
