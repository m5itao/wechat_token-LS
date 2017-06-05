package com.m5itao.ls.wechat.token.service;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.m5itao.ls.wechat.token.data.AccessTokenOnly;
import com.m5itao.ls.wechat.token.data.WechatAccessToken;
import com.m5itao.ls.wechat.token.exception.TokenException;

/**
 * 
 * @author m5itao
 *
 */
@Service
public class TokenService {

	private static final Logger logger = Logger.getLogger(TokenService.class);
	
	
	/**
	 * memory store
	 */
	private final static Map<String, WechatAccessToken> TOKEN_STORE = new ConcurrentHashMap<String, WechatAccessToken>();
	
	
	
	/**
	 * 
	 * @param appid
	 * @return
	 */
	public WechatAccessToken[] getConfigs(){
		if(TOKEN_STORE.size() == 0){
			return new WechatAccessToken[]{};
		}
		
		//
		WechatAccessToken[] configs= new WechatAccessToken[TOKEN_STORE.size()];
		Set<String> appids = TOKEN_STORE.keySet();
		int tmp = 0;
		for(String appid : appids){
			configs[tmp++] = TOKEN_STORE.get(appid);
		}
		logger.info("get all config");
		return configs;
	}
	
	
	/**
	 * 
	 * @param appid
	 * @return
	 */
	public WechatAccessToken getConfig(String appid){
		if(appid == null){
			throw new TokenException("missing appid");
		}
		
		
		WechatAccessToken wechatAccessToken = TOKEN_STORE.get(appid);
		if(wechatAccessToken == null){
			throw new TokenException("missing wechatAccessToken by appid:"+appid);
		}
		
		logger.info("get config by appid="+appid);
		return wechatAccessToken;
	}
	
	
	/**
	 * 
	 * @param wechatAccessToken
	 * @return
	 */
	public WechatAccessToken postConfig(WechatAccessToken wechatAccessToken){
		if(wechatAccessToken == null){
			throw new TokenException("missing wechatAccessToken");
		}
		
		
		if(wechatAccessToken.getAppid() == null){
			throw new TokenException("missing appid");
		}
		
		
		TOKEN_STORE.put(wechatAccessToken.getAppid(), wechatAccessToken);
		logger.info("post config, appid="+wechatAccessToken.getAppid());
		return wechatAccessToken;
	}
	
	
	/**
	 * 
	 * @param appid
	 * @param wechatAccessToken
	 * @return
	 */
	public WechatAccessToken putConfig(String appid, WechatAccessToken wechatAccessToken){
		if(appid == null){
			throw new TokenException("missing appid");
		}
		
		
		if(wechatAccessToken == null){
			throw new TokenException("missing wechatAccessToken");
		}
		
		
		wechatAccessToken.setAppid(appid);
		TOKEN_STORE.put(appid, wechatAccessToken);
		logger.info("put config, appid="+appid);
		return wechatAccessToken;
	}
	
	
	/**
	 * 
	 * @param appid
	 * @return
	 */
	public WechatAccessToken deleteConfig(String appid){
		if(appid == null){
			throw new TokenException("missing appid");
		}
		
		
		WechatAccessToken wechatAccessToken = TOKEN_STORE.get(appid);
		if(wechatAccessToken == null){
			throw new TokenException("missing wechatAccessToken by appid:"+appid);
		}
		
		
		TOKEN_STORE.remove(appid);
		logger.info("delete config by appid="+appid);
		return wechatAccessToken;
	}
	
	
	/**
	 * 
	 * @param appid
	 */
	public void refresh(String appid){
		logger.info("refresh by appid="+appid);
		//
	}
	
	/**
	 * 
	 * @return
	 */
	public AccessTokenOnly[] getTokens(){
		if(TOKEN_STORE.size() == 0){
			return new AccessTokenOnly[]{};
		}
		
		
		
		//
		AccessTokenOnly[] tokens= new AccessTokenOnly[TOKEN_STORE.size()];
		Set<String> appids = TOKEN_STORE.keySet();
		int tmp = 0;
		for(String appid : appids){
			tokens[tmp++] = new AccessTokenOnly(appid, TOKEN_STORE.get(appid).getAccessToken());
		}
		logger.info("get all Token");
		return tokens;
	}
	
	public AccessTokenOnly getToken(String appid){
		if(appid == null ){
			throw new TokenException("missing appid");
		}
		
		WechatAccessToken wechatAccessToken = TOKEN_STORE.get(appid);
		if(wechatAccessToken == null){
			throw new TokenException("missing wechatAccessToken by appid:"+appid);
		}
		
		logger.info("get Token by appid="+appid);
		return new AccessTokenOnly(appid, wechatAccessToken.getAccessToken());
	}
	
	
}
