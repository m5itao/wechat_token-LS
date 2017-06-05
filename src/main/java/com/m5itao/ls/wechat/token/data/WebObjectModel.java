package com.m5itao.ls.wechat.token.data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author m5itao
 *
 */
public class WebObjectModel implements Serializable {

	private static final long serialVersionUID = 9105968423790929492L;
	
	private boolean succeed = true;
	
	private Exception exception;
	
	private Object data;
	
	
	/**
	 * 
	 * @param data
	 * @return
	 */
	public static WebObjectModel build(Object data){
		return new WebObjectModel(data);
	}
	
	public static WebObjectModel build(){
		return new WebObjectModel();
	}
	
	
	
	//
	
	public WebObjectModel(){
		this.succeed = true;
		this.data = "OK";
	}
	
	public WebObjectModel(Exception exception, String msg){
		this.succeed = false;
		this.exception = exception;
		this.data = msg;
	}
	
	public WebObjectModel(Object data){
		this.succeed = true;
		this.data = data;
	}
	
	//

	public boolean isSucceed() {
		return succeed;
	}

	public void setSucceed(boolean succeed) {
		this.succeed = succeed;
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@JsonIgnore
	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
