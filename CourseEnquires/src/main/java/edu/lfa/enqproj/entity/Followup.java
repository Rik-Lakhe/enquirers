/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lfa.enqproj.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LAKHE
 */
@Entity
@Table(name = "tbl_followup")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Followup.findAll", query = "SELECT f FROM Followup f"),
    @NamedQuery(name = "Followup.findByFollowId", query = "SELECT f FROM Followup f WHERE f.followId = :followId"),
    @NamedQuery(name = "Followup.findByFollowDate", query = "SELECT f FROM Followup f WHERE f.followDate = :followDate"),
    @NamedQuery(name = "Followup.findByFollowNextdate", query = "SELECT f FROM Followup f WHERE f.followNextdate = :followNextdate")})
public class Followup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "follow_id")
    private Integer followId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "follow_date",insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date followDate;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "follow_enq_message")
    private String followEnqMessage;
    @Column(name = "follow_nextdate",nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date followNextdate;
    @JoinColumn(name = "follow_enq_id", referencedColumnName = "enq_id")
    @ManyToOne(optional = false)
    private Enquires followEnqId;

    public Followup() {
    }

    public Followup(Integer followId) {
        this.followId = followId;
    }

    public Followup(Integer followId, Date followDate, String followEnqMessage) {
        this.followId = followId;
        this.followDate = followDate;
        this.followEnqMessage = followEnqMessage;
    }

    public Integer getFollowId() {
        return followId;
    }

    public void setFollowId(Integer followId) {
        this.followId = followId;
    }

    public Date getFollowDate() {
        return followDate;
    }

    public void setFollowDate(Date followDate) {
        this.followDate = followDate;
    }

    public String getFollowEnqMessage() {
        return followEnqMessage;
    }

    public void setFollowEnqMessage(String followEnqMessage) {
        this.followEnqMessage = followEnqMessage;
    }

    public Date getFollowNextdate() {
        return followNextdate;
    }

    public void setFollowNextdate(Date followNextdate) {
        this.followNextdate = followNextdate;
    }

    public Enquires getFollowEnqId() {
        return followEnqId;
    }

    public void setFollowEnqId(Enquires followEnqId) {
        this.followEnqId = followEnqId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (followId != null ? followId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Followup)) {
            return false;
        }
        Followup other = (Followup) object;
        if ((this.followId == null && other.followId != null) || (this.followId != null && !this.followId.equals(other.followId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.lfa.enqproj.entity.Followup[ followId=" + followId + " ]";
    }
    
}
