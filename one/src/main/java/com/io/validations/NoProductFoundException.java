package com.io.validations;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.servlet.http.HttpServletResponse;

@ControllerAdvice
public class NoProductFoundException extends RuntimeException {

	private String message;
	private Long id;
	private String name;

	public NoProductFoundException() {
	}

	public NoProductFoundException(String message, Long id) {
		super();
		this.message = message;
		this.id=id;

	}
	public NoProductFoundException(String message, String name) {
		super();
		this.message = message;
		this.name=name;

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	
	
}
