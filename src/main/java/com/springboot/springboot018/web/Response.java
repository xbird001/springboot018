package com.springboot.springboot018.web;

import java.util.List;

public class Response<T> {
	
	private Code code;
	
	private String msg;
	
	private List<T> t;

	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Response(Code code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}


	public Code getCode() {
		return code;
	}

	public Response<T> setCode(Code code) {
		this.code = code;
		if(this.msg == null || "".equals(msg)) {
			this.msg = code.getCodeDes();
		}
		return this;
	}

	public String getMsg() {
		return msg;
	}

	public Response<T> setMsg(String msg) {
		this.msg = msg;
		return this;
	}


	@Override
	public String toString() {
		return "Response [code=" + code.getCode() + ", msg=" + msg + ", t=" + t + "]";
	}
	
	/**
	 * 状态码
	 * @author Administrator
	 *
	 */
	public enum  Code {
		Fail(-1,"失败"),Success(0,"成功");
		
		private int code;
		
		private String codeDes;
		
		private Code(int code, String codeDes) {
			this.code = code;
			this.codeDes = codeDes;
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getCodeDes() {
			return codeDes;
		}

		public void setCodeDes(String codeDes) {
			this.codeDes = codeDes;
		}
		
	}

	public List<T> getT() {
		return t;
	}

	public Response<T> setT(List<T> t) {
		this.t = t;
		return this;
	}

}
