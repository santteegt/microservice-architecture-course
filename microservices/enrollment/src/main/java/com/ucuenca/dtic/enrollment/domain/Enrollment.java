package com.ucuenca.dtic.enrollment.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Enrollment {

    @Id
    private String id;

    @Column(name = "student_id")
    private String studentId;
    @Column(name = "faculty_id")
    private String facultyId;
    @Column(name = "programme_id")
    private String programmeId;
    private int term;
    @Column(name = "creation_date")
    private Date creationDate;

    public Enrollment() {
        super();
    }

    public Enrollment(String id, String studentId, String facultyId, String programmeId, int term, Date creationDate) {
        this.id = id;
        this.studentId = studentId;
        this.facultyId = facultyId;
        this.programmeId = programmeId;
        this.term = term;
        this.creationDate = creationDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getstudentId() {
        return studentId;
    }

    public void setstudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getfacultyId() {
        return facultyId;
    }

    public void setfacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    public String getprogrammeId() {
        return programmeId;
    }

    public void setprogrammeId(String programmeId) {
        this.programmeId = programmeId;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "id=" + id +
                ", studentId='" + studentId + '\'' +
                ", facultyId='" + facultyId + '\'' +
                ", programmeId='" + programmeId + '\'' +
                ", term='" + term + '\'' +
                '}';
    }
}
