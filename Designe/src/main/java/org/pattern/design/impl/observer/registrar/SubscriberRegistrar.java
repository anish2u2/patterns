package org.pattern.design.impl.observer.registrar;

import java.util.ArrayList;

import org.pattern.design.abstracts.observer.registrar.AbstractRegistrar;
import org.pattern.design.contracts.observer.MessageInformation;
import org.pattern.design.contracts.observer.Subscriber;
import org.pattern.design.contracts.observer.SubscriptionType;

public class SubscriberRegistrar extends AbstractRegistrar {

	@Override
	protected void subscrib(Subscriber<MessageInformation<Object>> subscriber, SubscriptionType type) {
		logger.info("Registering");
		if (getRegisteredSubscribers().get(type) == null)
			getRegisteredSubscribers().put(type, new ArrayList<>());
		getRegisteredSubscribers().get(type).add(subscriber);
		logger.info("Finish");
	}

	@Override
	protected void unregisterSubscriber(Subscriber<MessageInformation<Object>> subscriber, SubscriptionType type) {
		logger.info("Unregistering.");
		if (getRegisteredSubscribers().get(type) != null) {
			getRegisteredSubscribers().get(type).remove(subscriber);
			logger.info("Finish.");
		} else
			logger.info("No specified subscription type is present.");

	}

}
