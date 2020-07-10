package com.kprjavatech.hibernate.crud;

import java.util.List;

public class StudentTest {
	public static void main(String[] args) {
		 Student studentObj1 = new Student(1, "James", 20);
	        Student studentObj2 = new Student(2, "Jeff", 10);
	        Student studentObj3 = new Student(3, "John", 5);
	 
	        System.out.println("\n=======CREATE RECORDS=======");
	        StudentDAo.createRecord(studentObj1);
	        StudentDAo.createRecord(studentObj2);
	        StudentDAo.createRecord(studentObj3);
	 
	        System.out.println("\n=======READ RECORDS=======");
	        List<Student> viewStudent = StudentDAo.displayRecords();
	        for(Student student : viewStudent) {
	            System.out.println(student.toString()); 
	        }
	 
		
		  System.out.println("\n=======UPDATE RECORDS=======");
		  studentObj1.setStudentAge(25);
		  studentObj1.setStudentName("Jackson");
		  StudentDAo.updateRecord(studentObj1);
		  System.out.println("\n=======READ RECORDS AFTER UPDATION=======");
		  List<Student> updateStudent = StudentDAo.displayRecords();
		  for(Student student : updateStudent) { 
			  System.out.println(student.toString());
			  }
		 
	 
		
		  System.out.println("\n=======DELETE RECORD=======");
		  StudentDAo.deleteRecord(studentObj2.getStudentId());
		  System.out.println("\n=======READ RECORDS AFTER DELETION=======");
		  List<Student> deleteStudentRecord = StudentDAo.displayRecords();
		  for(Student student : deleteStudentRecord) {
			  System.out.println(student.toString());
			  }
		  
		  System.out.println("\n=======DELETE ALL RECORDS=======");
		  StudentDAo.deleteAllRecords();
		  System.out.println("\n=======READ RECORDS AFTER ALL RECORDS DELETION=======" );
		  List<Student> deleteAll = StudentDAo.displayRecords();
		  for(Student student: deleteAll) {
			  System.out.println(student.toString()); 
			  }
		 
	}

}
