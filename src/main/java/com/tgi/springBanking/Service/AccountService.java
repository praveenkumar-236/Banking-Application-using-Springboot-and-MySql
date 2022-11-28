package com.tgi.springBanking.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.tgi.springBanking.Entity.Account;
import com.tgi.springBanking.Entity.AccountRequestDto;
import com.tgi.springBanking.Entity.AccountResponseDto;

public interface AccountService {

	public List<AccountResponseDto> getAccount();

	public ResponseEntity<?> createAccount(AccountRequestDto accountDto);

	public ResponseEntity<?>  getAccountById(Long id);

	public ResponseEntity<?> updateAccount(AccountRequestDto accountDto,Long id);

	public ResponseEntity<?> AccountActivity(Long accountNo, String approve);

	public ResponseEntity<?> deleteAccount(Long id);

}
