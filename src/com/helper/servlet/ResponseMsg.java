package com.helper.servlet;

import java.io.Serializable;

import net.sf.json.JSONObject;

public class ResponseMsg implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private boolean code;
	private String message;
	
	public ResponseMsg() {
	}
	
	public ResponseMsg(boolean code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public boolean isCode() {
		return code;
	}

	public void setCode(boolean code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (code ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResponseMsg other = (ResponseMsg) obj;
		if (code != other.code)
			return false;
		return true;
	}

	@Override
	public String toString() {
		JSONObject obj= JSONObject.fromObject(this);
		return obj.toString();
	}
	
}
