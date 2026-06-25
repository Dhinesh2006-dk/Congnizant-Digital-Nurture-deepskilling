package com.cognizant.ormlearn.model;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;
@Entity
@Table(name = "attempt")
public class Attempt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "at_id")
    private int id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "at_date")
    private Date attemptDate;
    @ManyToOne
    @JoinColumn(name = "at_us_id")
    private User user;
    @OneToMany(mappedBy = "attempt")
    private Set<AttemptQuestion> attemptQuestionList;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Date getAttemptDate() {
        return attemptDate;
    }
    public void setAttemptDate(Date attemptDate) {
        this.attemptDate = attemptDate;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Set<AttemptQuestion> getAttemptQuestionList() {
        return attemptQuestionList;
    }
    public void setAttemptQuestionList(Set<AttemptQuestion> attemptQuestionList) {
        this.attemptQuestionList = attemptQuestionList;
    }
}