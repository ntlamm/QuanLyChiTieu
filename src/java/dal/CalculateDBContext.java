/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Calculate;

/**
 *
 * @author Admin
 */
public class CalculateDBContext extends DBContext {
    
    public int getMoney(int id) {
        int money = 0;
        try {
            String sql = "select sum(cprice) as Total from BaoCao where ctypeid=? ";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                
                money = rs.getInt("Total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CalculateDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return money;
    }
    
    public int getPricePlan() {
        int price = 0;
        try {
            String sql = "select sum(pprice) as Total from [Plan]";
            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                price = rs.getInt("Total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CalculateDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return price;
    }
    
    public int getPricePay() {
        int price = 0;
        try {
            String sql = "select sum(paypprice) as Total from [Plan]";
            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                price = rs.getInt("Total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CalculateDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return price;
    }
    
    public int getMoneyInRange(Date from, Date to, int id) {
        int money = 0;
        try {
            String sql = "select sum(cprice) as Total from BaoCao where ctypeid=2 and cgroupid=? and cdate between ? and ?";
            PreparedStatement ps = connect.prepareStatement(sql);            
            ps.setInt(1, id);
            ps.setDate(2, from);
            ps.setDate(3, to);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                
                money = rs.getInt("Total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CalculateDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return money;
    }
    
    public int getPriceInRange(Date from, Date to,int id) {
        int money = 0;
        try {
            String sql = "select sum(cprice) as Total from BaoCao where ctypeid=? and cdate between ? and ?";
            PreparedStatement ps = connect.prepareStatement(sql);            
            ps.setInt(1, id);
            ps.setDate(2, from);
            ps.setDate(3, to);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                
                money = rs.getInt("Total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CalculateDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return money;
    }

    public int getDate(Date d) {
        int date = 0;
        try {
            String sql = "SELECT DATEDIFF(day,GETDATE(),?) AS DateDiff";
            PreparedStatement ps = connect.prepareStatement(sql);            
            ps.setDate(1, d);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                date = rs.getInt("DateDiff");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CalculateDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;
    }
    public int getDatePass(Date d) {
        int date = 0;
        try {
            String sql = "SELECT DATEDIFF(day,?,GETDATE()) AS DateDiff";
            PreparedStatement ps = connect.prepareStatement(sql);            
            ps.setDate(1, d);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                date = rs.getInt("DateDiff");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CalculateDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;
    }
    
}
