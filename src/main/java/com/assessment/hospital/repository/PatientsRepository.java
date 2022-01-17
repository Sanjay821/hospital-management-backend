package com.assessment.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.assessment.hospital.entity.Doctor;
import com.assessment.hospital.entity.Patients;

public interface PatientsRepository extends JpaRepository<Patients, Long> {

	@Query("Select count(p.doc) from Patients p where p.doc=?1")
	int countDoctorByName(Doctor doc);
}
