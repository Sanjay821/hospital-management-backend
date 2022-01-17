package com.assessment.hospital.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.*;

/*Patients can be allowed to visit doctor for consultation. 
Each patient has properties like id, name , visitedDoctor, dateOfVisit.*/
@Entity
@Table(name = "PATIENTS")
public class Patients {

	@Id
	@GenericGenerator(name = "sequence", strategy = "sequence", parameters = {
			          @Parameter(name = "sequenceName", value = "sequence"),
			          @Parameter(name = "allocationSize", value = "1")
			          })
	@GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
	private long id;

	@Column(name = "Patient_Name")
	private String name;

	@Column(name = "Patient_age")
	private int age;
	
	@Column(name = "Date_of_visit")
	private String date;

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "doc_id", referencedColumnName = "id")
	// @JsonManagedReference
	private Doctor doc;

	public Patients() {
		// TODO Auto-generated constructor stub
	}

	public Patients(long id, String name, int age, String date, Doctor doc) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.date = date;
		this.doc = doc;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Doctor getDoc() {
		return doc;
	}

	public void setDoc(Doctor doc) {
		this.doc = doc;
	}

	@Override
	public String toString() {
		return "Patients [id=" + id + ", name=" + name + ", age=" + age + ", date=" + date + ", doc=" + doc + "]";
	}
	
}	