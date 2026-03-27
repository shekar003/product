package com.io.security;

//@Configuration
//@EnableWebSecurity
public class ProductSpringSecurity {
	
	
	/*
	
	 * @Bean SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)
	 * throws Exception { httpSecurity.authorizeHttpRequests(auth ->
	 * auth.requestMatchers("/
	 **").permitAll().anyRequest().authenticated()) // All other requests require authentication

	.csrf(csrfConfig-> // Disable CSRF for simplicity
	csrfConfig.disable()).sessionManagement(sessionConfig-> // Disable JSESSIONID for simplicity, not recommended for
															// production
	sessionConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

	httpSecurity.authorizeHttpRequests(registry->
	{

		registry.requestMatchers("/home", "/register/**").permitAll();
		registry.requestMatchers("/admin/**").hasRole("Admin");

		registry.anyRequest().authenticated();

	});

	return httpSecurity.build(); // when you add build this throws an exception
	}

	// Password Encoding
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}*/
}
