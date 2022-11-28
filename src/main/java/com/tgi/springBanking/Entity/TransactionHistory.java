package com.tgi.springBanking.Entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Transaction")
public class TransactionHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "sender")
	private Long sender;
	@Column(name = "receiver")
	private Long receiver;
	@Column(name = "transationId")
	private Long transationId;
	@Column(name = "transactionStatus")
	private String transactionStatus;
	@Column(name = "transactionType")
	private String transactionType;
	@Column(name = "transationTime")
	private LocalDateTime transationTime;

	public TransactionHistory() {

	}
	
	
	
	
	
	

	public TransactionHistory(Long id, Long sender, Long receiver, Long transationId, String transactionStatus,
			String transactionType, LocalDateTime transationTime) {
		super();
		this.id = id;
		this.sender = sender;
		this.receiver = receiver;
		this.transationId = transationId;
		this.transactionStatus = transactionStatus;
		this.transactionType = transactionType;
		this.transationTime = transationTime;
	}







	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSender() {
		return sender;
	}

	public void setSender(Long sender) {
		this.sender = sender;
	}

	public Long getReceiver() {
		return receiver;
	}

	public void setReceiver(Long receiver) {
		this.receiver = receiver;
	}

	public Long getTransationId() {
		return transationId;
	}

	public void setTransationId(Long transationId) {
		this.transationId = transationId;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public LocalDateTime getTransationTime() {
		return transationTime;
	}

	public void setTransationTime(LocalDateTime transationTime) {
		this.transationTime = transationTime;
	}
	
	
	
	
	
	
	



	
	
	
	

}