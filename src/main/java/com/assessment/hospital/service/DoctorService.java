package com.assessment.hospital.service;

import java.util.List;
import java.util.Optional;

import com.assessment.hospital.entity.Doctor;

public interface DoctorService {

	Doctor addDoctor(Doctor doctor);

	List<String> getAllDoctor();

	Optional<Doctor> getById(long id);

	Doctor getByName(String docName);

	List<String> getAllSpecialization();

}
