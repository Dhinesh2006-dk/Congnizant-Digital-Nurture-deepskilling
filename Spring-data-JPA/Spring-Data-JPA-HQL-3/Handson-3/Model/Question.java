package com.cognizant.ormlearn.model;
import java.util.Set;
import javax.persistence.*;
@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qu_id")
    private int id;
    @Column(name = "qu_text")
    private String text;
    @OneToMany(mappedBy = "question")
    private Set<Options> optionList;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public Set<Options> getOptionList() {
        return optionList;
    }
    public void setOptionList(Set<Options> optionList) {
        this.optionList = optionList;
    }
}