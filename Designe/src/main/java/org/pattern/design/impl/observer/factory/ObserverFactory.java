package org.pattern.design.impl.observer.factory;

import org.pattern.design.contracts.observer.MessageInformation;
import org.pattern.design.contracts.observer.Observer;
import org.pattern.design.contracts.observer.ObserverPatterenFactory;
import org.pattern.design.contracts.observer.Publisher;
import org.pattern.design.contracts.observer.Registrar;
import org.pattern.design.contracts.observer.Subscriber;
import org.pattern.design.contracts.observer.SubscribersRegistryData;
import org.pattern.design.contracts.observer.SubscriptionType;
import org.pattern.design.impl.observer.registrar.SubscriberRegistrar;

public class ObserverFactory implements ObserverPatterenFactory {

	private Publisher<MessageInformation<Object>> publisher;

	private Registrar<Subscriber<MessageInformation<Object>>, SubscriptionType> regisrar;

	private ObserverFactory() {
		regisrar = new SubscriberRegistrar();
		publisher = new org.pattern.design.impl.observer.publisher.Publisher();
		publisher.setRegistry((SubscribersRegistryData) regisrar);

	}

	public static Observer getObserverInstance() {
		return new ObserverFactory();
	}

	@Override
	public Publisher<MessageInformation<Object>> getPublisher() {

		return publisher;
	}

	@Override
	public void addSubscriber(Subscriber<MessageInformation<Object>> subscriber, SubscriptionType type) {
		regisrar.register(subscriber, type);
	}

	@Override
	public Observer getObserver() {

		return this;
	}

	@Override
	public void unSubscribe(Subscriber<MessageInformation<Object>> subscriber, SubscriptionType type) {
		regisrar.unregister(subscriber, type);
	}

}
