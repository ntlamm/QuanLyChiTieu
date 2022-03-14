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
}
