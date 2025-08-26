package com.peerislands.sqlenhancer.dto;

public class ApiResponseDto {
	
	private String message;
	private boolean success;
	
	public ApiResponseDto(boolean success, String message) {
		this.success = success;
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	
	

}
