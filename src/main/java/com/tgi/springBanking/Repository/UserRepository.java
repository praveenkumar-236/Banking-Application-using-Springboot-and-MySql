package com.tgi.springBanking.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tgi.springBanking.Entity.User;
import com.tgi.springBanking.enums.UserStatus;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

	User findByuserName(String userName);

	List<User> findAllByStatus(boolean status);

	Optional<User> findByIdAndStatus(Long id, boolean status);

	//List<Workflow> findByActive(@Param("active") Boolean active);



	


    
	

	

	

}
