package com.io.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.io.jwt.JwtFilter;
import com.io.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class ProductSpringSecurity {

	@Autowired
	private JwtFilter jwtFilter;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();

	}

	@Bean
	public UserDetailsService userDetailsService() {
		return new CustomUserDetailsService();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

		httpSecurity.csrf(csr -> csr.disable()).authorizeHttpRequests(auth -> auth
				.requestMatchers("/authcontroller/**", "/productcontroller/**", "/oauthcontroller/**").permitAll());

		httpSecurity.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);



        httpSecurity.oauth2Login(Customizer.withDefaults());

		return httpSecurity.build();

	}

	@Bean
	public AuthenticationManager authenticationManager(UserDetailsService userDetailsService,
			PasswordEncoder passwordEncoder) throws Exception {
		DaoAuthenticationProvider daoAuthenticationManager = new DaoAuthenticationProvider();
		daoAuthenticationManager.setUserDetailsService(userDetailsService);
		daoAuthenticationManager.setPasswordEncoder(passwordEncoder);
		// new AuthenticationConfiguration().getAuthenticationManager();
		return new ProviderManager(daoAuthenticationManager);

	}

}
