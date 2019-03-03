package org.pattern.design.contracts.observer;

/**
 * This interface allows method for Registering subscribers.
 * 
 * @author Anish Singh
 *
 */
public interface Registrar<S extends Subscriber<MessageInformation<Object>>, T extends SubscriptionType> {

	/**
	 * This method will used to register a subscriber for a particular type of
	 * information.
	 * 
	 * @param subscriber
	 */
	public void register(S subscriber, T subscriptionType);

	/**
	 * This method will allow to unregister the subscriber for the particular
	 * subscription type.
	 * 
	 * @param inforamtionType
	 */
	public void unregister(S subscriber, T subscriptionType);

	public void unregister(S subscriber);

}
