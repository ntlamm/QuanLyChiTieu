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
import model.Debt;
import model.List;
import model.Plan;
import model.Target;

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
                + "           ,[pprice]\n"
                + "           ,[paypprice])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
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
            ps.setInt(6, l.getPaypprice());

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

    public void InsertTarget(Target l) {
        String sql = "INSERT INTO [Target]\n"
                + "           ([tid]\n"
                + "           ,[tname]\n"
                + "           ,[from]\n"
                + "           ,[to]\n"
                + "           ,[tprice])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        PreparedStatement ps = null;
        try {
            ps = connect.prepareStatement(sql);
            ps.setInt(1, l.getTid());
            ps.setNString(2, l.getTname());
            ps.setDate(3, l.getFrom());
            ps.setDate(4, l.getTo());
            ps.setInt(5, l.getTprice());

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

    public void InsertDebt(Debt l) {
        String sql = "INSERT INTO [Debt]\n"
                + "           ([debtid]\n"
                + "           ,[debtname]\n"
                + "           ,[debtprice]\n"
                + "           ,[debtpay]\n"
                + "           ,[debtleft]\n"
                + "           ,[debtdate])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        PreparedStatement ps = null;
        try {
            ps = connect.prepareStatement(sql);
            ps.setInt(1, l.getDebtid());
            ps.setNString(2, l.getDebtname());
            ps.setInt(3, l.getDebtprice());
            ps.setInt(4, l.getDebtpay());
            ps.setInt(5, l.getDebtleft());
            ps.setDate(6, l.getDebtdate());
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
