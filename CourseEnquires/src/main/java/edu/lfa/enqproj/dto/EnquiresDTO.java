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
public class EnquiresDTO {
    private int eid,ecourseid,efacultyid;
    private String efname,elname,eemail,egender,emessage;

    public EnquiresDTO() {
    }

    public EnquiresDTO(int eid, int ecourseid, int efacultyid, String efname, String elname, String eemail, String egender, String emessage) {
        this.eid = eid;
        this.ecourseid = ecourseid;
        this.efacultyid = efacultyid;
        this.efname = efname;
        this.elname = elname;
        this.eemail = eemail;
        this.egender = egender;
        this.emessage = emessage;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public int getEcourseid() {
        return ecourseid;
    }

    public void setEcourseid(int ecourseid) {
        this.ecourseid = ecourseid;
    }

    public int getEfacultyid() {
        return efacultyid;
    }

    public void setEfacultyid(int efacultyid) {
        this.efacultyid = efacultyid;
    }

    public String getEfname() {
        return efname;
    }

    public void setEfname(String efname) {
        this.efname = efname;
    }

    public String getElname() {
        return elname;
    }

    public void setElname(String elname) {
        this.elname = elname;
    }

    public String getEemail() {
        return eemail;
    }

    public void setEemail(String eemail) {
        this.eemail = eemail;
    }

    public String getEgender() {
        return egender;
    }

    public void setEgender(String egender) {
        this.egender = egender;
    }

    public String getEmessage() {
        return emessage;
    }

    public void setEmessage(String emessage) {
        this.emessage = emessage;
    }
    
   
}
