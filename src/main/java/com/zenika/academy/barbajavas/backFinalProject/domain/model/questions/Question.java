package com.zenika.academy.barbajavas.backFinalProject.domain.model.questions;

import com.zenika.academy.barbajavas.backFinalProject.domain.model.users.User;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "questions")
@Access(AccessType.FIELD)
public class Question {
    @Id
    private String id;
    private LocalTime answer_date;
    private String title;
    private String content;
    private boolean flag;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;


    public Question(String id, LocalTime answer_date, String title, String content, boolean flag,User user) {
        this.id = id;
        this.answer_date = answer_date;
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

    public LocalTime getAnswer_date() {
        return answer_date;
    }

    public void setAnswer_date(LocalTime answer_date) {
        this.answer_date = answer_date;
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
                ", answer_date=" + answer_date +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", flag=" + flag +
                ", user=" + user +
                '}';
    }
}
