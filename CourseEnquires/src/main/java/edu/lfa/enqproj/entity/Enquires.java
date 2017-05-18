/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lfa.enqproj.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author LAKHE
 */
@Entity
@Table(name = "tbl_enquires")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enquires.findAll", query = "SELECT e FROM Enquires e"),
    @NamedQuery(name = "Enquires.findByEnqId", query = "SELECT e FROM Enquires e WHERE e.enqId = :enqId"),
    @NamedQuery(name = "Enquires.findByEnqFname", query = "SELECT e FROM Enquires e WHERE e.enqFname = :enqFname"),
    @NamedQuery(name = "Enquires.findByEnqLname", query = "SELECT e FROM Enquires e WHERE e.enqLname = :enqLname"),
    @NamedQuery(name = "Enquires.findByEnqEmail", query = "SELECT e FROM Enquires e WHERE e.enqEmail = :enqEmail"),
    @NamedQuery(name = "Enquires.findByEnqGender", query = "SELECT e FROM Enquires e WHERE e.enqGender = :enqGender")})
public class Enquires implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "enq_id")
    private Integer enqId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "enq_fname")
    private String enqFname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "enq_lname")
    private String enqLname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "enq_email")
    private String enqEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "enq_gender")
    private String enqGender;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "enq_message")
    private String enqMessage;
    @JoinColumn(name = "enq_faculty_id", referencedColumnName = "faculty_id")
    @ManyToOne(optional = false)
    private Faculty enqFacultyId;
    @JoinColumn(name = "enq_course_id", referencedColumnName = "course_id")
    @ManyToOne(optional = false)
    private Course enqCourseId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "followEnqId")
    private List<Followup> followupList;

    public Enquires() {
    }

    public Enquires(Integer enqId) {
        this.enqId = enqId;
    }

    public Enquires(Integer enqId, String enqFname, String enqLname, String enqEmail, String enqGender, String enqMessage) {
        this.enqId = enqId;
        this.enqFname = enqFname;
        this.enqLname = enqLname;
        this.enqEmail = enqEmail;
        this.enqGender = enqGender;
        this.enqMessage = enqMessage;
    }

    public Integer getEnqId() {
        return enqId;
    }

    public void setEnqId(Integer enqId) {
        this.enqId = enqId;
    }

    public String getEnqFname() {
        return enqFname;
    }

    public void setEnqFname(String enqFname) {
        this.enqFname = enqFname;
    }

    public String getEnqLname() {
        return enqLname;
    }

    public void setEnqLname(String enqLname) {
        this.enqLname = enqLname;
    }

    public String getEnqEmail() {
        return enqEmail;
    }

    public void setEnqEmail(String enqEmail) {
        this.enqEmail = enqEmail;
    }

    public String getEnqGender() {
        return enqGender;
    }

    public void setEnqGender(String enqGender) {
        this.enqGender = enqGender;
    }

    public String getEnqMessage() {
        return enqMessage;
    }

    public void setEnqMessage(String enqMessage) {
        this.enqMessage = enqMessage;
    }

    public Faculty getEnqFacultyId() {
        return enqFacultyId;
    }

    public void setEnqFacultyId(Faculty enqFacultyId) {
        this.enqFacultyId = enqFacultyId;
    }

    public Course getEnqCourseId() {
        return enqCourseId;
    }

    public void setEnqCourseId(Course enqCourseId) {
        this.enqCourseId = enqCourseId;
    }

    @XmlTransient
    public List<Followup> getFollowupList() {
        return followupList;
    }

    public void setFollowupList(List<Followup> followupList) {
        this.followupList = followupList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (enqId != null ? enqId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enquires)) {
            return false;
        }
        Enquires other = (Enquires) object;
        if ((this.enqId == null && other.enqId != null) || (this.enqId != null && !this.enqId.equals(other.enqId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.lfa.enqproj.entity.Enquires[ enqId=" + enqId + " ]";
    }
    
}
