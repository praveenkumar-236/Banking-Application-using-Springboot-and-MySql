package com.tgi.springBanking.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tgi.springBanking.Entity.Account;
import com.tgi.springBanking.Entity.AccountRequestDto;
import com.tgi.springBanking.Entity.AccountResponseDto;
import com.tgi.springBanking.Exception.ResourceNotFoundException;
import com.tgi.springBanking.Repository.AccountRepository;
import com.tgi.springBanking.enums.AccountStatus;
import com.tgi.springBanking.enums.AccountType;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountRepository accountRepository;

	@Override
	public List<AccountResponseDto> getAccount() {
		List<Account> account = accountRepository.findByAccountStatus(AccountStatus.Approved);
		List<AccountResponseDto> AccountList = new ArrayList<AccountResponseDto>(account.size());
		for (Account u : account) {
			AccountList.add(addAccounttoAccountDto(u));
		}

		return AccountList;
	}

	public AccountResponseDto addAccounttoAccountDto(Account account) {
		AccountResponseDto accountResponseDto = new AccountResponseDto();
		accountResponseDto.setAccountNo(account.getAccountNo());
		accountResponseDto.setAcctype(account.getAcctype());
		accountResponseDto.setAccountStatus(account.getAccountStatus());
		accountResponseDto.setActualbal(account.getActualbal());
		accountResponseDto.setPreviousbal(account.getPreviousbal());
		accountResponseDto.setRunningbal(account.getRunningbal());
		accountResponseDto.setAmount(account.getAmount());

		return accountResponseDto;
	}

	@Override
	public ResponseEntity<?> createAccount(AccountRequestDto accountDto) {

//		Account accoun=accountRepository.findByaccountNo(accountDto.getAccountNo());
//		
//		if(accoun !=null) {
//			return new ResponseEntity("AccNo  is already  exist",HttpStatus.OK);
//		}
//random number generation orgcode entity

		Random random = new Random();
		Long ran = (long) random.nextInt(999999999);
		// enum AcounType

		if (!isInEnum(accountDto.getAcctype(), AccountType.class)) {
			return new ResponseEntity("invalid acctype", HttpStatus.OK);
		}

		Account acc = new Account();

		acc.setAccountNo(ran);
		acc.setAcctype(accountDto.getAcctype());
		acc.setActualbal(accountDto.getActualbal());
		acc.setPreviousbal(accountDto.getPreviousbal());
		acc.setRunningbal(accountDto.getRunningbal());
		acc.setAmount(accountDto.getAmount());

		acc.setAccountStatus(AccountStatus.New);

		acc = accountRepository.save(acc);

		AccountResponseDto accountResponseDto = new AccountResponseDto();
		accountResponseDto.setAccountNo(acc.getAccountNo());
		accountResponseDto.setAcctype(acc.getAcctype());

		accountResponseDto.setAccountStatus(acc.getAccountStatus());
		accountResponseDto.setActualbal(acc.getActualbal());
		accountResponseDto.setPreviousbal(acc.getPreviousbal());
		accountResponseDto.setRunningbal(acc.getRunningbal());
		accountResponseDto.setAmount(acc.getAmount());

		return new ResponseEntity(accountResponseDto, HttpStatus.OK);

	}

	public static <E extends Enum<E>> boolean isInEnum(String value, Class<E> enumClass) {
		for (E e : enumClass.getEnumConstants()) {
			if (e.name().equals(value)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public ResponseEntity<?> getAccountById(Long id) {
		Account account = accountRepository.findByIdAndAccountStatus(id, AccountStatus.Approved)
				.orElseThrow(() -> new ResourceNotFoundException("Account not found for this id :" + id));

		return new ResponseEntity(account, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> updateAccount(AccountRequestDto accountDto, Long id) {

		if (!isInEnum(accountDto.getAcctype(), AccountType.class)) {
			return new ResponseEntity("invalid acctype", HttpStatus.OK);
		}

		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(" not found for this id :" + id));

		// dto

		account.setAccountNo(accountDto.getAccountNo());
		account.setAcctype(accountDto.getAcctype());

		account.setAccountStatus(accountDto.getAccountStatus());
		accountRepository.save(account);

		return new ResponseEntity(account, HttpStatus.OK);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ResponseEntity<?> AccountActivity(Long accountNo, String approve) {

		Optional<Account> account = accountRepository.findByaccountNo(accountNo);
		if (account.isPresent()) {
			Account acc = account.get();
			AccountStatus[] status = AccountStatus.values();
			for (AccountStatus d : status) {
				if (d.name().equals(approve)) {

					if (acc.getAccountStatus().equals(AccountStatus.New)) {

						if (d.equals(AccountStatus.Approved)) {

							acc.setAccountStatus(AccountStatus.Approved);

						} else if (d.equals(AccountStatus.Rejected)) {

							acc.setAccountStatus(AccountStatus.Rejected);
						} else {

							return new ResponseEntity("Not new data", HttpStatus.OK);
						}

					} else if (acc.getAccountStatus().equals(AccountStatus.Approved)) {

						if (d.equals(AccountStatus.Frozen)) {

							acc.setAccountStatus(AccountStatus.Frozen);
						} else if (d.equals(AccountStatus.BlackList)) {

							acc.setAccountStatus(AccountStatus.BlackList);
						} else {

							return new ResponseEntity("invalid data", HttpStatus.OK);
						}

					} else {
						return new ResponseEntity("not invalid activity", HttpStatus.OK);
					}

				}

			}
			accountRepository.save(acc);
		} else {
			return new ResponseEntity("AccountNo is not  valid", HttpStatus.OK);
		}
		return new ResponseEntity("AccountNo is valid", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> deleteAccount(Long id) {

		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(" Account delete id not found :" + id));
		accountRepository.delete(account);
		return new ResponseEntity(account, HttpStatus.OK);
	}
}
