package com.zenika.academy.barbajavas.backFinalProject.domain.model.answers;

import com.zenika.academy.barbajavas.backFinalProject.domain.model.questions.Question;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "answers")
@Access(AccessType.FIELD)
public class Answer {
    @Id
    private String id;
    private LocalTime answer_date;
    private String content;
    private boolean flag;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private Question question;

    public Answer(String id, LocalTime answer_date, String content, boolean flag, Question question) {
        this.id = id;
        this.answer_date = answer_date;
        this.content = content;
        this.flag = flag;
        this.question = question;
    }

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
}
