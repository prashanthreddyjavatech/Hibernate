package com.kprjavatech.hibernate.crud;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/*This class helps in creating the SessionFactory from the Hibernate configuration file 
  and interacts with the database to perform the Create, Update, Read, and Delete operations*/

public class StudentDAo {

    
    // Method 1: This Method Used To Create A New Student Record In The Database Table
    public static Integer createRecord(Student studentObj) {
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
 
        
        //Creating Transaction Object  
        Transaction transObj = sessionObj.beginTransaction();
         sessionObj.save(studentObj);
 
        // Transaction Is Committed To Database
        transObj.commit();
 
        // Closing The Session Object
        sessionObj.close();
        System.out.println("Successfully Created " + studentObj.toString());
        return studentObj.getStudentId();
    }
 
    // Method 2: This Method Is Used To Display The Records From The Database Table
    @SuppressWarnings("unchecked")
    public static List<Student> displayRecords() {
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        List<Student> studentsList = sessionObj.createQuery("FROM Student").list();
 
        // Closing The Session Object
        sessionObj.close();
        System.out.println("Student Records Available In Database Are?= " + studentsList.size());
        return studentsList;
    }
 
    // Method 3: This Method Is Used To Update A Record In The Database Table
    public static void updateRecord(Student studentObj) {
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
 
        //Creating Transaction Object  
        Transaction transObj = sessionObj.beginTransaction();
        Student stuObj = sessionObj.load(Student.class, studentObj.getStudentId());
        stuObj.setStudentName(studentObj.getStudentName());
        stuObj.setStudentAge(studentObj.getStudentAge());
        sessionObj.update(stuObj);
 
        // Transaction Is Committed To Database
        transObj.commit();
 
        // Closing The Session Object
        sessionObj.close();
        System.out.println("Student Record Is Successfully Updated!= " + studentObj.toString());
    }
 
    // Method 4(a): This Method Is Used To Delete A Particular Record From The Database Table
    public static void deleteRecord(Integer studentId) {
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
 
        //Creating Transaction Object  
        Transaction transObj = sessionObj.beginTransaction();
        Student studObj = findRecordById(studentId);
        sessionObj.delete(studObj);
 
        // Transaction Is Committed To Database
        transObj.commit();
 
        // Closing The Session Object
        sessionObj.close();
        System.out.println("Successfully Record Is Successfully Deleted!=  " + studObj.toString());
 
    }
 
    // Method 4(b): This Method To Find Particular Record In The Database Table
    public static Student findRecordById(Integer studentId) {
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
        Student stu = sessionObj.load(Student.class, studentId);
 
        // Closing The Session Object
        sessionObj.close();
        return stu;
    }
 
    // Method 5: This Method Is Used To Delete All Records From The Database Table
    public static void deleteAllRecords() {
        Session sessionObj = HibernateUtil.getSessionFactory().openSession();
 
        //Creating Transaction Object  
        Transaction transObj = sessionObj.beginTransaction();
        Query<Student> queryObj = sessionObj.createQuery("DELETE FROM Student");
        queryObj.executeUpdate();
 
        // Transaction Is Committed To Database
        transObj.commit();
 
        // Closing The Session Object
        sessionObj.close();
        System.out.println("Successfully Deleted All Records From The Database Table!");
    }

}
