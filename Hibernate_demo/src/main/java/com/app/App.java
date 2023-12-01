package com.app;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	//Create Session factory
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        
        //Create Session
        Session session=factory.openSession();
        
        //Begin the Transaction
        session.beginTransaction();
        
        //Perform operation
        //Create Student object
          Student s=new Student();
          s.setFirstName("Mayuri");
          s.setLastName("Ma'am");
          s.setAge(24);
          session.save(s);
//        
        //Get StudentID
//        
//          int id=5;
//          Student s=session.get(Student.class, id);
//          System.out.println(s);
//        
        
        //Update Student
//        int id=2;
//        Student s=session.get(Student.class, id);
//        s.setFirstName("Prathmesh");
//        s.setLastName("Kulkarni");
        
        //Delete Student
        
//        int id=8;
//        Student s=session.get(Student.class, id);
//        session.delete(s);

        //List of Students
        
//        Query query=session.createQuery("from Student");
//        List<Student> l=query.list();
//        for(Student s:l)
//        {
//        	System.out.println(s);
//        }
        
        //HQL-Hibernate Query Language
        
//        List <Student> l=session.createQuery("from Student s where s.lastName='Aswale'").getResultList();
//        for(Student a:l)
//        {
//        	System.out.println(a);
//        }
        
        session.getTransaction().commit();
        session.close();
        factory.close();
        
    }
}
