/**
 * 
 */
package com.pixid.gsasyncmethod;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author podisto
 *
 */
@Component
@Slf4j
public class AppRunner implements CommandLineRunner {
	
	private final LookupService lookupService;
	
	public AppRunner(LookupService lookupService) {
		this.lookupService = lookupService;
	}

	@Override
	public void run(String... args) throws Exception {
		long start = System.currentTimeMillis();
		
		CompletableFuture<User> user1 = lookupService.findUser("PivotalSoftware");
		CompletableFuture<User> user2 = lookupService.findUser("CloudFoundry");
		CompletableFuture<User> user3 = lookupService.findUser("Spring-Projects");
		CompletableFuture<User> user4 = lookupService.findUser("podisto");
		log.info("<< End Main Process >>");
		
		// wait until they are all done
		CompletableFuture.allOf(user1, user2, user3, user4);
		
		log.info("<< Elapsed time {} ms >>", System.currentTimeMillis() - start);
		log.info("<< User1 {} >>", user1.get());
		log.info("<< User2 {} >>", user2.get());
		log.info("<< User3 {} >>", user3.get());
		log.info("<< User4 {} >>", user4.get());
	}

}
