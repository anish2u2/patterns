package org.pattern.design.contracts.observer;

public interface Observer {

	public Publisher<MessageInformation<Object>> getPublisher();

	public void addSubscriber(Subscriber<MessageInformation<Object>> subscriber, SubscriptionType type);

	public void unSubscribe(Subscriber<MessageInformation<Object>> subscriber, SubscriptionType type);

}
