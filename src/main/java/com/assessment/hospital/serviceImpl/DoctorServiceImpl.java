package com.assessment.hospital.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.hospital.entity.Doctor;
import com.assessment.hospital.repository.DoctorRepository;
import com.assessment.hospital.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	public Doctor addDoctor(Doctor doctor) {
		if(doctorRepository.findByName(doctor.getName()) != null) {
			long id = doctorRepository.count()+1;
			doctor.setName(doctor.getName()+"(id"+id+")");
			Doctor savedDoctor = doctorRepository.save(doctor);
			return savedDoctor;
		}
		else {
		 Doctor savedDoctor = doctorRepository.save(doctor);
		 return savedDoctor;
		}
	}

	@Override
	public List<String> getAllDoctor() {
		List<String> doctors = doctorRepository.findAllByName();
		return doctors;
	}

	@Override
	public Optional<Doctor> getById(long id) {
		Optional<Doctor> doctor = doctorRepository.findById(id);
		return doctor;
	}
	
	@Override
	public Doctor getByName(String docName) {
		Doctor doctor = doctorRepository.findByName(docName);
		return doctor;
	}

	@Override
	public List<String> getAllSpecialization() {
		List<String> specialization = doctorRepository.findAllBySpecialization();
		return specialization;
	}
}
