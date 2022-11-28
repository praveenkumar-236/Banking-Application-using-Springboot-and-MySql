package com.tgi.springBanking.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tgi.springBanking.Entity.Staff;
import com.tgi.springBanking.Entity.StaffRequestDto;
import com.tgi.springBanking.Entity.StaffResponseDto;
import com.tgi.springBanking.Exception.ResourceNotFoundException;
import com.tgi.springBanking.Repository.StaffRepository;
import com.tgi.springBanking.enums.StaffStatus;

@Service
public class StaffServiceImpl implements StaffService {
	
	@Autowired
	StaffRepository staffRepository;

	@Override
	public List<StaffResponseDto> getAll() {
	List<Staff>staff=staffRepository.findAllByStatus(StaffStatus.ActiveStatus);
    List<StaffResponseDto>StaffList=new ArrayList<StaffResponseDto>(staff.size());
    for(Staff u:staff) {
    	StaffList.add( addStafftoStaffDto( u ) );
    }
      
		return StaffList;
	}
	@Override
	public StaffResponseDto addStafftoStaffDto(Staff staff) {
		StaffResponseDto staffResponseDto=new StaffResponseDto();
		staffResponseDto.setEmployeeCode(staff.getEmployeeCode());
		staffResponseDto.setName(staff.getName());
		staffResponseDto.setAddress(staff.getAddress());
		staffResponseDto.setStatus(staff.getStatus());
		return staffResponseDto;
	}

	@Override
	public ResponseEntity<?> createStaff(StaffRequestDto staffDto) {
		
		
		Staff st=staffRepository.findByname(staffDto.getName());
		if(st!=null) {
			return new ResponseEntity("Name is already exist",HttpStatus.OK);
		}
		
		Staff staff1=new Staff();
	
		staff1.setEmployeeCode(staffDto.getEmployeeCode());
		staff1.setName(staffDto.getName());
		staff1.setAddress(staffDto.getAddress());
		staff1.setStatus(true);
		staff1=staffRepository.save(staff1);
		
		StaffResponseDto staffResponseDto=new StaffResponseDto();
		staffResponseDto.setName(staff1.getName());
		staffResponseDto.setEmployeeCode(staff1.getEmployeeCode());
		staffResponseDto.setAddress(staff1.getAddress());
		staffResponseDto.setStatus(staff1.getStatus());
		
		
		return new ResponseEntity(staffResponseDto,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getStaffById(Long id) {
		Staff staff=staffRepository.findByIdAndStatus(id,StaffStatus.ActiveStatus)
				.orElseThrow(() -> new ResourceNotFoundException("Staff not found this id "));
		

		return new ResponseEntity(staff,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> updateStaff(StaffRequestDto staffDto,Long id) {
		//validation added

		
		Staff staff=staffRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Staff not found this id "));
		
	
		staff.setEmployeeCode(staffDto.getEmployeeCode());
		staff.setName(staffDto.getName());
		staff.setAddress(staffDto.getAddress());
		staff.setStatus(staffDto.getStatus());
		staffRepository.save(staff);
		
		return new ResponseEntity(staff,HttpStatus.OK);
	}
	@Override
	public ResponseEntity<?> deleteStaff(Long id) {
		Staff staff=staffRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Staff delete id Not found "+id));
		staffRepository.delete(staff);
		return new ResponseEntity(staff,HttpStatus.OK); 
	}

}
