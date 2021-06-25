package com.artlier.web.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginHistoryDTO {
	
	private int uid;
	private String id;
	private int succeed;
	private String ip;
	private String try_date;
	
}
