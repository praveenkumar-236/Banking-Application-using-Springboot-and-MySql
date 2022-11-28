package com.tgi.springBanking.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tgi.springBanking.Entity.Organisation;
import com.tgi.springBanking.Entity.OrganisationRequestDto;
import com.tgi.springBanking.Entity.OrganisationResponseDto;
import com.tgi.springBanking.Exception.ResourceNotFoundException;
import com.tgi.springBanking.Repository.AccountRepository;
import com.tgi.springBanking.Repository.OrganisationRepository;
import com.tgi.springBanking.Utility.ValidatorUtil;
import com.tgi.springBanking.enums.OrganisationStatus;

@Service
public class OrganisationServiceImpl implements OrganisationService {
	@Autowired
	OrganisationRepository organisationRepository;
	@Autowired
	AccountRepository accountRepository;

	@Override
	public List<OrganisationResponseDto> getAll() {
        List<Organisation>organisation=organisationRepository.findAllByStatus(OrganisationStatus.ActiveStatus);
		List<OrganisationResponseDto> OrganisationList = new ArrayList<OrganisationResponseDto>(organisation.size());
	    for(Organisation u:organisation) {
	    	OrganisationList.add( addOrganisationtoOrganisationDto( u ) );
	    }
		return OrganisationList;

	}

	public  OrganisationResponseDto addOrganisationtoOrganisationDto(Organisation Organisation) {
		OrganisationResponseDto organisationResponseDto=new OrganisationResponseDto();
		organisationResponseDto.setAddress(Organisation.getAddress());
		organisationResponseDto.setMailId(Organisation.getMailId());
		organisationResponseDto.setOrgName(Organisation.getOrgName());
		organisationResponseDto.setOrgType(Organisation.getOrgType());
		organisationResponseDto.setPhoneNumber(Organisation.getPhoneNumber());
		organisationResponseDto.setStatus(Organisation.getStatus());
		
		return organisationResponseDto;
	}

	@Override
	public ResponseEntity<?> createOrg(OrganisationRequestDto organisationDto) {
		//random number generation orgcode entity
		
//		Random random=new Random();
//		Long ran=(long) random.nextInt(200);
//		organisation.setOrgCode(ran);
		
		//validation
		Organisation org=organisationRepository.findByorgName(organisationDto.getOrgName());
		if (org !=null){
              return new ResponseEntity("organisation Name is already exist",HttpStatus.OK);			
		}

		
		//phone number validation
		boolean phonevalid=ValidatorUtil.PhoneNumberIsValid(organisationDto.getPhoneNumber());
		if(phonevalid) {
			System.out.println(phonevalid+""+"phone Number is valid");
		}else {
			System.out.println(phonevalid+""+"phone Numberis Invalid");
			Map<String, Object> response = new HashMap<>();
			response.put("messgee", "Invalid phone Number");
			response.put("ErrorCode", HttpStatus.BAD_REQUEST);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		//dto 
		
		Organisation organisaton1=new Organisation();
		
		organisaton1.setOrgName(organisationDto.getOrgName());
		organisaton1.setMailId(organisationDto.getMailId());
		organisaton1.setPhoneNumber(organisationDto.getPhoneNumber());
		organisaton1.setOrgType(organisationDto.getOrgType());
		//organisaton1.setAccount(accountRepository.getById(organisationDto.getAccountId()));
		organisaton1.setAddress(organisationDto.getAddress());
		organisaton1.setStatus(true);
		organisaton1=organisationRepository.save(organisaton1);
		//ResponseDto
		
		
		OrganisationResponseDto organisationResponseDto=new OrganisationResponseDto();

		organisationResponseDto.setOrgName(organisaton1.getOrgName());
		organisationResponseDto.setMailId(organisaton1.getMailId());
		organisationResponseDto.setPhoneNumber(organisaton1.getPhoneNumber());
		organisationResponseDto.setOrgType(organisaton1.getOrgType());
		organisationResponseDto.setAddress(organisaton1.getAddress());
		organisationResponseDto.setStatus(organisaton1.getStatus());

		
	

		return new ResponseEntity(organisationResponseDto,HttpStatus.OK);
	}
	

	@Override
	public ResponseEntity<?> getOrganisationByid(Long id) {
		Organisation organisation=organisationRepository.findByIdAndStatus(id,OrganisationStatus.ActiveStatus)
				.orElseThrow(() -> new ResourceNotFoundException("Organisation not found this id :"+id));

		return new ResponseEntity(organisation,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> updateOrganisation(OrganisationRequestDto organisationDto,Long id) {
		//validation
        boolean valid = ValidatorUtil.EmailIsValid(organisationDto.getMailId());
		if (valid) {
			System.out.println(valid + " " + " Emailidvalid");
		
		} else {
			System.out.println(valid + " " + " emailidnot valid");
			Map<String, Object> response = new HashMap<>();
			response.put("messgee", "Invalid emailid");
			response.put("ErrorCode", HttpStatus.BAD_REQUEST);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);

		
		}
		
		
		Organisation organisation=organisationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Organisation not found this id :"+id));
		
		

		organisation.setOrgName(organisationDto.getOrgName());
		organisation.setMailId(organisationDto.getMailId());
		organisation.setOrgType(organisationDto.getOrgType());
		organisation.setPhoneNumber(organisationDto.getPhoneNumber());
		organisation.setAddress(organisationDto.getAddress());
		organisation.setStatus(organisationDto.getStatus());
		organisationRepository.save(organisation);
		
		


		return new ResponseEntity(organisation,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> deleteOrg(Long id) {
		
		Organisation organisation=organisationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Organisation delete id not found :"+id));
		organisationRepository.delete(organisation);
		return new ResponseEntity(organisation,HttpStatus.OK);
	}


}
