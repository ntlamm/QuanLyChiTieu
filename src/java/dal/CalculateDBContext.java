/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

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
            String sql = "select sum(cprice) as Total from BaoCao a join Loai b on a.ctypeid=b.ctypeid where b.ctypeid=? ";
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
}
