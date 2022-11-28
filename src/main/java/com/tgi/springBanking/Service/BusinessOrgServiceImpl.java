package com.tgi.springBanking.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tgi.springBanking.Entity.BusinessOrgRequestDto;
import com.tgi.springBanking.Entity.BusinessOrgResponseDto;
import com.tgi.springBanking.Entity.BusinessOrganisation;
import com.tgi.springBanking.Exception.ResourceNotFoundException;
import com.tgi.springBanking.Repository.BusinessOrgRepository;
import com.tgi.springBanking.Utility.ValidatorUtil;
import com.tgi.springBanking.enums.BusinessOrgStatus;

@Service
public class BusinessOrgServiceImpl implements BusinessOrgService {
	@Autowired 
	BusinessOrgRepository businessOrgRepository;

	@Override
	public List<BusinessOrgResponseDto> getAllBusinessorg() {
		List<BusinessOrganisation>businessOrganisation=businessOrgRepository.findAllByStatus(BusinessOrgStatus.ActiveStatus);
        List<BusinessOrgResponseDto>BusinessOrgList=new ArrayList<BusinessOrgResponseDto>(businessOrganisation.size());
        for(BusinessOrganisation u:businessOrganisation) {
        	BusinessOrgList.add(addBusinessOrgtoBusinessRequestDto(u));
        }
		return BusinessOrgList;
	}

	private BusinessOrgResponseDto addBusinessOrgtoBusinessRequestDto(BusinessOrganisation businessOrganisation) {
		BusinessOrgResponseDto businessOrgResponseDto=new BusinessOrgResponseDto();	
		businessOrgResponseDto.setOrgName(businessOrganisation.getOrgName());
		businessOrgResponseDto.setOrgType(businessOrganisation.getOrgType());
		businessOrgResponseDto.setStatus(businessOrganisation.getStatus());
		businessOrgResponseDto.setPhoneNumber(businessOrganisation.getPhoneNumber());
		businessOrgResponseDto.setContactEmail(businessOrganisation.getContactEmail());
		businessOrgResponseDto.setAddress(businessOrganisation.getAddress());
		return businessOrgResponseDto;
	}

	@Override
	public ResponseEntity<?> createBusinessOrg(BusinessOrgRequestDto BusinessDto) {
		
		boolean phonevalid=ValidatorUtil.PhoneNumberIsValid(BusinessDto.getPhoneNumber());
		if(phonevalid) {
			System.out.println(phonevalid+""+"phone Number isvalid");
		}else {
			System.out.println(phonevalid+""+"phone Numberis Invalid");
			Map<String, Object> response = new HashMap<>();
			response.put("messgee", "Invalid phone Number");
			response.put("ErrorCode", HttpStatus.BAD_REQUEST);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		
		
     
		BusinessOrganisation businessOrganisation=new BusinessOrganisation();
		businessOrganisation.setOrgName(BusinessDto.getOrgName());
		businessOrganisation.setOrgType(BusinessDto.getOrgType());
		businessOrganisation.setStatus(BusinessDto.getStatus());
		businessOrganisation.setPhoneNumber(BusinessDto.getPhoneNumber());
		businessOrganisation.setContactEmail(BusinessDto.getContactEmail());
		businessOrganisation.setAddress(BusinessDto.getAddress());
		businessOrganisation=businessOrgRepository.save(businessOrganisation);
		
		BusinessOrgResponseDto businessOrgResponseDto=new BusinessOrgResponseDto();
		businessOrgResponseDto.setOrgName(businessOrganisation.getOrgName());
		businessOrgResponseDto.setOrgType(businessOrganisation.getOrgType());
		businessOrgResponseDto.setPhoneNumber(businessOrganisation.getPhoneNumber());
		businessOrgResponseDto.setContactEmail(businessOrganisation.getContactEmail());
		businessOrgResponseDto.setAddress(businessOrganisation.getAddress());
		

		return new ResponseEntity(businessOrgResponseDto,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getBusinessByid(Long id) {
		
		BusinessOrganisation businessOrganisation=businessOrgRepository.findByIdAndStatus(id,BusinessOrgStatus.ActiveStatus)
				.orElseThrow(() -> new ResourceNotFoundException("businessorg not found this id :"+id));
		
		return new ResponseEntity(businessOrganisation,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> updateBusiness(BusinessOrgRequestDto businessDto,Long id) {
		BusinessOrganisation businessOrganisation=businessOrgRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("businessorg not found this id :"+id));
		
		businessOrganisation.setOrgName(businessDto.getOrgName());
		businessOrganisation.setOrgType(businessDto.getOrgType());
		businessOrganisation.setStatus(businessDto.getStatus());
		businessOrganisation.setPhoneNumber(businessDto.getPhoneNumber());
		businessOrganisation.setContactEmail(businessDto.getContactEmail());
		businessOrganisation.setAddress(businessDto.getAddress());
		businessOrgRepository.save(businessOrganisation);
		
		return new ResponseEntity(businessDto,HttpStatus.OK);
	}
	
	
	

}
