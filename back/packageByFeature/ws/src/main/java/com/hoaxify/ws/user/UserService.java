package com.hoaxify.ws.user;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserService {
	
	private UserRepository userRepository;
	
	// passwordu hashlemek için spring securitynin özelliği 
	private PasswordEncoder passwordEncoder;
	
	
	public void add(User user){
		try {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userRepository.save(user);
		} catch (DataIntegrityViolationException e) {
			throw new NotUniqueEmailException();
		}
		
	}
	
	
	
}
