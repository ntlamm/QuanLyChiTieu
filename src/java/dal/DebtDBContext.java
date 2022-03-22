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
import model.Debt;

/**
 *
 * @author Admin
 */
public class DebtDBContext extends DBContext {

    public ArrayList<Debt> getDebts() {
        ArrayList<Debt> debts = new ArrayList<>();
        try {
            String sql = "select * from(select *,\n"
                    + "ROW_NUMBER() OVER (ORDER BY debtid ASC) as stt from [Debt]) tb";
            PreparedStatement stm = connect.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Debt d = new Debt();
                d.setStt(rs.getInt("stt"));
                d.setDebtid(rs.getInt("debtid"));
                d.setDebtname(rs.getString("debtname"));
                d.setDebtdate(rs.getDate("debtdate"));
                d.setDebtprice(rs.getInt("debtprice"));
                d.setDebtpay(rs.getInt("debtpay"));
                d.setDebtleft(rs.getInt("debtleft"));
                debts.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlanDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return debts;
    }

    public Debt getDebt(int id) {
        try {
            String sql = "select * from Debt where debtid = ?";
            PreparedStatement stm = connect.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Debt d = new Debt();
                d.setDebtid(rs.getInt("debtid"));
                d.setDebtname(rs.getString("debtname"));
                d.setDebtdate(rs.getDate("debtdate"));
                d.setDebtprice(rs.getInt("debtprice"));
                d.setDebtpay(rs.getInt("debtpay"));
                d.setDebtleft(rs.getInt("debtleft"));
                return d;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlanDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int countAll() {
        try {
            String sql = "select count(*)as total from [Debt]";
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

    public ArrayList<Debt> getDebts(int pageindex, int pagesize) {
        ArrayList<Debt> debts = new ArrayList<>();
        try {
            String sql = "select * from(select *, "
                    + "ROW_NUMBER() OVER (ORDER BY debtid ASC) as stt from [Debt]) tb "
                    + "WHERE stt >=(?-1)*? +1 AND stt <= ? * ?";
            PreparedStatement stm = connect.prepareStatement(sql);
            stm.setInt(1, pageindex);
            stm.setInt(2, pagesize);
            stm.setInt(3, pageindex);
            stm.setInt(4, pagesize);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Debt d = new Debt();
                d.setStt(rs.getInt("stt"));
                d.setDebtid(rs.getInt("debtid"));
                d.setDebtname(rs.getString("debtname"));
                d.setDebtdate(rs.getDate("debtdate"));
                d.setDebtprice(rs.getInt("debtprice"));
                d.setDebtpay(rs.getInt("debtpay"));
                d.setDebtleft(rs.getInt("debtleft"));
                debts.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlanDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return debts;
    }
}
