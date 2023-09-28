package com.hoaxify.ws.exeptions;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {
	
	private int status;
	private String message;
	private String path;
	private long timestamp = new Date().getTime();
	private Map<String, String> validationError = new HashMap<>();
	
}
