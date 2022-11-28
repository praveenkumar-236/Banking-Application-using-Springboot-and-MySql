package com.tgi.springBanking.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tgi.springBanking.Entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{

	Customer findByfirstName(String firstName);

	Customer findBylastName(String lastName);

	public List<Customer> findAllByStatus(boolean status);

	Optional<Customer> findByIdAndStatus(Long id, boolean status);

}
