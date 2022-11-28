package com.tgi.springBanking.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tgi.springBanking.Service.TransactionService;

@RestController
@RequestMapping("/Transaction")
public class TransactionController {
	@Autowired
	TransactionService transactionService;
	@RequestMapping(value="/sendTransaction",method=RequestMethod.POST)
	public ResponseEntity<?>sendTransaction(@RequestParam Long senderaccountNo ,@RequestParam Long receiveraccountNo ,@RequestParam(required=false) Long Amount){
		
		return transactionService.sendTransaction(senderaccountNo,receiveraccountNo,Amount);
	}

}
