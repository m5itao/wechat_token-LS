package com.m5itao.ls.wechat.token.data;

import java.io.Serializable;

/**
 * object model: wechat access token 
 * 
 * @author m5itao
 *
 */
public class WechatAccessToken implements Serializable {

	private static final long serialVersionUID = 1L;

	//config
	
	private String appid;
	
	private String secret;
	
	private String grantType = "client_credential";
	
	
	//token
	
	private String lastDate;
	
	private String lastdata;
	
	private String accessToken;
	
	private int expiresIn = 7200;
	
	
	//

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getGrantType() {
		return grantType;
	}

	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getLastDate() {
		return lastDate;
	}

	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}

	public String getLastdata() {
		return lastdata;
	}

	public void setLastdata(String lastdata) {
		this.lastdata = lastdata;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public int getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}
	
	
}
