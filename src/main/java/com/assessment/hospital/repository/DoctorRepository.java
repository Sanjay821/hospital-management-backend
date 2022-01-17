package com.assessment.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.assessment.hospital.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

 	Doctor findByName(String name);
 	
	@Query("Select d.name from Doctor d")
	List<String> findAllByName();
	
	@Query("Select d.specialization from Doctor d")
	List<String> findAllBySpecialization();
}
