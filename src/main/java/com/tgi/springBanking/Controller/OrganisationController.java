package com.tgi.springBanking.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tgi.springBanking.Entity.Organisation;
import com.tgi.springBanking.Entity.OrganisationRequestDto;
import com.tgi.springBanking.Entity.OrganisationResponseDto;
import com.tgi.springBanking.Service.OrganisationService;

@RestController
@RequestMapping("/org")
public class OrganisationController {
	@Autowired
	OrganisationService organisationService;
	
	@RequestMapping(value="/getOrganisation",method=RequestMethod.GET)
	public List<OrganisationResponseDto> getAllOrganisation() {
		
		return organisationService.getAll();
	}
	@RequestMapping(value="/createOrganisation",method=RequestMethod.POST)
	public ResponseEntity<?> createOrganisation(@RequestBody OrganisationRequestDto organisationDto) {
		
		return organisationService.createOrg(organisationDto);
	}
	@RequestMapping(value="/OrganisationById/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> getOrganisationById(@PathVariable("id")Long id) {
		
		return organisationService.getOrganisationByid(id);
	}
	@RequestMapping(value="/updateRole",method=RequestMethod.PUT)
    public ResponseEntity<?> updateOrganisation(@RequestBody OrganisationRequestDto organisationDto,Long id) {
		
		return organisationService.updateOrganisation(organisationDto,id);
	}
	@RequestMapping(value="/deleteOrg/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<?>deleteOrg(@PathVariable("id")Long id){
		return organisationService.deleteOrg(id);
	}


}






















