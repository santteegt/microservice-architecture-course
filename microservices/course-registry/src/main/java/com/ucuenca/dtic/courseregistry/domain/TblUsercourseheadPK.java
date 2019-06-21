package com.ucuenca.dtic.courseregistry.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class TblUsercourseheadPK implements Serializable {

    @Column(name = "student_id")
    private String studentId;

    @Column(name = "term")
    private int term;

    @Column(name = "faculty_id")
    private String facultyId;

    @Column(name = "programme_id")
    private String programmeId;

    public TblUsercourseheadPK() {
    }

    public TblUsercourseheadPK(String studentId, int term, String facultyId, String programmeId) {
        this.studentId = studentId;
        this.term = term;
        this.facultyId = facultyId;
        this.programmeId = programmeId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    public String getProgrammeId() {
        return programmeId;
    }

    public void setProgrammeId(String programmeId) {
        this.programmeId = programmeId;
    }

}