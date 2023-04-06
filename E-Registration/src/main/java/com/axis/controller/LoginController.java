package com.axis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.axis.dto.UserDTO;
import com.axis.entity.AuthResponse;
import com.axis.entity.AuthenticationRequest;
import com.axis.exception.InfoNotSavedException;
import com.axis.exception.UserNameNotFoundException;
import com.axis.service.AuthenticateService;


@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class LoginController {
	
	@Autowired
	AuthenticateService authenticateService;
	
    @PostMapping("/register")
	public ResponseEntity<AuthResponse> register(@RequestBody UserDTO userDto ) throws InfoNotSavedException{
    
    	try {
    		AuthResponse authResponse =authenticateService.registerUser(userDto);
        	return ResponseEntity.ok(authResponse) ;
		} catch (Exception e) {
			throw new InfoNotSavedException("User Fail to register .... try again");
		}
    	
	}
    
    @PostMapping("/login")
	public ResponseEntity<AuthResponse> authenticateUser(@RequestBody AuthenticationRequest request ) throws Exception
    {   
    	try {
    		AuthResponse authResponse =authenticateService.authenticateUser(request);
    	    
        	return ResponseEntity.ok(authResponse) ;
			
		} catch (Exception e) {
			throw new UserNameNotFoundException(request.getUsername());
		
		}
	}
}
