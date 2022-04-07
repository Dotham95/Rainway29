package com.vti.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.vti.dto.ResponseDTO;
import com.vti.entity.DTOCodeMessage;

@ControllerAdvice
public class HandleException extends ResponseEntityExceptionHandler {

	/*
	 * // bat 1 loi
	 * 
	 * @Override protected ResponseEntity<Object>
	 * handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders
	 * headers, HttpStatus status, WebRequest request) { ObjectError objectError =
	 * ex.getBindingResult().getAllErrors().get(0);
	 * 
	 * ResponseDTO<Object> dto = new ResponseDTO();
	 * dto.setMessage(objectError.getDefaultMessage());
	 * dto.setCode(DTOCodeMessage.ERROR_CODE_100);
	 * 
	 * return new ResponseEntity<>(dto ,status); }
	 */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		ResponseDTO<Object> dto = new ResponseDTO();
		dto.setMessage(DTOCodeMessage.MSG_CODE_102);
		dto.setCode(DTOCodeMessage.ERROR_CODE_102);
		List<String> listMessage = new ArrayList();

		for (ObjectError objectError : ex.getBindingResult().getAllErrors()) {
			listMessage.add(objectError.getDefaultMessage());
		}
		dto.setData(listMessage);

		return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
	}
}
