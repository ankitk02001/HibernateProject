package com.map;
import javax.persistence.*;

@Entity
public class Answer {
    @Id
    @Column(name = "answer_id")
    private int answerId;

    private String answer;

    @OneToOne
    @JoinColumn(name = "question_id")
    private Question question;

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

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer(int answerId, String answer) {
        super();
        this.answerId = answerId;
        this.answer = answer;
    }

    public Answer() {
        super();
    }
}