package com.vivek.viewtestthym.dto;


public class PrescribedMedicineDto {

	private Double dosage_amount;

	private String timings;

	private MedicineDataDto md;

	
	public Double getDosage_amount() {
		return dosage_amount;
	}

	public void setDosage_amount(Double dosage_amount) {
		this.dosage_amount = dosage_amount;
	}

	public String getTimings() {
		return timings;
	}

	public void setTimings(String timings) {
		this.timings = timings;
	}

	public MedicineDataDto getMd() {
		return md;
	}

	public void setMd(MedicineDataDto md) {
		this.md = md;
	}

}
