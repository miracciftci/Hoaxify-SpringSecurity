package com.hoaxify.ws.user.validation;

import org.springframework.beans.factory.annotation.Autowired;
import com.hoaxify.ws.user.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String>{
	// ConstraintValidator'ı implements eder ve alacağı birinci parametre annotation'ının kendisi ve alacağı ikinci parametre o anotasyonun türü 
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(userRepository.existsByEmail(value)) { // eğer email database'de var ise true, email database'de yok ise false dönücek
			return false;
		}
	
		return true;  
	}
}
