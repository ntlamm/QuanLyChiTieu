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

/**
 *
 * @author Admin
 */
public class GroupDBContext extends DBContext{
    public ArrayList<Group> getGroups() {
        ArrayList<Group> groups = new ArrayList<>();
        try {
            String sql = "select cgroupid,cgroupname,cgroupnote from [Group]";
            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Group g = new Group();
                g.setCgroupid(rs.getInt("cgroupid"));
                g.setCgroupname(rs.getString("cgroupname"));
                g.setCgroupnote(rs.getString("cgroupnote"));
                groups.add(g);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TypeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return groups;
    }
}
