package com.m5itao.ls.wechat.token.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.m5itao.ls.wechat.token.data.WebObjectModel;

@ControllerAdvice
public class ExceptionHandle {
	

	@ExceptionHandler(value = TokenException.class)
	@ResponseBody
	public WebObjectModel handleTokenException(TokenException tokenException, WebRequest request) {
		return new WebObjectModel(tokenException, tokenException.getMessage());
	}
	
	
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public WebObjectModel handleThrowable(Exception exception, WebRequest request) {
		return new WebObjectModel(exception, exception.getMessage());
	}
	
}
