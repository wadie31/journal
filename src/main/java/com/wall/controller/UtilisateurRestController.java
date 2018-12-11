package com.wall.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wall.dto.AuthenticationRequest;
import com.wall.dto.AuthenticationResponse;
import com.wall.entities.User;
import com.wall.exception.ExceptionResponse;
import com.wall.service.AuthService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UtilisateurRestController {
	
	@Autowired private AuthService authService;
	
	final static Logger logger = LoggerFactory
			.getLogger(UtilisateurRestController.class);
	
	 @RequestMapping(value = "/auth", method = RequestMethod.POST)
	    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest authenticationRequest)  {
		 
		 User user = null;

	     try {
	    	    user = authService.authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
	    	    return ResponseEntity.ok(new AuthenticationResponse("success",user));

	     }  catch (Exception ex){
	            logger.error("Exception"+ ex.getClass());
	            return new ResponseEntity(
	                    new ExceptionResponse("Authentication Failed",""),
	                    HttpStatus.BAD_REQUEST);

	     }
	
	    }

}