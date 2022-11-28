package com.tgi.springBanking.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.tgi.springBanking.Entity.TransactionHistory;



@Repository
public interface TransactionHistoryRepository  extends JpaRepository<TransactionHistory,Long>,JpaSpecificationExecutor<TransactionHistory>  {

	Optional<TransactionHistory> findBytransationTime(LocalDateTime transationTime);





//	@Query(SELECT * FROM transaction u WHERE e.REFERENCE_FIELD BETWEEN startDate AND endDate)
	public List<TransactionHistory>  findBytransationTimeBetween(LocalDateTime transationStartTime, LocalDateTime transationEndTime);





	TransactionHistory findBytransactionStatus(String transactionStatus);





	TransactionHistory findBysender(Long sender);





	TransactionHistory findByreceiver(Long receiver);





	TransactionHistory findBytransactionType(String transactionType);




	  
	
	  @Query(value = "SELECT t FROM TransactionHistory t where t.transactionStatus =:transationStatus AND  t.transationTime =:transationTime")
	   public List<TransactionHistory> findBytransactionStatusANDtransationTime(@Param("transationStatus") String transationStatus,
			   @Param("transationTime")LocalDateTime transationTime );

	







}
