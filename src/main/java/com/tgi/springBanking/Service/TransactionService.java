package com.tgi.springBanking.Service;

import org.springframework.http.ResponseEntity;

public interface TransactionService {

	public ResponseEntity<?> sendTransaction(Long senderaccountNo, Long receiveraccountNo, Long amount);

}
