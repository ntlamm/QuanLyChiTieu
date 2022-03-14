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

/**
 *
 * @author Admin
 */
public class InsertDBContext extends DBContext {

    public void insertRecord(List l) {
        String sql = "INSERT INTO [BaoCao]\n"
                + "           ([cid]\n"
                + "           ,[cdate]\n"
                + "           ,[cname]\n"
                + "           ,[cprice]\n"
                + "           ,[cnote]\n"
                + "           ,[cgroupid]\n"
                + "           ,[ctypeid])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        PreparedStatement ps = null;
        try {
            ps = connect.prepareStatement(sql);
            ps.setInt(1, l.getCid());
            ps.setDate(2, l.getCdate());
            ps.setNString(3, l.getCname());
            ps.setInt(4, l.getCprice());
            ps.setNString(5, l.getCnote());
            ps.setInt(7, l.getGroup().getCgroupid());
            ps.setInt(6, l.getType().getCtypeid());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(InsertDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(InsertDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(InsertDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void InsertPlan(Plan l) {
        String sql = "INSERT INTO [Plan]\n"
                + "           ([pid]\n"
                + "           ,[cgroupid]\n"
                + "           ,[pdateF]\n"
                + "           ,[pdateT]\n"
                + "           ,[pprice])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        PreparedStatement ps = null;
        try {
            ps = connect.prepareStatement(sql);
            ps.setInt(1, l.getPid());
            ps.setInt(2, l.getGroup().getCgroupid());
            ps.setDate(3, l.getFrom());
            ps.setDate(4, l.getTo());
            ps.setInt(5, l.getPprice());            

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(InsertDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(InsertDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(InsertDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
