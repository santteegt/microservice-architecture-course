package com.ucuenca.dtic.courseregistry.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "tbl_usercoursehead")
public class TblUsercoursehead implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected TblUsercourseheadPK tblUsercourseheadPK;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "tbl_usercoursedetail",
            joinColumns = {
                    @JoinColumn(name = "student_id", referencedColumnName = "student_id"),
                    @JoinColumn(name = "term", referencedColumnName = "term"),
                    @JoinColumn(name = "faculty_id", referencedColumnName = "faculty_id"),
                    @JoinColumn(name = "programme_id", referencedColumnName = "programme_id")
            },
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    )
    @JsonManagedReference
    private Set<TblCourses> tblCourses;

    @JoinColumn(name = "faculty_id", referencedColumnName = "faculty_id", insertable = false, updatable = false)
    @ManyToOne
    @JsonManagedReference
    private TblFaculty facultyId;

    public TblUsercoursehead() {
    }

    public TblUsercoursehead(TblUsercourseheadPK tblUsercourseheadPK, Set<TblCourses> tblCourses) {
        this.tblUsercourseheadPK = tblUsercourseheadPK;
        this.tblCourses = tblCourses;
    }

    public TblUsercoursehead(String studentId, int term, TblFaculty facultyId, String programmeId) {
        this.tblUsercourseheadPK = new TblUsercourseheadPK(studentId, term, facultyId.getDescription(), programmeId);
    }

    public TblUsercourseheadPK getTblUsercourseheadPK() {
        return tblUsercourseheadPK;
    }

    public void setTblUsercourseheadPK(TblUsercourseheadPK tblUsercourseheadPK) {
        this.tblUsercourseheadPK = tblUsercourseheadPK;
    }

    public Set<TblCourses> getTblCourses() {
        return tblCourses;
    }

    public void setTblCourses(Set<TblCourses> tblCourses) {
        this.tblCourses = tblCourses;
    }
}