package com.carros.api.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionConfig extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler({
		EmptyResultDataAccessException.class
	})
	public ResponseEntity errorNotFound(Exception ex) {
		return ResponseEntity.notFound().build();
	}

	@ExceptionHandler({
		IllegalArgumentException.class
	})
	public ResponseEntity errorBadRequest(Exception ex) {
		return ResponseEntity.badRequest().build();
	}

}
