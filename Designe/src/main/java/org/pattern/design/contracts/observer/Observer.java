package org.pattern.design.contracts.observer;

/**
 * This interface introduces behavioral methods of Observer.
 * 
 * Observer patter strive to loose coupling between objects.
 * 
 * @author Anish Singh
 *
 */
public interface Observer {

	public Publisher<MessageInformation<Object>> getPublisher();

	public void addSubscriber(Subscriber<MessageInformation<Object>> subscriber, SubscriptionType type);

	public void unSubscribe(Subscriber<MessageInformation<Object>> subscriber, SubscriptionType type);

}
