package com.io.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.io.dao.UserRepository;
import com.io.entity.AuthRequest;
import com.io.entity.User;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	  @Autowired
	  private UserRepository userRepository;
	  
	  @Autowired
	  private PasswordEncoder passwordEncoder;
	  
	  
	  public User registerUser(AuthRequest authRequest) {
		  
		  User user = new User();
		  
		  user.setUsername(authRequest.getUsername());
		  user.setPassword(passwordEncoder.encode(authRequest.getPassword()));
		  user.setRole("user");
		  
		  return userRepository.save(user);
	  }
	  
	  
	  
	  @Override
	  public UserDetails loadUserByUsername(String username) throws  UsernameNotFoundException {
	  
	  return userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("user name not found"));
	
	  }
	  
	  
}










