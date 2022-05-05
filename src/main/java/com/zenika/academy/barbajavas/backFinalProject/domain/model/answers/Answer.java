package com.zenika.academy.barbajavas.backFinalProject.domain.model.answers;

import com.zenika.academy.barbajavas.backFinalProject.domain.model.questions.Question;
import com.zenika.academy.barbajavas.backFinalProject.domain.model.users.User;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "answers")
@Access(AccessType.FIELD)
public class Answer {
    @Id
    private String id;
    private ZonedDateTime answer_date;
    private String content;
    private boolean flag;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public Answer(String id, ZonedDateTime answer_date, String content, boolean flag, Question question,User user) {
        this.id = id;
        this.answer_date = answer_date;
        this.content = content;
        this.flag = flag;
        this.question = question;
        this.user = user;
    }

    protected Answer(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ZonedDateTime getAnswer_date() {
        return answer_date;
    }

    public void setAnswer_date(ZonedDateTime answer_date) {
        this.answer_date = answer_date;
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

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id='" + id + '\'' +
                ", answer_date=" + answer_date +
                ", content='" + content + '\'' +
                ", flag=" + flag +
                ", question=" + question +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
