package com.hoaxify.ws.exeptions;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExeptionHandling {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiError handleMethodArgNotValidEx(MethodArgumentNotValidException exeption) {
		ApiError apiError = new ApiError();
		apiError.setPath("/api/v1/users");
		apiError.setMessage("validation error");
		apiError.setStatus(400);
		
		/*Map<String, String> validationErrors = new HashMap<>();
		for(var fieldError  :exeption.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}*/
		
		Map<String, String> validationErrors = exeption.getBindingResult().getFieldErrors().
				stream().collect(Collectors.toMap
						(FieldError::getField, FieldError::getDefaultMessage,
								(existing, replacing) -> existing));   
		
		apiError.setValidationError(validationErrors);
		return apiError;
	}
	
	@ExceptionHandler(NotUniqueEmailException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	ApiError handleNotUniqEmail(NotUniqueEmailException exeption) {
		ApiError apiError = new ApiError();
		apiError.setPath("/api/v1/users");
		apiError.setMessage("validation error");
		apiError.setStatus(400);
		
		Map<String, String> validationErrors = new HashMap<>();
		validationErrors.put("email", "email in use");
		apiError.setValidationError(validationErrors);
		
		return apiError;
	}
	
}
