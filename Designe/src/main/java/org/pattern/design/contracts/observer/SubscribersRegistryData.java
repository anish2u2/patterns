package org.pattern.design.contracts.observer;

import java.util.Collection;

/**
 * This interface will allow methods for accessing Subscriber for specific type
 * .
 * 
 * @author Anish Singh
 *
 */
public interface SubscribersRegistryData {

	/**
	 * This method will return List of Subscribers for a particular type.
	 * 
	 * @param type
	 * @return
	 */
	public Collection<Subscriber<MessageInformation<Object>>> getSubscribers(SubscriptionType type);

}
