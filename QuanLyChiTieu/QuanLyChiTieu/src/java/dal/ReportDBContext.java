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
import model.List;

/**
 *
 * @author Sap-lap
 */
public class ReportDBContext extends DBContext {
    public ArrayList<List> getlists(int typeid)
    {
        ArrayList<List> lists = new ArrayList<>();
        try {            
            String sql = "select a.cid,a.cdate,a.cname,a.cprice,a.cnote,a.ctypeid,b.ctypename from BaoCaoThang a join Loai b on a.ctypeid=b.ctypeid";
            if(typeid > -1)
                sql += " where a.ctypeid = ?";
            PreparedStatement stm = connect.prepareStatement(sql);
            if(typeid > -1)
                stm.setInt(1, typeid);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                List d = new List();
                d.setCid(rs.getInt("cid"));
                d.setCdate(rs.getDate("cdate"));
                d.setCname(rs.getString("cname"));
                d.setCprice(rs.getInt("cprice"));
                d.setCnote(rs.getString("cnote"));
                Type l = new Type();
                l.setCtypeid(rs.getInt("ctypeid"));
                l.setCtypename(rs.getString("ctypename"));
                d.setType(l);
                lists.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReportDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lists;
    }  
}
