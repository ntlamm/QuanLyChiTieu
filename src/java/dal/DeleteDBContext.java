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

/**
 *
 * @author Admin
 */
public class DeleteDBContext extends DBContext {

    public void DeleteRecord(int id) {
        String sql = "DElETE [BaoCao]\n"
                + " WHERE [cid] = ?";
        PreparedStatement ps = null;
        try {
            ps = connect.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DeleteDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DeleteDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DeleteDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void DeletePlan(int id) {
        String sql = "DElETE [Plan]\n"
                + " WHERE [pid] = ?";
        PreparedStatement ps = null;
        try {
            ps = connect.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DeleteDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DeleteDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DeleteDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void DeleteTarget(int id) {
        String sql = "DElETE [Target]\n"
                + " WHERE [tid] = ?";
        PreparedStatement ps = null;
        try {
            ps = connect.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DeleteDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DeleteDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DeleteDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
