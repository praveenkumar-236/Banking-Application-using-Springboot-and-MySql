package com.tgi.springBanking.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.tgi.springBanking.Entity.Organisation;
import com.tgi.springBanking.Entity.OrganisationRequestDto;
import com.tgi.springBanking.Entity.OrganisationResponseDto;

public interface OrganisationService {

	public  List<OrganisationResponseDto> getAll();
	public ResponseEntity<?> createOrg(OrganisationRequestDto organisationDto);

	public ResponseEntity<?> getOrganisationByid(Long id);

	public ResponseEntity<?> updateOrganisation(OrganisationRequestDto organisationDto,Long id);
	public ResponseEntity<?> deleteOrg(Long id);

	


}
