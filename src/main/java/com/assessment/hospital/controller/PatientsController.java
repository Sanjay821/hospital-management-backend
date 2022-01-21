package com.assessment.hospital.controller;

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
import com.assessment.hospital.entity.Patients;
import com.assessment.hospital.service.DoctorService;
import com.assessment.hospital.service.PatientsService;

@RestController
@CrossOrigin
@RequestMapping("/patients")
public class PatientsController {

	@Autowired
	private PatientsService patientService;
	@Autowired
	private DoctorService doctorService;
	
	@PostMapping("/addpatient")
	public ResponseEntity<Patients> addPatients(@RequestBody Patients patient) {
		Patients patient1 = patientService.addPatients(patient);
		return new ResponseEntity<>(patient1, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/getpatient/{id}")
	public ResponseEntity<?> getPatientsById(@PathVariable("id") long id) {
		Optional<Patients> patient = patientService.getPatientByid(id);
		return ResponseEntity.ok(patient);
	}
	
	@GetMapping("/getcount/{name}")
	public int getCountOfDoctor(@PathVariable("name") String name) {
		Doctor doctor = doctorService.getByName(name);
		int count = patientService.getcount(doctor);
		return count;
	}
	
	@PutMapping("/updatepatient")
	public ResponseEntity<Patients> updatePatients(@RequestBody Patients patient) {
		Patients patient1 = patientService.updatePatients(patient);
		return new ResponseEntity<>(patient1, HttpStatus.OK);
	}
	
	@DeleteMapping("/deletepatient/{id}")
	public ResponseEntity<?> deletePatient(@PathVariable("id") long id) {
		boolean deleted = patientService.deletePatient(id);
		return new ResponseEntity<>(deleted, HttpStatus.OK);
	}
}
