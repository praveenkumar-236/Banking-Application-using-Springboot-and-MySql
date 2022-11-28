package com.tgi.springBanking.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.tgi.springBanking.Entity.Staff;
import com.tgi.springBanking.Entity.StaffRequestDto;
import com.tgi.springBanking.Entity.StaffResponseDto;

public interface StaffService {

	public List<StaffResponseDto> getAll();

	public ResponseEntity<?> createStaff(StaffRequestDto staffDto);

	public ResponseEntity<?>  getStaffById(Long id);

	public ResponseEntity<?> updateStaff(StaffRequestDto staffDto,Long id);

	StaffResponseDto addStafftoStaffDto(Staff staff);

	public ResponseEntity<?> deleteStaff(Long id);

}
