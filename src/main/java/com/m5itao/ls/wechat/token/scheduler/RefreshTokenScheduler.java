package com.m5itao.ls.wechat.token.scheduler;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class RefreshTokenScheduler {

	private static final Logger logger = Logger.getLogger(RefreshTokenScheduler.class);
	
	@Scheduled(cron = "*/10 * * * * * ")
	public void job(){
		logger.info("refresh token from wechat now");
		
		
	}
	
}
