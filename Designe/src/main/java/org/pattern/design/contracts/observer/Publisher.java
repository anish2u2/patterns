package org.pattern.design.contracts.observer;

/**
 * This interface will allow methods to publish.
 * 
 * @author Anish Singh
 *
 */
public interface Publisher<T extends MessageInformation<Object>> {

	/**
	 * This method will publish information of type T.
	 * 
	 * @param information
	 */
	public void publish(T information, SubscriptionType type);

	public void setRegistry(SubscribersRegistryData registry);

}
