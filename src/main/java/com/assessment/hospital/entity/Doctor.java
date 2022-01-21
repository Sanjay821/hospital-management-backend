package com.assessment.hospital.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/*Doctors can be categorized based on their specialist. 
Each doctor has id , name , age , gender and specialist fields.*/
@Entity
@Table(name = "doctor")
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Column(name = "doc_name")
	private String name;
	
	@Column(name = "doc_age")
	private int age;
	
	@Column(name = "doc_gender")
	private char gender;
	
	@Column(name = "doc_specialization")
	private String specialization;
	
	@OneToMany( mappedBy = "doc")
	@JsonBackReference
	private List<Patients> patient;
	
	public Doctor() {
		// TODO Auto-generated constructor stub
	}

	public Doctor(long id, String name, int age, char gender, String specialization, List<Patients> patient) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.specialization = specialization;
		this.patient = patient;
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

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public List<Patients> getPatient() {
		return patient;
	}

	public void setPatient(List<Patients> patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", specialization="
				+ specialization + ", patient=" + patient + "]";
	}
	
}
