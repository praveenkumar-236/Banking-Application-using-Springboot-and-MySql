package com.tgi.springBanking.Service;


import java.util.List;

import org.springframework.http.ResponseEntity;

import com.tgi.springBanking.Entity.CustomerRequestDto;
import com.tgi.springBanking.Entity.CustomerResponseDto;

public interface CustomerService {

	public List<CustomerResponseDto> getcustomer();

	public ResponseEntity<?> createCustomer(CustomerRequestDto customerDto);

	public ResponseEntity<?> getCustomerByid(Long id);

	public ResponseEntity<?> updateCustomer(CustomerRequestDto customerDto,Long id);

	public ResponseEntity<?> deleteCustomer(Long id);
	

}
