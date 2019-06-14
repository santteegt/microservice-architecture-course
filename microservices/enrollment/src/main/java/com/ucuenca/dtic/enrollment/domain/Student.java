package com.ucuenca.dtic.enrollment.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Student {

    @Id
    private String id;
    private String name;
    @Column(name = "creation_date")
    private Date creationDate;

    public Student() {
        super();
    }

    public Student(String id, String name, Date creationDate) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
    }

    public Student(String name) {
        super();
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return String.format("Student [id=%s, name=%s, passportNumber=%s]", id, name);
    }

}