package com.io.controllers;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/oauthcontroller")
public class OAuthController {

	@GetMapping("/one")
	public String one() {

		System.out.println("ONE");

		return "Hi";
	}
	
	@GetMapping("/two")
	public String two(OAuth2AuthenticationToken token) {
		System.out.println("TWO");

		
		return "private" +token.getPrincipal().getName();
	}

}
