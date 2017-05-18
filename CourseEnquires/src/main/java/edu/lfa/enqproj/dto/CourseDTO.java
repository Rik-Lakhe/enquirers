/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lfa.enqproj.dto;

/**
 *
 * @author LAKHE
 */
public class CourseDTO {
    private int cid;
    private String cname,ccode;
    private boolean cstatus;
    private float cfees;

    public CourseDTO() {
    }

    public CourseDTO(int cid, String cname, String ccode, boolean cstatus, float cfees) {
        this.cid = cid;
        this.cname = cname;
        this.ccode = ccode;
        this.cstatus = cstatus;
        this.cfees = cfees;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCcode() {
        return ccode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    public boolean isCstatus() {
        return cstatus;
    }

    public void setCstatus(boolean cstatus) {
        this.cstatus = cstatus;
    }

    public float getCfees() {
        return cfees;
    }

    public void setCfees(float cfees) {
        this.cfees = cfees;
    }
    
    
}
