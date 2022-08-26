package com.spring.crud.exceptions;

public class ProductError {
	
		private int status;
		private String message;
		
		
		public ProductError() {
			
		}
		
		public ProductError(int status, String message) {
			this.status = status;
			this.message = message;
		}
		
		
		public int getStatus() {
			return status;
		}
		public void setStatus(int status) {
			this.status = status;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		
		
}
