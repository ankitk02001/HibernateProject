package com.map;

import javax.persistence.*;

@Entity
public class Answer {
    @Id
    @Column(name = "answer_id")
    private int answerId;

    private String answer;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private com.map.Question question;

    // getters and setters
    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public com.map.Question getQuestion() {
        return question;
    }

    public void setQuestion(com.map.Question question) {
        this.question = question;
    }
}