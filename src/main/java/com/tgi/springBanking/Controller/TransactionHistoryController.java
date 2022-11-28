package com.tgi.springBanking.Controller;



import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tgi.springBanking.Entity.TransactionHistory;
import com.tgi.springBanking.Service.TransactionHistoryService;

@RestController
@RequestMapping("/TransactionHistory")
public class TransactionHistoryController {
	
	@Autowired
	TransactionHistoryService transactionHistoryService;

	 @RequestMapping(value="/TransactionHistoryById/{id}",method=RequestMethod.GET)
	 public ResponseEntity<?> getTransactionHistoryById(@PathVariable("id")Long id) {
	 
		 return transactionHistoryService.getTransactionHistoryById(id);

	 }
	 @RequestMapping(value="/getTransactionHistoryByTransationTime/{transationTime}",method=RequestMethod.GET)
	 public ResponseEntity<?>getTransactionHistoryByTransationTime(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime transationTime){
		 
		 return transactionHistoryService.getTransactionHistoryByTransationTime(transationTime);
	 }
//	 @RequestMapping(value="/search/{transationTime}",method=RequestMethod.GET)
//	 public ResponseEntity<?>search(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime starTransationTime,@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime transationTimeend){
//		 
//		 return transactionHistoryService.search(starTransationTime,transationTimeend);
//		 
//	 }
	@RequestMapping(value="/getSearch",method=RequestMethod.POST)
	public  List<TransactionHistory> getSearch(@RequestBody Map<String,String> map) {
		
		 return transactionHistoryService.getSearch(map);
	}
	@RequestMapping(value="/dashBoard",method=RequestMethod.GET)
	public ResponseEntity<?>dashBoard(){
		
		return transactionHistoryService.dashBoard();
	}
	 
}
