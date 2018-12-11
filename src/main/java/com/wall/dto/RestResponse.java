package com.wall.dto;

public class RestResponse {

	private String msg;
	
	
	public RestResponse(String msg) {
		super();
		this.msg = msg;
		
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
