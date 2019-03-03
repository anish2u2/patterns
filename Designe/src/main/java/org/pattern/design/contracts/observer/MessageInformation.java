package org.pattern.design.contracts.observer;

/**
 * This interface will allow methods for setting /accessing message transmitting
 * between two objects.
 * 
 * @author Anish Singh
 *
 */
public interface MessageInformation<M extends Object> {

	/**
	 * This method will return message.
	 * 
	 * @return
	 */
	public M getMessage();

}
