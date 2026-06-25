package com.cognizant.ormlearn.model;
import java.util.Set;
import javax.persistence.*;
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "us_id")
    private int id;
    @Column(name = "us_name")
    private String name;
    @OneToMany(mappedBy = "user")
    private Set<Attempt> attemptList;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Set<Attempt> getAttemptList() {
        return attemptList;
    }
    public void setAttemptList(Set<Attempt> attemptList) {
        this.attemptList = attemptList;
    }
}