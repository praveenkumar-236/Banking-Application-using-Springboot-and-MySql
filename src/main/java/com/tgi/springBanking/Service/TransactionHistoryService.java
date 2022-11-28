package com.tgi.springBanking.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.tgi.springBanking.Entity.TransactionHistory;

public interface TransactionHistoryService {

	public ResponseEntity<?> getTransactionHistoryById(Long id);

	public ResponseEntity<?> getTransactionHistoryByTransationTime(LocalDateTime transationTime);

//	public  ResponseEntity<?> search(LocalDateTime starTransationTime, LocalDateTime transationTimeend);

	public  List<TransactionHistory> getSearch(Map<String, String> map);

	public ResponseEntity<?> dashBoard();



}
