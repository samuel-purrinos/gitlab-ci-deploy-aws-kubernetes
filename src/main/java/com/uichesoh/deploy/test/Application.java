package com.uichesoh.deploy.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements ApplicationListener<ContextRefreshedEvent> {

	private final PublicIpFetcher publicIpFetcher;
	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	public Application(PublicIpFetcher publicIpFetcher) {
		this.publicIpFetcher = publicIpFetcher;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		String ip = publicIpFetcher.fetchPublicIp();
		logger.info("Public IP: {}", ip);
	}
}
