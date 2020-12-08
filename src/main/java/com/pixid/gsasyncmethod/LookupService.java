/**
 * 
 */
package com.pixid.gsasyncmethod;

import java.util.concurrent.CompletableFuture;

/**
 * @author podisto
 *
 */
public interface LookupService {
	
	CompletableFuture<User> findUser(String user) throws InterruptedException;

}
