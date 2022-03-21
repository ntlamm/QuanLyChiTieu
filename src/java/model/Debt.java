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
public class Debt {
    private int debtid;
    private Date debtdate;
    private String debtname;
    private int debtprice;
    private int debtpay;
    private int debtleft;
    private int stt;

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public int getDebtid() {
        return debtid;
    }

    public void setDebtid(int debtid) {
        this.debtid = debtid;
    }

    public Date getDebtdate() {
        return debtdate;
    }

    public void setDebtdate(Date debtdate) {
        this.debtdate = debtdate;
    }

    public String getDebtname() {
        return debtname;
    }

    public void setDebtname(String debtname) {
        this.debtname = debtname;
    }

    public int getDebtprice() {
        return debtprice;
    }

    public void setDebtprice(int debtprice) {
        this.debtprice = debtprice;
    }

    public int getDebtpay() {
        return debtpay;
    }

    public void setDebtpay(int debtpay) {
        this.debtpay = debtpay;
    }

    public int getDebtleft() {
        return debtleft;
    }

    public void setDebtleft(int debtleft) {
        this.debtleft = debtleft;
    }
    
}
