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
public class FollowupDTO {
    private int fid,fenquiresid;
    private String fenquiresmessage;

    public FollowupDTO() {
    }

    public FollowupDTO(int fid, int fenquiresid, String fenquiresmessage) {
        this.fid = fid;
        this.fenquiresid = fenquiresid;
        this.fenquiresmessage = fenquiresmessage;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public int getFenquiresid() {
        return fenquiresid;
    }

    public void setFenquiresid(int fenquiresid) {
        this.fenquiresid = fenquiresid;
    }

    public String getFenquiresmessage() {
        return fenquiresmessage;
    }

    public void setFenquiresmessage(String fenquiresmessage) {
        this.fenquiresmessage = fenquiresmessage;
    }
    
    
}
