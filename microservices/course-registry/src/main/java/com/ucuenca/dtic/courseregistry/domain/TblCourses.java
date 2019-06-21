package com.ucuenca.dtic.courseregistry.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tbl_courses")
public class TblCourses implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "course_id")
    private String courseCode;

    @Column(name = "description")
    private String description;

    public TblCourses() {
    }

    public TblCourses(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}