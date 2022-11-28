package com.tgi.springBanking.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tgi.springBanking.Entity.Account;
import com.tgi.springBanking.Entity.AccountRequestDto;
import com.tgi.springBanking.Entity.TransactionHistory;
import com.tgi.springBanking.Exception.ResourceNotFoundException;
import com.tgi.springBanking.Repository.AccountRepository;
import com.tgi.springBanking.Repository.TransactionHistoryRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	AccountRepository accountRepository;
	@Autowired
	TransactionHistoryRepository transactionHistoryRepository;

	@Override
	public ResponseEntity<?> sendTransaction(Long senderaccountNo, Long receiveraccountNo, Long amount) {
		Optional<Account> accountNo = accountRepository.findByaccountNo(senderaccountNo);
		Optional<Account> accountNo1 = accountRepository.findByaccountNo(receiveraccountNo);
		if(!accountNo1.isPresent()) 
		throw new ResourceNotFoundException("invalid receiveraccountNo");
			if (!accountNo.isPresent()) 
				throw new ResourceNotFoundException("invalid senderaccountNo");
			TransactionHistory transactionHistory;	    
			Account acc = accountNo.get();
			Account accu = accountNo1.get();
			if (acc.getActualbal() >= amount) {
				long balance = acc.getActualbal() - amount;
				acc.setActualbal(balance);
				accountRepository.save(acc);
				long balancee = accu.getActualbal() + amount;
				accu.setActualbal(balancee);
				accountRepository.save(accu);

				
				//random generation number 
				
				
				Random random = new Random();
				Long ran = (long) random.nextInt(999999);
				LocalDateTime now = LocalDateTime.now();
				TransactionHistory TransactionHistory=new TransactionHistory();
				TransactionHistory.setReceiver(receiveraccountNo);
				TransactionHistory.setSender(senderaccountNo);
				TransactionHistory.setTransactionStatus("success");
				TransactionHistory.setTransactionType("savings");
				TransactionHistory.setTransationId(ran);
				TransactionHistory.setTransationTime(now);
				transactionHistory=transactionHistoryRepository.save(TransactionHistory);
				
				
			} else {
				Random random = new Random();
				Long ran = (long) random.nextInt(999999);
				LocalDateTime now = LocalDateTime.now();
				TransactionHistory TransactionHistory=new TransactionHistory();
				TransactionHistory.setSender(senderaccountNo);
				TransactionHistory.setReceiver(receiveraccountNo);
				TransactionHistory.setTransactionStatus("failure insufficient fund");
				TransactionHistory.setTransactionType("savings");
				TransactionHistory.setTransationId(ran);
				TransactionHistory.setTransationTime(now);
				transactionHistory=transactionHistoryRepository.save(TransactionHistory);
				
				}

			

	
		
		
	
		

		
		return new ResponseEntity(transactionHistory, HttpStatus.OK);
	}
}
