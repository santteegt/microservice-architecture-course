package com.ucuenca.dtic.courseregistry.domain;

import java.io.Serializable;

public class TblCourses implements Serializable {

    private static final long serialVersionUID = 1L;

    private String courseCode;

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
