package com.assessment.hospital;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.http.MediaType;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.assessment.hospital.controller.PatientsController;
import com.assessment.hospital.entity.Doctor;
import com.assessment.hospital.entity.Patients;
import com.assessment.hospital.service.DoctorService;
import com.assessment.hospital.service.PatientsService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(PatientsController.class)
class PatientTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PatientsService patientService;

	@MockBean
	private DoctorService doctorService;

	private static ObjectMapper mapper = new ObjectMapper();

	@Test
	void addPatient() throws Exception {
		Doctor doctor = new Doctor();
		doctor.setId(1);
		doctor.setName("sanjay");
		doctor.setAge(34);
		doctor.setGender('m');
		doctor.setSpecialization("Dentist");

		Patients patient = new Patients();
		patient.setId(1);
		patient.setName("Ajay");
		patient.setAge(43);
		patient.setDate("3-3-2000");
		patient.setDoc(doctor);

		Mockito.when(patientService.addPatients(ArgumentMatchers.any())).thenReturn(patient);
		String json = mapper.writeValueAsString(patient);
		mockMvc.perform(post("http://localhost:8282/patients/addpatient").contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("utf-8").content(json).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
	}


	@Test
	public void getCountOfDoctor() throws Exception {
		Mockito.when(patientService.getcount(ArgumentMatchers.any())).thenReturn(4);
		mockMvc.perform(get("http://localhost:8282/patients/getcount/Sanjay")).andExpect(status().isOk());
	}

}
