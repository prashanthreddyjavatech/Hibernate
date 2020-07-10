package com.kprjavatech.hibernate.crud;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

	/*@Entity annotation marks a class as a Hibernate Entity (Mapped class)
	 * 
	 * @Table annotation Maps this class with a database table specified by name modifier.
	 *  If a name is not supplied it maps the class with a table having the same name as the class.
	 *  
	 *  @Id annotation marks the class field as a primary key column.
	 *  
	 * @GeneratedValue	annotation instructs database to generate a value for that field automatically.
	 * 
	 * @Column annotation maps this field with table column specified by name and uses the field name if name modifier is absent.
	 * 
	 * @UniqueConstraint specifies that a unique constraint is to be included in the generated DDL for a primary or secondary table.
	 * */
	

	@Entity
	@Table(name = "STUDENT_DETAILS")
	public class Student {
	 
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "id", length=11, nullable=false, unique=true)
	    private Integer studentId;
	 
	    @Column(name = "name", length=50, nullable=true)
	    private String studentName;
	 
	    @Column(name="age", length=3, nullable=true)
	    private Integer studentAge;
	 
	    public Student() { }
	 
	    public Student(Integer studId, String studName, Integer studAge) {
	        this.studentId = studId;
	        this.studentName = studName;
	        this.studentAge = studAge;
	    }
	 
	    public Integer getStudentId() {
	        return studentId;
	    }
	 
	    public void setStudentId(Integer studentId) {
	        this.studentId = studentId;
	    }
	 
	    public String getStudentName() {
	        return studentName;
	    }
	 
	    public void setStudentName(String studentName) {
	        this.studentName = studentName;
	    }
	 
	    public Integer getStudentAge() {
	        return studentAge;
	    }
	 
	    public void setStudentAge(Integer studentAge) {
	        this.studentAge = studentAge;
	    }
	 
	    //overriding toString method to print the object
	    
	    @Override
	    public String toString() {
	        return "Student= Id: " + this.studentId + ", Name: " + this.studentName + ", Age: " + this.studentAge;
	    }
	
	}
