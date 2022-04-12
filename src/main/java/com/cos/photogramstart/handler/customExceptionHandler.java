package com.cos.photogramstart.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cos.photogramstart.handler.ex.CustomValidationException;

@RestController
@ControllerAdvice
public class customExceptionHandler {

	private Map<String, String> errorMap = new HashMap<>();
	
	@ExceptionHandler(CustomValidationException.class)
	public Map<String, String> customValidationException(CustomValidationException e) {
		
		return e.getErrorMap();
	}
}
