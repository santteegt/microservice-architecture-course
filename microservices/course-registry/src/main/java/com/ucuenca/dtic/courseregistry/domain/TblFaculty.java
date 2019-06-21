package com.ucuenca.dtic.courseregistry.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "tbl_faculty")
public class TblFaculty implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "faculty_id")
    private String facultyId;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "tblUsercourseheadPK.facultyId")
    @JsonBackReference
    private Set<TblUsercoursehead> tblUsercourseheadList;

    public TblFaculty() {
    }

    public TblFaculty(String facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<TblUsercoursehead> getTblUsercourseheadList() {
        return tblUsercourseheadList;
    }

    public void setTblUsercourseheadList(Set<TblUsercoursehead> tblUsercourseheadList) {
        this.tblUsercourseheadList = tblUsercourseheadList;
    }
}