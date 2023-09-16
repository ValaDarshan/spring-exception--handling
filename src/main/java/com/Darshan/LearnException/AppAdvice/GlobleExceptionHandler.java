package com.Darshan.LearnException.AppAdvice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.Darshan.LearnException.Exceptions.ProductNotFoundByIdException;

@RestControllerAdvice
public class GlobleExceptionHandler {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String , String > noValidArgException(MethodArgumentNotValidException ex){
		Map <String , String> msg = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach( error -> {
			msg.put(error.getField(), error.getDefaultMessage());
		});
		
		return msg;
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(ProductNotFoundByIdException.class)
	public Map<String ,String> productNotFoundById(ProductNotFoundByIdException error){
		Map <String , String> msg = new HashMap<>();
		msg.put("Error Message", error.getMessage());
		
		return msg;
	}
}
