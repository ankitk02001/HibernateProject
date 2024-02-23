package com.tut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) throws Exception {
		// SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
//		System.out.println(factory);
//		System.out.println(factory.isClosed());
//		System.out.println(factory.isOpen());

		// creating object of student
		Student st = new Student();// we can set value through constructer also
		st.setId(123);
		st.setName("Indrajeet");
		st.setCity("Kanpur");
		System.out.println(st);// from tostring method we get value
		// we have to save the st object in db and save method present in session
		Session session = factory.getCurrentSession();// Session interface from org.hibernate
		// to save we have to start transaction
//		session.beginTransaction();
//		session.save(st);//to save st object
//		//to make physical change in db we have to commit the transaction
//		session.getTransaction().commit();
//		session.close();
		// above in another way
		
		
		
		//creating object of Address class
		Address ad=new Address();
		ad.setStreet("street1");
		ad.setCity("Delhi");
		ad.setIsopen(true);
		ad.setAddedDate(new Date());
		ad.setX(1234.43);
		
		//reading image 
		FileInputStream fis=new FileInputStream("src/main/java/pic.jpg");
		//making byte type array
		byte[] data=new byte[fis.available()];
		fis.read(data);
		ad.setImage(data);
		
		
		Transaction tx = session.beginTransaction();// Transaction from hibernate
		session.save(st);
		session.save(ad);//saving ad object
		tx.commit();
		session.close();
        System.out.println("done"); 
         
	}
}
