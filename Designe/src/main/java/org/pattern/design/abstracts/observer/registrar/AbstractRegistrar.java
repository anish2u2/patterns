package org.pattern.design.abstracts.observer.registrar;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.pattern.design.contracts.observer.MessageInformation;
import org.pattern.design.contracts.observer.Registrar;
import org.pattern.design.contracts.observer.Subscriber;
import org.pattern.design.contracts.observer.SubscribersRegistryData;
import org.pattern.design.contracts.observer.SubscriptionType;

public abstract class AbstractRegistrar
		implements Registrar<Subscriber<MessageInformation<Object>>, SubscriptionType>, SubscribersRegistryData {

	protected Logger logger = Logger.getLogger(this.getClass().getName());

	private Map<SubscriptionType, Collection<Subscriber<MessageInformation<Object>>>> subscribers;

	public AbstractRegistrar() {
		subscribers = new HashMap<>(2);
	}

	@Override
	public void register(Subscriber<MessageInformation<Object>> subscriber, SubscriptionType subscriptionType) {
		try {
			logger.info("Registering subscriber " + subscriber.toString());
			preProcessBeforeSubscribing();
			subscrib(subscriber, subscriptionType);
			postProcessAfterSubscribing();
			logger.info("Subscriber " + subscriber.toString() + " registered.");
		} catch (Throwable e) {
			logger.severe("Unable to register subscriber " + subscriber.toString() + " due to " + e.getMessage());
		}
	}

	@Override
	public void unregister(Subscriber<MessageInformation<Object>> subscriber) {
		logger.info("Unregistering subscriber " + subscriber.toString() + " for type " + SubscriptionType.values());
		preProcessBeforeUnsubscribing();
		try {
			for (SubscriptionType type : SubscriptionType.values())
				unregisterSubscriber(subscriber, type);
		} catch (Throwable e) {
			logger.log(Level.SEVERE, e.getMessage());
			return;
		}
		postProcessAfterUnsubscribing();
		logger.info("Subscriber " + subscriber.toString() + " unregistered for type " + SubscriptionType.values());
	}

	@Override
	public void unregister(Subscriber<MessageInformation<Object>> subscriber, SubscriptionType subscriptionType) {
		logger.info("Unregistering subscriber " + subscriber.toString() + " for type " + subscriptionType);
		preProcessBeforeUnsubscribing();
		try {
			unregisterSubscriber(subscriber, subscriptionType);
		} catch (Throwable e) {
			logger.log(Level.SEVERE, e.getMessage());
			return;
		}
		postProcessAfterUnsubscribing();
		logger.info("Subscriber " + subscriber.toString() + " unregistered for type " + subscriptionType);
	}

	protected Map<SubscriptionType, Collection<Subscriber<MessageInformation<Object>>>> getRegisteredSubscribers() {
		return this.subscribers;
	}

	protected abstract void subscrib(Subscriber<MessageInformation<Object>> subscriber, SubscriptionType type);

	protected abstract void unregisterSubscriber(Subscriber<MessageInformation<Object>> subscriber,
			SubscriptionType type);

	public Collection<Subscriber<MessageInformation<Object>>> getSubscribers(SubscriptionType type) {
		return subscribers.get(type);
	}

	private void preProcessBeforeUnsubscribing() {
		logger.info("Pre processing before unsubscribing the subscriber.");
	}

	private void postProcessAfterUnsubscribing() {
		logger.info("Post processing after unsubscribing the subscriber.");
	}

	private void preProcessBeforeSubscribing() {
		logger.info("Pre processing before subscribing the subscriber.");
	}

	private void postProcessAfterSubscribing() {
		logger.info("Post processing after subscribing the subscriber.");
	}
}
