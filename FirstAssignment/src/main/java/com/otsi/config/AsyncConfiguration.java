package com.otsi.config;

import java.util.concurrent.Executor;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@EnableAsync
@Configuration
public class AsyncConfiguration {

	@Bean(name = "asyncExecutor")
	public Executor asyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setMaxPoolSize(100);
		executor.setQueueCapacity(5);
		executor.setAllowCoreThreadTimeOut(true);
		executor.setKeepAliveSeconds(5);
		executor.initialize();
		return executor;
	}

}
