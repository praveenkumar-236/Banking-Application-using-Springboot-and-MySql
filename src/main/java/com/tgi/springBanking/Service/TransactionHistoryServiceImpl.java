package com.tgi.springBanking.Service;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.tgi.springBanking.Entity.TransactionHistory;
import com.tgi.springBanking.Exception.ResourceNotFoundException;
import com.tgi.springBanking.Repository.TransactionHistoryRepository;
import com.tgi.springBanking.specification.SearchCriteria;
import com.tgi.springBanking.specification.TransactionHistorySpecification;

@Service
public class TransactionHistoryServiceImpl implements TransactionHistoryService {

	
	@Autowired
	TransactionHistoryRepository transactionHistoryRepository;
	@SuppressWarnings("unchecked")
	@Override
	public ResponseEntity<?> getTransactionHistoryById(Long id) {
		TransactionHistory transactionHistory=transactionHistoryRepository.findById(id)
				.orElseThrow(() ->new ResourceNotFoundException("transaction id Not found"+id));
		
		return new ResponseEntity(transactionHistory,HttpStatus.OK);
	}
	@Override
	public  ResponseEntity<?> getTransactionHistoryByTransationTime(LocalDateTime transationTime) {
	
		Optional<TransactionHistory> transactionHistory=transactionHistoryRepository.findBytransationTime(transationTime);
		if(transactionHistory.isPresent()) {
		     return new ResponseEntity(transactionHistory,HttpStatus.OK);
		}else {
			throw new ResourceNotFoundException("not found");
		}	
	
                  	
	
	}
//	@Override
//	public ResponseEntity<?> search(LocalDateTime starTransationTime, LocalDateTime transationTimeend) {
//		
//		//List<TransactionHistory> transactionHistory=transactionHistoryRepository.findBytransationTimeBetween(starTransationTime,transationTimeend);
//		
//		
//	
//		
//		
//		return  new ResponseEntity(transactionHistory,HttpStatus.OK);
//		
//	
//	}
	@Override
	public  List<TransactionHistory> getSearch(Map<String, String> map) {
		//TransactionHistory transactionHistory;
          List<TransactionHistory> list=null;
		TransactionHistory transactionHistory;
      //  List<TransactionHistory> list=new ArrayList<TransactionHistory>();
        //String transactionStatus = "failure";
		long Sender = 0;
		long Receiver = 0;
		JSONObject jsonObject;
		String defaultValueIfNull = null;
		try {
			jsonObject = new JSONObject(map);
			String sender = jsonObject.optString("sender", defaultValueIfNull);
			System.out.println("****"+sender);
			String receiver = jsonObject.optString("receiver", defaultValueIfNull);
			String transactionStatus = jsonObject.optString("transactionStatus", defaultValueIfNull);
			String startDate = jsonObject.optString("startDate", defaultValueIfNull);
			String endDate = jsonObject.optString("endDate", defaultValueIfNull);
			if (sender != null) {
				Sender = Long.parseLong(sender);
			}else {
				throw new ResourceNotFoundException("sender date found");
			}
			if (receiver != null) {
				Receiver = Long.parseLong(receiver);
			}else {
				throw new ResourceNotFoundException("receiver date found");
			}
			 
//			if(transactionStatus!=null) {
//				
//			}
			 TransactionHistorySpecification spec1=new TransactionHistorySpecification(new SearchCriteria("sender",":",sender));
			 
			 TransactionHistorySpecification spec2=new TransactionHistorySpecification(new SearchCriteria("receiver",":",receiver));
			 TransactionHistorySpecification spec3=new TransactionHistorySpecification(new SearchCriteria("transactionStatus",":",transactionStatus));
//				if (startDate != null && endDate != null) {
//					 Date fromDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startDate);
//					 Date toDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endDate);
//					 LocalDateTime ldt = LocalDateTime.ofInstant(fromDate.toInstant(),
//				             ZoneId.systemDefault());
//							 LocalDateTime ldtd = LocalDateTime.ofInstant(toDate.toInstant(),
//				           ZoneId.systemDefault());
//				}

	
	
			 
				//TransactionHistorySpecification spec4=new TransactionHistorySpecification(new SearchCriteria("transationTime","---",ldt,ldtd));
				
//				 Date fromDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
//				 Date toDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(strr); 
//				 LocalDateTime ldt = LocalDateTime.ofInstant(fromDate.toInstant(),
//             ZoneId.systemDefault());
//	
//				 LocalDateTime ldtd = LocalDateTime.ofInstant(toDate.toInstant(),
//			             ZoneId.systemDefault());

			//	 list=transactionHistoryRepository.findBytransationTimeBetween(ldt,ldtd);s
			 
		
			 
			 



//			LocalDateTime fromDate1 = null;
//			LocalDateTime toDate1 = null;
			// TransactionHistorySpecification spec4=new TransactionHistorySpecification(new SearchCriteria("transationStartTime","---",transationStartTimee));
			 //TransactionHistorySpecification spec5=new TransactionHistorySpecification(new SearchCriteria("transationEndTime","---",transationEndTime));
			
			list=transactionHistoryRepository.findAll(Specification.where(spec1).or(spec2).or(spec3));
				
//			 try {
//			 Date fromDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
//			 LocalDateTime ldt = LocalDateTime.ofInstant(fromDate.toInstant(),
//                     ZoneId.systemDefault());
//			 list=transactionHistoryRepository.findBytransactionStatusANDtransationTime(transationStatus, ldt);
//			// DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//		     System.out.println("******"+str);
//			 }catch(Exception e) {
//				 
//			 }
	           

//        if(map.containsKey("transactionStatus")) {
//			 String transationStatus = (String) map.get("transactionStatus");
//			// System.out.println("ifff"+transationStatus);
//			 transactionHistory = transactionHistoryRepository.findBytransactionStatus(transationStatus);
//			list.add(transactionHistory);
//			// System.out.println("*******"+transactionHistory);
//		 }
//		 if(map.containsKey("sender")) {
//			 Long sender=Long.valueOf(map.get("sender").toString());
//			 transactionHistory=transactionHistoryRepository.findBysender(sender);
//				list.add(transactionHistory);
//		 }
//		 if(map.containsKey("sender")) {
//			 
//			 transactionHistory=transactionHistoryRepository.findBysender(sender);
//			
//		 }
//		 
//		 if(map.containsKey("receiver")) {
//			 Long receiver=Long.valueOf(map.get("receiver").toString());
//		     transactionHistory=transactionHistoryRepository.findByreceiver(receiver);
//		
//		 }
//         if(map.containsKey("transactionType")) {
//	     String transactionType=(String)map.get("transactionType");
//	     transactionHistory=transactionHistoryRepository.findBytransactionType(transactionType);
//		// return new ResponseEntity(transactionHistory,HttpStatus.OK);
//
//         }
				
		} catch(Exception e) {
			
		}
         
         
		return list;
		
	
	
		
	}
	@Override
	public ResponseEntity<?> dashBoard() {
	
		return null;
	}}
