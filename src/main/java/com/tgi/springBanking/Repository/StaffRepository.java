package com.tgi.springBanking.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tgi.springBanking.Entity.Staff;
@Repository
public interface StaffRepository extends JpaRepository<Staff,Long>{

	Staff findByname(String name);

	List<Staff> findAllByStatus(boolean status);

	Optional<Staff> findByIdAndStatus(Long id, boolean status);

	

}
