package com.io.validations;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptions {

	private static final Logger log = LoggerFactory.getLogger(GlobalExceptions.class);

	@ExceptionHandler(NoProductFoundException.class)
	public ResponseEntity<ErrorMessages> handleResourceNotFound(NoProductFoundException ex) {

		log.info("GlobalExceptions : handleResourceNotFound execution starts");

		ErrorMessages errorMessages;

		errorMessages = new ErrorMessages(ex.getMessage(), "No product found with Id = " + ex.getId(),
				LocalDateTime.now());

		log.info("GlobalExceptions : handleResourceNotFound execution ends");

		return new ResponseEntity<>(errorMessages, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
		log.info("GlobalExceptions : handleValidationExceptions execution starts");

		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors()
				.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

		log.info("GlobalExceptions : handleValidationExceptions execution ends");

		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}

	private Map<String, String> getErrorsMap(String errors) {
		Map<String, String> errorResponse = new HashMap<>();
		errorResponse.put("errors", errors);
		return errorResponse;
	}

}
