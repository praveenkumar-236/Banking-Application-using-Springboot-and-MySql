package com.tgi.springBanking.specification;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchCriteria {
	
	private String key;
	private String operation;
	private Object value;
	private LocalDateTime value1;
	private LocalDateTime value2;
	
   public SearchCriteria(String key, String operation, Object value) {

		this.key = key;
		this.operation = operation;
		this.value = value;

	}

//public SearchCriteria(String key, String operation,  LocalDateTime value1, LocalDateTime value2) {
//     super();
//	this.key = key;
//	this.operation = operation;
//	this.value1 = value1;
//	this.value2 = value2;
//}







	

}
