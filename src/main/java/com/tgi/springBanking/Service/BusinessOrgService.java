package com.tgi.springBanking.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.tgi.springBanking.Entity.BusinessOrgRequestDto;
import com.tgi.springBanking.Entity.BusinessOrgResponseDto;


public interface BusinessOrgService {

	public List<BusinessOrgResponseDto> getAllBusinessorg();

	public ResponseEntity<?> createBusinessOrg(BusinessOrgRequestDto BusinessDto);

	public ResponseEntity<?> getBusinessByid(Long id);

	public ResponseEntity<?> updateBusiness(BusinessOrgRequestDto businessDto,Long id);

}
