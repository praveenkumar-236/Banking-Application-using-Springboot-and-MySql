package com.tgi.springBanking.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tgi.springBanking.Entity.Customer;
import com.tgi.springBanking.Entity.CustomerRequestDto;
import com.tgi.springBanking.Entity.CustomerResponseDto;
import com.tgi.springBanking.Service.CustomerService;

@RestController
@RequestMapping("/Customer")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	
	@RequestMapping(value = "/getCustomer", method = RequestMethod.GET)
	public List<CustomerResponseDto> getcustomer() {
		return customerService.getcustomer();
	}
	@RequestMapping(value="/createCustomer",method=RequestMethod.POST)
	public ResponseEntity<?> createCustomer(@RequestBody CustomerRequestDto customerDto) {
		return customerService.createCustomer(customerDto);
	}
	@RequestMapping(value = "/CustomerByid/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getCustomerByid(@PathVariable("id") Long id) {
		return customerService.getCustomerByid(id);
	}
	@RequestMapping(value = "/updateCustomer", method = RequestMethod.PUT)
	public ResponseEntity<?> updateCustomer(@RequestBody CustomerRequestDto customerDto,Long id) {
		return customerService.updateCustomer(customerDto,id);
	}
	@RequestMapping(value = "/deleteCustomer/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?>deleteCustomer(@PathVariable("id")Long id){
		return customerService.deleteCustomer(id);
	}
	
	
	
	

}
