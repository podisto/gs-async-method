/**
 * 
 */
package com.pixid.gsasyncmethod;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * @author podisto
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class User {

	private String name;
	private String blog;
}
