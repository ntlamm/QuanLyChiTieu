/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.List;
import model.Plan;
import model.Target;

/**
 *
 * @author Admin
 */
public class EditDBContext extends DBContext {

    public void EditRecord(List l) {
        String sql = "UPDATE [BaoCao]\n"
                + "   SET [cdate] = ?\n"
                + "      ,[cname] = ?\n"
                + "      ,[cprice] = ?\n"
                + "      ,[cnote] = ?\n"
                + "      ,[cgroupid] = ?\n"
                + "      ,[ctypeid] = ?\n"
                + " WHERE [cid] = ?";
        PreparedStatement ps = null;
        try {
            ps = connect.prepareStatement(sql);
            ps.setDate(1, l.getCdate());
            ps.setNString(2, l.getCname());
            ps.setInt(3, l.getCprice());
            ps.setNString(4, l.getCnote());
            ps.setInt(5, l.getGroup().getCgroupid());
            ps.setInt(6, l.getType().getCtypeid());
            ps.setInt(7, l.getCid());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EditDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EditDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EditDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void EditPlan(Plan l) {
        String sql = "UPDATE [Plan]\n"
                + "   SET [pdateF] = ?\n"
                + "      ,[cgroupid] = ?\n"
                + "      ,[pdateT] = ?\n"
                + "      ,[pprice] = ?\n"
                + "      ,[paypprice] = ?\n"
                + " WHERE [pid] = ?";
        PreparedStatement ps = null;
        try {
            ps = connect.prepareStatement(sql);
            ps.setDate(1, l.getFrom());
            ps.setInt(2, l.getGroup().getCgroupid());
            ps.setDate(3, l.getTo());
            ps.setInt(4, l.getPprice());
            ps.setInt(5, l.getPaypprice());
            ps.setInt(6, l.getPid());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EditDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EditDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EditDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    

    public void UpdateTarget(Target l) {
        String sql = "UPDATE [Target]\n"
                + "   SET [tname] = ?\n"
                + "      ,[from] = ?\n"
                + "      ,[to] = ?\n"
                + "      ,[tprice] = ?\n"
                + " WHERE [tid]= ?";
        PreparedStatement ps = null;
        try {
            ps = connect.prepareStatement(sql);
            ps.setNString(1, l.getTname());
            ps.setDate(2, l.getFrom());
            ps.setDate(3, l.getTo());
            ps.setInt(4, l.getTprice());
            ps.setInt(5, l.getTid());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EditDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EditDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EditDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
