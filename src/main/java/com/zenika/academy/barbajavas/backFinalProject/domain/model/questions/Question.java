package com.zenika.academy.barbajavas.backFinalProject.domain.model.questions;

import com.zenika.academy.barbajavas.backFinalProject.domain.model.users.User;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.time.LocalDate;

@Entity
@Table(name = "questions")
@Access(AccessType.FIELD)
public class Question {
    @Id
    private String id;
    private ZonedDateTime question_date;
    private String title;
    private String content;
    private boolean flag;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;


    public Question(String id, ZonedDateTime question_date, String title, String content, boolean flag,User user) {
        this.id = id;
        this.question_date = question_date;
        this.title = title;
        this.content = content;
        this.flag = flag;
        this.user = user;
    }
    protected Question(){}


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ZonedDateTime getAnswer_date() {
        return question_date;
    }

    public void setAnswer_date(LocalDate question_date) {
        this.question_date = ZonedDateTime.from(question_date);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id='" + id + '\'' +
                ", question_date=" + question_date +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", flag=" + flag +
                ", user=" + user +
                '}';
    }
}
