/**
 * 
 */
package com.pixid.gsasyncmethod;

import java.util.concurrent.CompletableFuture;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

/**
 * @author podisto
 *
 */
@Service
@Slf4j
public class GithubLookupService implements LookupService {
	
	private final RestTemplate restTemplate;
	
	public GithubLookupService(RestTemplateBuilder restTemplateBuilder) {
		super();
		this.restTemplate = restTemplateBuilder.build();
	}

	@Async
	@Override
	public CompletableFuture<User> findUser(String user) throws InterruptedException {
		log.info("<< find user {} >>", user);
		String url = String.format("https://api.github.com/users/%s", user);
		User results = restTemplate.getForObject(url, User.class);
		Thread.sleep(1000);
		return CompletableFuture.completedFuture(results);
	}
	
	
}
