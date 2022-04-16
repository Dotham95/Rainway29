package com.vti.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseDTO<T> {
	private int code; //100 200
	private String message;
	private T data;

}
