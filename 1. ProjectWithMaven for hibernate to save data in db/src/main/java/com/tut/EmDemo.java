package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
public static void main(String[] args) {
	Configuration cfg=new Configuration();
	cfg.configure();
	SessionFactory factory=cfg.buildSessionFactory();
	
	Student student1=new Student();
	student1.setId(1324);
	student1.setName("Ankit");
	student1.setCity("Lucknow");

	//cerficate is class we have to create object of it
	Certificate certificate=new Certificate();
	certificate.setCourse("Android");
	certificate.setDuration("2 months");
	student1.setCerti(certificate);
	
	
	//same we can create for student2

	Student student2=new Student();
	student2.setId(1326);
	student2.setName("Ravi Tiwari");
	student2.setCity("Delhi");

	//cerficate is class we have to create object of it
	Certificate certificate1=new Certificate();
	certificate1.setCourse("Hibernate");
	certificate1.setDuration("1.5 months");
	student2.setCerti(certificate1);
	
	Session s=factory.openSession();
	Transaction tx =s.beginTransaction();
	//to save objects
	s.save(student1);
	s.save(student2);


	tx.commit();
	factory.close();
}
}
