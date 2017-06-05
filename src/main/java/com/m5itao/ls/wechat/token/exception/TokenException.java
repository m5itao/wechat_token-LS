package com.m5itao.ls.wechat.token.exception;

/**
 * token exception
 * @author m5itao
 *
 */
public class TokenException extends RuntimeException {

	private static final long serialVersionUID = 6600617949177442863L;

	public TokenException(){
		super();
	}
	
	public TokenException(String message){
		super(message);
	}
	
	public TokenException(Exception exception){
		super(exception);
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
