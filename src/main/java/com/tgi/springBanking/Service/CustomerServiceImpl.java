package com.tgi.springBanking.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tgi.springBanking.Entity.Customer;
import com.tgi.springBanking.Entity.CustomerRequestDto;
import com.tgi.springBanking.Entity.CustomerResponseDto;
import com.tgi.springBanking.Exception.ResourceNotFoundException;
import com.tgi.springBanking.Repository.CustomerRepository;
import com.tgi.springBanking.Repository.OrganisationRepository;
import com.tgi.springBanking.Repository.UserRepository;
import com.tgi.springBanking.enums.CustomerStatus;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	UserRepository userReposiory;
	@Autowired
	OrganisationRepository organisationRepository;

	@Override
	public List<CustomerResponseDto> getcustomer() {
		List<Customer>customer=customerRepository.findAllByStatus(CustomerStatus.ActiveStatus);
		List<CustomerResponseDto> CustomerList = new ArrayList<CustomerResponseDto>();
		for(Customer u:customer) {
			CustomerList.add( addCustomertoCustomerDto( u ) );
		    }
		return CustomerList;
	}

	private CustomerResponseDto addCustomertoCustomerDto(Customer customer) {
		CustomerResponseDto customerResponseDto=new CustomerResponseDto();
		customerResponseDto.setContactEmail(customer.getContactEmail());
		customerResponseDto.setContactNumber(customer.getContactNumber());
		customerResponseDto.setFirstName(customer.getFirstName());
		customerResponseDto.setLastName(customer.getLastName());
		customerResponseDto.setAddress(customer.getAddress());
		customerResponseDto.setStatus(customer.getStatus());
		return customerResponseDto;
	}

	@Override
	public ResponseEntity<?> createCustomer(CustomerRequestDto customerDto) {

		Customer custom=customerRepository.findByfirstName(customerDto.getFirstName());
		if(custom!=null) {
			return new ResponseEntity("firstName is already exist",HttpStatus.OK);
		}


		Customer cust1 = new Customer();
		
		
		cust1.setFirstName(customerDto.getFirstName());
		cust1.setLastName(customerDto.getLastName());
		cust1.setContactEmail(customerDto.getContactEmail());
		cust1.setContactNumber(customerDto.getContactNumber());
		//cust1.setUser(userReposiory.getById(customerDto.getUserId()));
		//cust1.setOrganisation(organisationRepository.getById(customerDto.getOrgId()));
		cust1.setAddress(customerDto.getAddress());
		cust1.setStatus(true);
		cust1= customerRepository.save(cust1);
        
        //response Dto
        CustomerResponseDto customerResponseDto=new CustomerResponseDto();
      
        customerResponseDto.setFirstName(cust1.getFirstName());
        customerResponseDto.setLastName(cust1.getLastName());
        customerResponseDto.setContactEmail(cust1.getContactEmail());
        customerResponseDto.setContactNumber(cust1.getContactNumber());
        customerResponseDto.setAddress(customerDto.getAddress());
        customerResponseDto.setStatus(cust1.getStatus());
        

        
        		

		return new ResponseEntity(customerResponseDto, HttpStatus.OK);


	}

	@Override
	public ResponseEntity<?> getCustomerByid(Long id) {
		Customer customer=customerRepository.findByIdAndStatus(id,CustomerStatus.ActiveStatus)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found this id :"+id));
		

		return new ResponseEntity(customer,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> updateCustomer(CustomerRequestDto customerDto, Long id) {

		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found this id :" + id));

		customer.setFirstName(customerDto.getFirstName());
		customer.setLastName(customerDto.getLastName());
		customer.setContactNumber(customerDto.getContactNumber());
		customer.setContactEmail(customerDto.getContactEmail());
		customer.setStatus(customerDto.getStatus());

		customer.setAddress(customerDto.getAddress());
		customerRepository.save(customer);

		return new ResponseEntity(customerDto, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> deleteCustomer(Long id) {
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer delete id Not found :" + id));
		customerRepository.delete(customer);
		return new ResponseEntity(customer, HttpStatus.OK);
	}

}
