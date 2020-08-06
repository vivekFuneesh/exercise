package com.vivek.viewtestthym.dto;

import java.util.List;

public class MedicineDataListDto {

	private List<MedicineDataDto> medicList;

	private String shopName;
	
	
	public List<MedicineDataDto> getMedicList() {
		return medicList;
	}

	public void setMedicList(List<MedicineDataDto> medicList) {
		this.medicList = medicList;
	}
	
	public void add(MedicineDataDto md) {
		this.getMedicList().add(md);
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	
	
}
