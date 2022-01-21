package com.assessment.hospital.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.assessment.hospital.entity.Doctor;
import com.assessment.hospital.service.DoctorService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@PostMapping("/adddoctor")
	public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
		Doctor doctor1 = doctorService.addDoctor(doctor); 
		return new ResponseEntity<>(doctor1, HttpStatus.CREATED);
	}

	@GetMapping("/getdoctor")
	public ResponseEntity<List<String>> getAllDoctor() {
		List<String> allDoctor = doctorService.getAllDoctor();	
		List<String> specialization = doctorService.getAllSpecialization();
		List<String> doctor = new ArrayList<String>();
		for (int i = 0; i < allDoctor.size(); i++) {
			doctor.add(allDoctor.get(i)+"["+specialization.get(i)+"]");
		}
		return ResponseEntity.ok(doctor);
	}
	
	@GetMapping("/getdoctorspec")
	public ResponseEntity<List<String>> getAllSpecialization() {
		List<String> specialization = doctorService.getAllSpecialization();
		return ResponseEntity.ok(specialization);
	}
	
	@GetMapping("/getdoctor/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") int id) {
		Optional<Doctor> doc = doctorService.getById(id);
		return ResponseEntity.ok(doc);
	}

	@GetMapping("/getdoctorbyname/{name}")
	public ResponseEntity<?> getByName(@PathVariable("name") String docName) {
		docName.trim();
		if(docName.endsWith(" "))
			docName.strip();
		
		Doctor doc = doctorService.getByName(docName);
		return ResponseEntity.ok(doc);
	}

	@PutMapping("/updatedoctor")
	public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor) {
		Doctor doctor1 = doctorService.updateDoctor(doctor); 
		return new ResponseEntity<>(doctor1, HttpStatus.OK);
	} 
	
	@DeleteMapping("/deletedoctor/{id}")
	public ResponseEntity<?> deleteDoctor(@PathVariable("id") long id) {
		boolean deleted = doctorService.deleteDoctor(id);
		return new ResponseEntity<>(deleted, HttpStatus.OK);
	}
	
}
