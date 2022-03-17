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
public class List {
    private int cid;
    private Date cdate;
    private String cname;
    private int cprice;
    private String cnote;
    private Type type;
    private Group group;
    private int stt;

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }    

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getCprice() {
        return cprice;
    }

    public void setCprice(int cprice) {
        this.cprice = cprice;
    }

    public String getCnote() {
        return cnote;
    }

    public void setCnote(String cnote) {
        this.cnote = cnote;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
    
}
