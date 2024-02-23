package com.map;

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
        Question q1 = new Question();
        q1.setQuestionId(1212);
        q1.setQuestion("What is java?");

        // Creating answer
        Answer answer = new Answer();
        answer.setAnswerId(343);
        answer.setAnswer("java is programming Language");
        q1.setAnswer(answer);

        // Creating Question second
        Question q2 = new Question();
        q2.setQuestionId(242);
        q2.setQuestion("what is collection framework?");

        // Creating answer
        Answer answer1 = new Answer();
        answer1.setAnswerId(344);
        answer1.setAnswer("API to work with a group of objects");
        q2.setAnswer(answer1);

        Session s = factory.openSession();

        // To make permanent change in db
        Transaction tx = s.beginTransaction();

        // To save objects
        s.save(q1);
        s.save(q2);
        tx.commit();

        factory.close();
        s.close();
    }
}