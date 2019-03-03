package org.pattern.design.contracts.observer;

/**
 * This interface allows method for subscribe/get updated to a particular
 * information.
 * 
 * @author Anish Singh
 *
 * @param <ST>
 */

public interface Subscriber<T extends MessageInformation<Object>> {

	/**
	 * This method will update the subscriber .
	 * 
	 * @param message
	 */
	public void update(T message);

}
