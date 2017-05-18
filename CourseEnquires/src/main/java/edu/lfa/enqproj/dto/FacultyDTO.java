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
public class FacultyDTO {
    private int fid;
    private String fname;
    private boolean fstatus;

    public FacultyDTO() {
    }

    public FacultyDTO(int fid, String fname, boolean fstatus) {
        this.fid = fid;
        this.fname = fname;
        this.fstatus = fstatus;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public boolean isFstatus() {
        return fstatus;
    }

    public void setFstatus(boolean fstatus) {
        this.fstatus = fstatus;
    }
    
    
}
