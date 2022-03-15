/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Plan {
    private int pid;
    private Group group;
    private Date from;
    private Date to; 
    private int pprice;
    private int paypprice;
    private int dayleft;

    public int getDayleft() {
        return dayleft;
    }

    public void setDayleft(int dayleft) {
        this.dayleft = dayleft;
    }

    public int getPaypprice() {
        return paypprice;
    }

    public void setPaypprice(int paypprice) {
        this.paypprice = paypprice;
    }
    
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public int getPprice() {
        return pprice;
    }

    public void setPprice(int pprice) {
        this.pprice = pprice;
    }
    
    
}
