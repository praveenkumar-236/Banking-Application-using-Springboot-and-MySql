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

import com.tgi.springBanking.Entity.Staff;
import com.tgi.springBanking.Entity.StaffRequestDto;
import com.tgi.springBanking.Entity.StaffResponseDto;
import com.tgi.springBanking.Service.StaffService;

@RestController
@RequestMapping("/Employee")
public class StaffController {
	
	@Autowired
	StaffService staffService;
	
	
	@RequestMapping(value="/getStaff",method=RequestMethod.GET)
	public List<StaffResponseDto> getAllRole() {
		return staffService.getAll();
	}
	@RequestMapping(value="/createStaff",method=RequestMethod.POST)
	public ResponseEntity<?> createStaff( @RequestBody StaffRequestDto staffDto) {
		
		return staffService.createStaff(staffDto);
	}
	@RequestMapping(value="/StaffById/{id}",method=RequestMethod.GET)
    public ResponseEntity<?> getStaffById(@PathVariable("id")Long id) {
    return staffService.getStaffById(id);
    }
	@RequestMapping(value="/StaffRole",method=RequestMethod.PUT)
    public ResponseEntity<?> updateStaff(@RequestBody StaffRequestDto staffDto,Long id) {
		return staffService.updateStaff(staffDto,id);
	}
	@RequestMapping(value="/deleteStaff/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<?>deleteStaff(@PathVariable("id")Long id){
		return staffService.deleteStaff(id);
	}

}
