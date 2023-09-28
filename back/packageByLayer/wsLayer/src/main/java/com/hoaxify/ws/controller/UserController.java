package com.hoaxify.ws.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.hoaxify.ws.model.User;
import com.hoaxify.ws.service.UserService;
import com.hoaxify.ws.shared.GenericMessage;
import jakarta.validation.Valid;

@RestController
public class UserController {
	
	private UserService userService;
	
    private UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/api/v1/users")
    public GenericMessage createUser(@Valid @RequestBody User user){	
		userService.add(user);
    	return new GenericMessage("User is created");	
    }
	
	
}

