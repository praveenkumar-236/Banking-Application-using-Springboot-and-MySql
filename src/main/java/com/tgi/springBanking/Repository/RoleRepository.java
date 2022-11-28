package com.tgi.springBanking.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tgi.springBanking.Entity.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role,Long>{

	Role findByroleName(String roleName);

	List<Role> findAllByStatus(boolean status);

	Optional<Role> findByIdAndStatus(Long id, boolean status);







	
}
