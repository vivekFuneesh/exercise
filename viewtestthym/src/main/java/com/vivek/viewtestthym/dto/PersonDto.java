package com.vivek.viewtestthym.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class PersonDto {

	private String name;
	
	private String phone;
	
	private List< PrescribedMedicineDto> prescribed_medicines ;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<PrescribedMedicineDto> getPrescribed_medicines() {
		return prescribed_medicines;
	}

	public void setPrescribed_medicines(List<PrescribedMedicineDto> prescribed_medicines) {
		this.prescribed_medicines = prescribed_medicines;
	}

	
	
}
