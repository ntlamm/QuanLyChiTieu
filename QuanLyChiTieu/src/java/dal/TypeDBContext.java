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
import model.Type;

/**
 *
 * @author Admin
 */
public class TypeDBContext extends DBContext {

    public ArrayList<Type> getTypes() {
        ArrayList<Type> types = new ArrayList<>();
        try {
            String sql = "select ctypeid,ctypename from Loai";
            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Type l = new Type();
                l.setCtypeid(rs.getInt("ctypeid"));
                l.setCtypename(rs.getString("ctypename"));
                types.add(l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TypeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return types;
    }
}
