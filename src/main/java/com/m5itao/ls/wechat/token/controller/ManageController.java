package com.m5itao.ls.wechat.token.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.m5itao.ls.wechat.token.data.WebObjectModel;
import com.m5itao.ls.wechat.token.data.WechatAccessToken;
import com.m5itao.ls.wechat.token.service.TokenService;

/**
 * 
 * @author m5itao
 *
 */
@Controller
@RequestMapping("/admin")
public class ManageController {

	@Autowired
	private TokenService tokenService;
	
	
	/**
	 * list
	 * @return
	 */
	@RequestMapping("")
	public String index(){
		return "forward:/admin/config";
	}
	
	
	/**
	 * list
	 * @return
	 */
	@RequestMapping(value="/config", method = RequestMethod.GET)
	@ResponseBody
	public WebObjectModel toIndex(){
		return WebObjectModel.build(tokenService.getConfigs());
		
	}
	
	
	/**
	 * read R
	 * @return
	 */
	@RequestMapping(value="/config/{appid}", method = RequestMethod.GET)
	@ResponseBody
	public WebObjectModel getConfig(@PathVariable String appid){
		return WebObjectModel.build(tokenService.getConfig(appid));
	}
	
	/**
	 * create C
	 * @return
	 */
	@RequestMapping(value="/config", method = RequestMethod.POST)
	@ResponseBody
	public WebObjectModel postConfig(@RequestBody WechatAccessToken wechatAccessToken){
		tokenService.postConfig(wechatAccessToken);
		return WebObjectModel.build();
	}
	
	/**
	 * update U
	 * @return
	 */
	@RequestMapping(value="/config/{appid}", method = RequestMethod.PUT)
	@ResponseBody
	public WebObjectModel putConfig(@PathVariable String appid, @RequestBody WechatAccessToken wechatAccessToken){
		tokenService.putConfig(appid, wechatAccessToken);
		return WebObjectModel.build();
	}
	
	
	/**
	 * delete D
	 * @return
	 */
	@RequestMapping(value="/config/{appid}", method = RequestMethod.DELETE)
	@ResponseBody
	public WebObjectModel deleteConfig(@PathVariable String appid){
		tokenService.deleteConfig(appid);
		return WebObjectModel.build();
	}
	
	/**
	 * refresh token
	 * @return
	 */
	@RequestMapping(value="/refresh/{appid}")
	@ResponseBody
	public WebObjectModel refreshToken(@PathVariable String appid){
		tokenService.refresh(appid);
		return WebObjectModel.build();
	}
	
}
