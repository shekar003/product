package com.io.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.io.entity.User;


@RestController
@RequestMapping("/oauthcontroller")
public class OAuthController {

	@GetMapping("/one")
	public String one() {

		System.out.println("ONE");

		return "Hi";
	}
	
	@GetMapping("/two")
	public String two() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		User user = (User) auth.getPrincipal();
	
		System.out.println("TWO" +user.getUsername() +" : "+user.getAuthorities());

		
		return user.getUsername();
	}

}
