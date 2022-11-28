package com.tgi.springBanking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tgi.springBanking.Entity.BusinessOrgRequestDto;
import com.tgi.springBanking.Entity.BusinessOrgResponseDto;

import com.tgi.springBanking.Service.BusinessOrgService;

@RestController
@RequestMapping("/businessorg")
public class BusinessOrgController {
	@Autowired
	BusinessOrgService businessOrgService;
	
	@RequestMapping(value = "/getAllBusinessorg", method = RequestMethod.GET)
	public List<BusinessOrgResponseDto> getAllBusinessorg(){
		
		return businessOrgService.getAllBusinessorg();
	}
	@RequestMapping(value = "/getAllBusinessorg", method = RequestMethod.POST)
	public ResponseEntity<?> createBusinessOrg(@RequestBody BusinessOrgRequestDto BusinessDto){
		return businessOrgService.createBusinessOrg(BusinessDto);
	}
	@RequestMapping(value = "/getBusinessByid/{id}", method = RequestMethod.GET)
	public ResponseEntity<?>getBusinessByid(@PathVariable ("id")Long id){
		return businessOrgService.getBusinessByid(id);
	}
	@RequestMapping(value = "/getBusinessByid/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?>updateBusiness(@RequestBody BusinessOrgRequestDto BusinessDto,Long id){
		return businessOrgService.updateBusiness(BusinessDto,id);
	}
	

}
