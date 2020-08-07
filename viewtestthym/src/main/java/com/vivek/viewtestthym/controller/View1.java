package com.vivek.viewtestthym.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.vivek.viewtestthym.dto.MedicineDataDto;
import com.vivek.viewtestthym.dto.MedicineDataListDto;

@Controller
@SessionAttributes("medL")
public class View1 {

	
	@GetMapping({"/home","/"})
	public String getHome(Model model) {
		return "index";
	}
	
	@GetMapping({"/OpenStore"})
	public String getStore(Model model) {
		
		
		model.addAttribute("medic", new MedicineDataDto() );
		return "store";
	}
	
	@GetMapping({"/OpenStoreList"})
	public String getStoreList(Model model) {
		
		MedicineDataDto md1=new MedicineDataDto();//md1.setName("name1");
		MedicineDataDto md2=new MedicineDataDto();//md2.setName("name2");
		
		List<MedicineDataDto> medicineList=new ArrayList<MedicineDataDto>();
		medicineList.add(md1);
		medicineList.add(md2);
		
		MedicineDataListDto mldto=new MedicineDataListDto();
		mldto.setMedicList(medicineList);
		
		model.addAttribute("medL", mldto );
		return "StoreList";
	}
	
	
	@GetMapping("/addMedicineDataRow")
	public String addMedicineDataRow(@ModelAttribute("medL") MedicineDataListDto medListDto, BindingResult br) {
		System.out.println("Inside add row");
		List<MedicineDataDto> medList=medListDto.getMedicList();
		System.out.println((medList!=null?medList.size():0)+" "+medListDto.getShopName());
		//System.out.println(med.getName() +" "+ med.getMktd_By() +" "+ med.getMfg_By()+" "+ med.getChemicals() +" "+med.getAny_other_note());		
		if(medList!=null)
		medList.forEach(md -> System.out.println(md.getName() +" "+ md.getMktd_By() +" "+ md.getMfg_By()+" "+ md.getChemicals() +" "+md.getAny_other_note()));
		
		medListDto.add(new MedicineDataDto());
		return "StoreList";
	}
	
	
	@GetMapping("/deleteMedicineDataRow")
	public String deleteMedicineDataRow(Model model, @RequestParam("delete") int deleteIndex) {
		System.out.println("Inside DELETE row");
		MedicineDataListDto medListDto=((MedicineDataListDto)model.getAttribute("medL"));
		List<MedicineDataDto> medList=medListDto.getMedicList();
		System.out.println((medList!=null?medList.size():0)+" "+medListDto.getShopName());
		//System.out.println(med.getName() +" "+ med.getMktd_By() +" "+ med.getMfg_By()+" "+ med.getChemicals() +" "+med.getAny_other_note());		
		if(medList!=null)
		medList.forEach(md -> System.out.println(md.getName() +" "+ md.getMktd_By() +" "+ md.getMfg_By()+" "+ md.getChemicals() +" "+md.getAny_other_note()));
		
		medList.remove(deleteIndex);
		return "StoreList";
	}
	
	
}
