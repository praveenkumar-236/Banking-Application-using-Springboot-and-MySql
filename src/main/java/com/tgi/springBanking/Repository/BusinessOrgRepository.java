package com.tgi.springBanking.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.tgi.springBanking.Entity.BusinessOrganisation;

@Repository
public interface BusinessOrgRepository extends JpaRepository<BusinessOrganisation,Long> {

	



	public List<BusinessOrganisation> findAllByStatus(Boolean activestatus);

	public Optional<BusinessOrganisation> findByIdAndStatus(Long id, Boolean activestatus);



}
