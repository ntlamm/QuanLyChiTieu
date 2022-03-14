/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class Group {
    private int cgroupid;
    private String cgroupname;
    private String cgroupnote;

    public int getCgroupid() {
        return cgroupid;
    }

    public void setCgroupid(int cgroupid) {
        this.cgroupid = cgroupid;
    }

    public String getCgroupname() {
        return cgroupname;
    }

    public void setCgroupname(String cgroupname) {
        this.cgroupname = cgroupname;
    }

    public String getCgroupnote() {
        return cgroupnote;
    }

    public void setCgroupnote(String cgroupnote) {
        this.cgroupnote = cgroupnote;
    }
    
}
