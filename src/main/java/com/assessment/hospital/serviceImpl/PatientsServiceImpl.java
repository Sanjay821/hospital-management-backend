package com.assessment.hospital.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.hospital.entity.Doctor;
import com.assessment.hospital.entity.Patients;
import com.assessment.hospital.repository.PatientsRepository;
import com.assessment.hospital.service.PatientsService;

@Service
public class PatientsServiceImpl implements PatientsService {

	@Autowired
	private PatientsRepository patientRepository;

	@Override
	public Patients addPatients(Patients patient) {
			return patientRepository.save(patient);
	}

	@Override
	public List<Patients> getAllPatients() {
		return patientRepository.findAll();
	}

	@Override
	public Optional<Patients> getPatientByid(long id) {
		return patientRepository.findById(id);
	}

	@Override
	public int getcount(Doctor doc) {
		return patientRepository.countDoctorByName(doc);
	}

	@Override
	public Patients updatePatients(Patients patient) {
		return patientRepository.save(patient);
	}

	@Override
	public boolean deletePatient(long id) {
		if (patientRepository.findById(id) != null) {
			patientRepository.deleteById(id);
			return true;
		}
		else
			return false;
	}
}
