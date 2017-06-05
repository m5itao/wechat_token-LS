package com.m5itao.ls.wechat.token.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.m5itao.ls.wechat.token.data.WebObjectModel;
import com.m5itao.ls.wechat.token.service.TokenService;

@Controller
public class Token2PublicController {

	@Autowired
	private TokenService tokenService;
	
	/**
	 * index token list
	 * @return
	 */
	@RequestMapping
	@ResponseBody
	public String index(){
		return "Welcome to get WeChat token";
	}
	
	/**
	 * forward to index
	 * @return
	 */
	@RequestMapping("/get")
	@ResponseBody
	public WebObjectModel gets(){
		return WebObjectModel.build(tokenService.getTokens());
	}
	
	
	/**
	 * get token by appid
	 * @param appid
	 * @return
	 */
	@RequestMapping("/get/{appid}")
	@ResponseBody
	public WebObjectModel get(@PathVariable String appid){
		return WebObjectModel.build(tokenService.getToken(appid));
	}
	
}
