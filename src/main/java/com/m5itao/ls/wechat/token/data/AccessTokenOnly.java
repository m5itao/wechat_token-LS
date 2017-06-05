package com.m5itao.ls.wechat.token.data;

import java.io.Serializable;

/**
 * 
 * @author m5itao
 *
 */
public class AccessTokenOnly implements Serializable{

	private static final long serialVersionUID = -8216201832925726502L;

	private String appid;
	
	private String token;
	
	
	//
	
	public AccessTokenOnly(){
		
	}
	
	public AccessTokenOnly(String appid, String token){
		this.appid = appid;
		this.token = token;
	}
	
	//

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
