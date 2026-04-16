package com.io.jwt;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;


@Component
public class JWTUtil {
	@Value("${secretKey}")
	private String secretKey;

	public String generateToken(String username) {

	String token =	Jwts.builder().subject(username).issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
				.signWith(Keys.hmacShaKeyFor(secretKey.getBytes())).compact();

		return token;
	}
	
	
	public Claims getClaims(String token ) {
		
		Claims claims = Jwts.parser().verifyWith(Keys.hmacShaKeyFor(secretKey.getBytes())).build()
				.parseSignedClaims(token).getPayload();
		
		
		return claims;
		
		
	}

    public String extractUsername(String token){
        return getClaims(token).getSubject();
    }

   
    public boolean validateToken(String username, UserDetails userDetails,String token) {
       return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }
	
	
	
	
	
}
