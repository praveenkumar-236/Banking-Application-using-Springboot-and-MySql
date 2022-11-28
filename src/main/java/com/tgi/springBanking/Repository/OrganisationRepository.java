package com.tgi.springBanking.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tgi.springBanking.Entity.Organisation;

@Repository
public interface OrganisationRepository extends JpaRepository<Organisation,Long> {

	public Organisation findByorgName(String orgName);

	public Organisation findByorgType(String orgType);

	public List<Organisation> findAllByStatus(boolean status);

	public Optional<Organisation> findByIdAndStatus(Long id, boolean status);

}
