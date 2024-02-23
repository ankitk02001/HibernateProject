package com.map;

import javax.persistence.*;
import java.util.List;

@Entity
public class Question {
    @Id
    @Column(name = "question_id")
    private int questionId;

    private String question;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<com.map.Answer> answers;

    // getters and setters
    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<com.map.Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<com.map.Answer> answers) {
        this.answers = answers;
    }
}