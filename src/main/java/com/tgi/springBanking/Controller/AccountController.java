package com.tgi.springBanking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tgi.springBanking.Entity.Account;
import com.tgi.springBanking.Entity.AccountRequestDto;
import com.tgi.springBanking.Entity.AccountResponseDto;
import com.tgi.springBanking.Service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	@Autowired
	AccountService accountService;

	@RequestMapping(value = "/getAccount", method = RequestMethod.GET)
	public List<AccountResponseDto> getAccount() {

		return accountService.getAccount();
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<?> createAccount(@RequestBody AccountRequestDto accountDto) {

		return accountService.createAccount(accountDto);
	}

	@RequestMapping(value = "/AccountById/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getAccountById(@PathVariable("id") Long id) {

		return accountService.getAccountById(id);
	}

	@RequestMapping(value = "/updateAccount", method = RequestMethod.PUT)
	public ResponseEntity<?> updateAccount(@RequestBody AccountRequestDto accountDto,Long id) {
		
		return accountService.updateAccount(accountDto,id);
	}
	@RequestMapping(value = "/AccountActivity", method = RequestMethod.GET)
	public ResponseEntity<?> AccountActivity(@RequestParam Long accountNo,@RequestParam(required=false) String Approve) {
		
		
		return accountService.AccountActivity(accountNo,Approve);
	}
	@RequestMapping(value = "/deleteAccount/{id}", method = RequestMethod.GET)
	public ResponseEntity<?>deleteAccount(@PathVariable("id") Long id){
		return accountService.deleteAccount(id);
	}
	//find by acc no
	
	// findall accounts by acct type

}
