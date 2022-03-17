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
public class Target {
    private int tid;
    private String tname;
    private Date from;
    private Date to;
    private int dayleft;
    private int tprice;
    private int pricesave;
    private int stt;

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public int getDayleft() {
        return dayleft;
    }

    public void setDayleft(int dayleft) {
        this.dayleft = dayleft;
    }

    public int getPricesave() {
        return pricesave;
    }

    public void setPricesave(int pricesave) {
        this.pricesave = pricesave;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
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

    public int getTprice() {
        return tprice;
    }

    public void setTprice(int tprice) {
        this.tprice = tprice;
    }
    
    
}
