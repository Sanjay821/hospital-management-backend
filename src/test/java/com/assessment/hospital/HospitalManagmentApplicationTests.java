package com.assessment.hospital;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

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

import com.assessment.hospital.controller.DoctorController;
import com.assessment.hospital.entity.Doctor;
import com.assessment.hospital.service.DoctorService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value = DoctorController.class)
class DoctorTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private DoctorService doctorService;

	private static ObjectMapper mapper = new ObjectMapper();

	@Test
	void addDoctor() throws Exception {
		Doctor doctor = new Doctor();
		doctor.setId(1);
		doctor.setName("sanjay");
		doctor.setAge(34);
		doctor.setGender('m');
		doctor.setSpecialization("Dentist");

		Mockito.when(doctorService.addDoctor(ArgumentMatchers.any())).thenReturn(doctor);
		String json = mapper.writeValueAsString(doctor);
		mockMvc.perform(post("http://localhost:8282/doctor/adddoctor").contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("utf-8").content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
	}

	@Test
	void addDoctorNUll() throws Exception {
		Doctor doctor = new Doctor();
		Mockito.when(doctorService.addDoctor(ArgumentMatchers.any())).thenReturn(doctor);
		String json = mapper.writeValueAsString(doctor);
		mockMvc.perform(post("http://localhost:8282/doctor/adddoctor").contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("utf-8").content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
	}
	@Test
	public void getAllName() throws Exception {
		List<String> names = new ArrayList<>();
		names.add("Sanjay");
		names.add("Bhupal");
		names.add("Arun");
		Mockito.when(doctorService.getAllDoctor()).thenReturn(names);
		mockMvc.perform(get("http://localhost:8282/doctor/getdoctor")).andExpect(status().isOk());
	}
	
	@Test
	public void getAllSpecialization() throws Exception {
		List<String> specialization = new ArrayList<>();
		specialization.add("Dentist");
		specialization.add("Cardiologist");
		specialization.add("Radiologists");
		Mockito.when(doctorService.getAllSpecialization()).thenReturn(specialization);
		mockMvc.perform(get("http://localhost:8282/doctor/getdoctorspec")).andExpect(status().isOk());
	}
	
	@Test
	public void getdoctorbyname() throws Exception {
		Doctor doctor = new Doctor();
		doctor.setId(1);
		doctor.setName("sanjay");
		doctor.setAge(34);
		doctor.setGender('m');
		doctor.setSpecialization("Dentist");
		Mockito.when(doctorService.getByName(ArgumentMatchers.any())).thenReturn(doctor);
		mockMvc.perform(get("http://localhost:8282/doctor/getdoctorbyname/sanjay")).andExpect(status().isOk());
	}
	
}
