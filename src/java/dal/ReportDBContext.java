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
import model.Type;
import model.List;

/**
 *
 * @author Sap-lap
 */
public class ReportDBContext extends DBContext {

    public ArrayList<List> getlists(int typeid) {
        ArrayList<List> lists = new ArrayList<>();
        try {
            String sql = "select a.cid,a.cdate,a.cname,a.cprice,a.cnote,a.cgroupid,c.cgroupname,a.ctypeid,b.ctypename \n"
                    + "                    from BaoCao a join Loai b on a.ctypeid=b.ctypeid join [Group] c on a.cgroupid=c.cgroupid";
            if (typeid > -1) {
                sql += " where a.ctypeid = ?";
            }
            PreparedStatement stm = connect.prepareStatement(sql);
            if (typeid > -1) {
                stm.setInt(1, typeid);
            }
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                List d = new List();
                d.setCid(rs.getInt("cid"));
                d.setCdate(rs.getDate("cdate"));
                d.setCname(rs.getString("cname"));
                d.setCprice(rs.getInt("cprice"));
                d.setCnote(rs.getString("cnote"));
                Type l = new Type();
                l.setCtypeid(rs.getInt("ctypeid"));
                l.setCtypename(rs.getString("ctypename"));
                d.setType(l);
                Group g = new Group();
                g.setCgroupid(rs.getInt("cgroupid"));
                g.setCgroupname(rs.getString("cgroupname"));
                d.setGroup(g);
                lists.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReportDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lists;
    }

    public ArrayList<List> getlists() {
        ArrayList<List> lists = new ArrayList<>();
        try {
            String sql = "select a.cid,a.cdate,a.cname,a.cprice,a.cnote,a.cgroupid,c.cgroupname,a.ctypeid,b.ctypename \n"
                    + "from BaoCao a join Loai b on a.ctypeid=b.ctypeid join [Group] c on a.cgroupid=c.cgroupid";
            PreparedStatement stm = connect.prepareStatement(sql);           
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                List d = new List();
                d.setCid(rs.getInt("cid"));
                d.setCdate(rs.getDate("cdate"));
                d.setCname(rs.getString("cname"));
                d.setCprice(rs.getInt("cprice"));
                d.setCnote(rs.getString("cnote"));
                Type l = new Type();
                l.setCtypeid(rs.getInt("ctypeid"));
                l.setCtypename(rs.getString("ctypename"));
                d.setType(l);
                Group g = new Group();
                g.setCgroupid(rs.getInt("cgroupid"));
                g.setCgroupname(rs.getString("cgroupname"));
                d.setGroup(g);
                lists.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReportDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lists;
    }

    public List getRc(int cid) {
        try {
            String sql = "select a.cid,a.cdate,a.cname,a.cprice,a.cnote,a.cgroupid,c.cgroupname,a.ctypeid,b.ctypename \n"
                    + "from BaoCao a join Loai b on a.ctypeid=b.ctypeid join [Group] c on a.cgroupid=c.cgroupid "
                    + "where a.cid=?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, cid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                List l = new List();
                l.setCid(rs.getInt("cid"));
                l.setCdate(rs.getDate("cdate"));
                l.setCname(rs.getString("cname"));
                l.setCprice(rs.getInt("cprice"));
                l.setCnote(rs.getString("cnote"));
                Type t = new Type();
                Group g = new Group();
                t.setCtypeid(rs.getInt("ctypeid"));
                t.setCtypename(rs.getString("ctypename"));
                l.setType(t);
                g.setCgroupid(rs.getInt("cgroupid"));
                g.setCgroupname(rs.getString("cgroupname"));
                l.setGroup(g);
                return l;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReportDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
