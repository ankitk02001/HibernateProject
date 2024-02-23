package com.map;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory factory = cfg.buildSessionFactory();

        // Creating Question
        com.map.Question q1 = new com.map.Question();
        q1.setQuestionId(1212);
        q1.setQuestion("What is java?");

        // Creating answers
        com.map.Answer answer = new com.map.Answer();
        answer.setAnswerId(343);
        answer.setAnswer("java is programming Language");
        answer.setQuestion(q1);

        com.map.Answer answer1 = new com.map.Answer();
        answer1.setAnswerId(344);
        answer1.setAnswer("with the help of java we can create softwares");
        answer1.setQuestion(q1);

        com.map.Answer answer2 = new com.map.Answer();
        answer2.setAnswerId(345);
        answer2.setAnswer("java has different types of frameworks");
        answer2.setQuestion(q1);

        // Creating a list of answers and setting it in Question
        List<Answer> answersList = new ArrayList<Answer>();
        answersList.add(answer);
        answersList.add(answer1);
        answersList.add(answer2);
        q1.setAnswers(answersList);

        Session s = factory.openSession();

        // To make permanent changes in the database
        Transaction tx = s.beginTransaction();
        s.save(q1);  // Save the Question object, not the Transaction object
        tx.commit();
        s.close();
        factory.close();
    }
}