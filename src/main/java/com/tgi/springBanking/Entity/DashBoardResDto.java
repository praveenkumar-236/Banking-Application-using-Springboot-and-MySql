package com.tgi.springBanking.Entity;

import lombok.Data;

@Data
public class DashBoardResDto {
	
	private Long accountCount;
	private Long accountActiveCount;
	private Long accountInActiveCount;
	private Long userCount;
	private Long userActiveCount;
	private Long userInActiveCount;

}
