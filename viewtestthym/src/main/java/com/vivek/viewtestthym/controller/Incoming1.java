package com.vivek.viewtestthym.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import com.vivek.viewtestthym.dto.MedicineDataDto;
import com.vivek.viewtestthym.dto.MedicineDataListDto;
import com.vivek.viewtestthym.dto.PersonDto;
import com.vivek.viewtestthym.dto.PrescribedMedicineDto;

@RestController
public class Incoming1 {

	

	@GetMapping("/store/")
	public void getMedicineData(@ModelAttribute("medic") MedicineDataDto med, BindingResult br) {
		System.out.println(med+"list.size()");
		System.out.println(med.getName() +" "+ med.getMktd_By() +" "+ med.getMfg_By()+" "+ med.getChemicals() +" "+med.getAny_other_note());		
		//list.forEach(md -> System.out.println(md.getName() +" "+ md.getMktd_By() +" "+ md.getMfg_By()+" "+ md.getChemicals() +" "+md.getAny_other_note()));
	}
	
	@GetMapping("/storeList/")
	public void getMedicineDataList(@ModelAttribute("medL") MedicineDataListDto medListDto, BindingResult br) {
		List<MedicineDataDto> medList=medListDto.getMedicList();
		System.out.println((medList!=null?medList.size():0)+" "+medListDto.getShopName());
		//System.out.println(med.getName() +" "+ med.getMktd_By() +" "+ med.getMfg_By()+" "+ med.getChemicals() +" "+med.getAny_other_note());		
		if(medList!=null)
		medList.forEach(md -> System.out.println(md.getName() +" "+ md.getMktd_By() +" "+ md.getMfg_By()+" "+ md.getChemicals() +" "+md.getAny_other_note()));
	}
	
	
	
	
	
	
	@GetMapping("/add/")
	public void getData(PersonDto pdto) {
		System.out.println("Person Object "+pdto+"\n");
		System.out.println(pdto.getName()+" "+pdto.getPhone());
		System.out.println("\n prescriptions set "+pdto.getPrescribed_medicines()+" "+pdto.getPrescribed_medicines().size()+"\n");
		
		Iterator<PrescribedMedicineDto> itr=pdto.getPrescribed_medicines().iterator();
		
		for(int i=0;i<pdto.getPrescribed_medicines().size();i++) {
			if(pdto.getPrescribed_medicines().get(i).getDosage_amount()==-1) {
				pdto.getPrescribed_medicines().remove(i);i--;
			}
		}
		itr=pdto.getPrescribed_medicines().iterator();
		while(itr.hasNext()) {
			PrescribedMedicineDto pm=itr.next();
			
			System.out.println("\n	prescribed medicine"+pm+"\n");
			System.out.println("::"+pm.getTimings()+" "+(pm.getDosage_amount()==null?"op":"0")+"::");
			
			MedicineDataDto md=pm.getMd();
			System.out.println("\n 	 medicine data"+md);
			System.out.println(":: 	 "+md.getName()+" "+md.getMktd_By()+" "+md.getMfg_By()+" "+md.getChemicals()+" "+md.getAny_other_note()+"::");
			
		}
		
	}
	
	
}
