package com.io.jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {
	
	@Value("${secretKey}")
	private String secretKey;

	@Override
	protected void doFilterInternal(HttpServletRequest httpRequest, HttpServletResponse httpResponse, FilterChain filterChain)
			throws ServletException, IOException {

		String authHeader = httpRequest.getHeader("Authorization");
		
		String token = null;
		String username;
	
		if(authHeader!=null && authHeader.startsWith("Bearer ")) {

		token = authHeader.substring(7);
		logger.info("Token : " + token);
		
		Claims claims = Jwts.parser().verifyWith(Keys.hmacShaKeyFor(secretKey.getBytes())).build()
				.parseSignedClaims(token).getPayload();

		claims.forEach((k, c) -> System.out.println(k + " : " + c));

		logger.info("Claims : " + claims);
		}
		
		filterChain.doFilter(httpRequest, httpResponse);
	}
	
	

}
