package com.hcl.learn.domain;

public class HelloWorldBean {

	private String message;

	public HelloWorldBean(String message) {
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
