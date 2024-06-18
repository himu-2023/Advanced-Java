package com.org.example.dto;

import java.time.LocalDateTime;

public class ErrorResponce {
	 private String msg;
	 private String errorDetails;
	 private LocalDateTime timeStamp;
	public ErrorResponce() {
	
	}
	public ErrorResponce(String msg, String errorDetails) {
		super();
		this.msg = msg;
		this.errorDetails = errorDetails;
		this.timeStamp = LocalDateTime.now();
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getErrorDetails() {
		return errorDetails;
	}
	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	@Override
	public String toString() {
		return "ErrorResponce [msg=" + msg + ", errorDetails=" + errorDetails + ", timeStamp=" + timeStamp + "]";
	}

}
