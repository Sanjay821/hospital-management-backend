package com.assessment.hospital.service;

import java.util.List;
import java.util.Optional;

import com.assessment.hospital.entity.Doctor;
import com.assessment.hospital.entity.Patients;

public interface PatientsService {

	Patients addPatients(Patients patient);

	List<Patients> getAllPatients();

	Optional<Patients> getPatientByid(long id);

	int getcount(Doctor doc);

}
