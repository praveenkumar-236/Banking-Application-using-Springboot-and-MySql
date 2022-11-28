package com.tgi.springBanking.Repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tgi.springBanking.Entity.Account;
import com.tgi.springBanking.Entity.AccountRequestDto;

import com.tgi.springBanking.enums.AccountStatus;
import com.tgi.springBanking.enums.AccountType;
@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

	Account findByAcctype(String acctype);

	Optional<Account> findByaccountNo(Long accountNo);

	List<Account> findByAccountStatus(AccountStatus approved);

	Optional<Account> findByIdAndAccountStatus(Long id, AccountStatus approved);

	
	Optional<Account> findByAccountNo(Long accountNo);

	Optional<Account> findByamount(Long amount);







	

	

//	Account findByAcctypeAndAccountType(String acctype, AccountType savings);

    

	



	

	



}
