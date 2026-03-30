package com.io.validations;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatusCode;

import lombok.Data;

@Data
public class ErrorMessages {
	private String message;
	private String details;
	private LocalDateTime timestamp;

	public ErrorMessages(String message) {

		this.message = message;
	}
	
	public ErrorMessages(String message, LocalDateTime timestamp) {

		this.message = message;
		this.timestamp=timestamp;
	}

	public ErrorMessages(String message, String details, LocalDateTime timestamp) {

		this.message = message;
		this.details = details;
		this.timestamp = LocalDateTime.now();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}


}
