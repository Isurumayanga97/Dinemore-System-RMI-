/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.isuru.dinemore.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author ISURU UMAYANGA
 */
@Entity
public class Reception {
    
    @Id
    private String oid;
    private String rid;
    private String date;
    private String time;
    private String cid;
    private String tpNo;
    private int qty;
    private String status;

    public Reception() {
    }

    public Reception(String oid, String rid, String date, String time, String cid, String tpNo, int qty, String status) {
        this.oid = oid;
        this.rid = rid;
        this.date = date;
        this.time = time;
        this.cid = cid;
        this.tpNo = tpNo;
        this.qty = qty;
        this.status = status;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getTpNo() {
        return tpNo;
    }

    public void setTpNo(String tpNo) {
        this.tpNo = tpNo;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
