package com.io.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.io.entity.AuthRequest;
import com.io.jwt.JWTUtil;
import com.io.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/authcontroller")
public class AuthController {

	Logger logger = LoggerFactory.getLogger(AuthController.class);

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JWTUtil jwtUtil;

	@Autowired
	private UserService userService;

	@PostMapping("/auth")
	public String generateToken(@RequestBody AuthRequest authRequest) {

		String username = authRequest.getUsername();
		String password = authRequest.getPassword();

		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

		return jwtUtil.generateToken(username);

	}

	@PostMapping("/register")
	public ResponseEntity registerUser(@RequestBody AuthRequest authRequest) {

		return ResponseEntity.ok(userService.registerUser(authRequest));
	}

	@PostMapping("/authenticate")
	public ResponseEntity extractToken(HttpServletRequest httpRequest) {
		
		logger.info("FROM AuthController : extractToken");

		return ResponseEntity.ok("Extracted : ");
	}

}
