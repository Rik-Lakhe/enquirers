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
@Table(name = "tbl_faculty")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Faculty.findAll", query = "SELECT f FROM Faculty f"),
    @NamedQuery(name = "Faculty.findByFacultyId", query = "SELECT f FROM Faculty f WHERE f.facultyId = :facultyId"),
    @NamedQuery(name = "Faculty.findByFacultyName", query = "SELECT f FROM Faculty f WHERE f.facultyName = :facultyName"),
    @NamedQuery(name = "Faculty.findByFacultyStatus", query = "SELECT f FROM Faculty f WHERE f.facultyStatus = :facultyStatus")})
public class Faculty implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "faculty_id")
    private Integer facultyId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "faculty_name")
    private String facultyName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "faculty_status")
    private boolean facultyStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "enqFacultyId")
    private List<Enquires> enquiresList;

    public Faculty() {
    }

    public Faculty(Integer facultyId) {
        this.facultyId = facultyId;
    }

    public Faculty(Integer facultyId, String facultyName, boolean facultyStatus) {
        this.facultyId = facultyId;
        this.facultyName = facultyName;
        this.facultyStatus = facultyStatus;
    }

    public Integer getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Integer facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public boolean getFacultyStatus() {
        return facultyStatus;
    }

    public void setFacultyStatus(boolean facultyStatus) {
        this.facultyStatus = facultyStatus;
    }

    @XmlTransient
    public List<Enquires> getEnquiresList() {
        return enquiresList;
    }

    public void setEnquiresList(List<Enquires> enquiresList) {
        this.enquiresList = enquiresList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facultyId != null ? facultyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Faculty)) {
            return false;
        }
        Faculty other = (Faculty) object;
        if ((this.facultyId == null && other.facultyId != null) || (this.facultyId != null && !this.facultyId.equals(other.facultyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.lfa.enqproj.entity.Faculty[ facultyId=" + facultyId + " ]";
    }
    
}
