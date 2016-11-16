package net.nicken.useradmin.model;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class User {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME", nullable = false, length = 25)
    private String name;

    public String getName() {

        System.out.println("name="+name);
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "AGE", nullable = true)
    private Integer age;

    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "ISADMIN", nullable = true)
    private Boolean isadmin;

    public Boolean getIsadmin() {
        return isadmin;
    }
    public void setIsadmin(Boolean isadmin) {
        this.isadmin = isadmin;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATEDDATE", nullable = true)
    private Date createddate;

    public Date getCreateddate() {
        return createddate;
    }
    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }
}
