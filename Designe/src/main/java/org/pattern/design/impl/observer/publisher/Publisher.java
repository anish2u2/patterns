package org.pattern.design.impl.observer.publisher;

import org.pattern.design.abstracts.observer.publisher.AbstractPublisher;
import org.pattern.design.contracts.observer.MessageInformation;
import org.pattern.design.contracts.observer.Subscriber;
import org.pattern.design.contracts.observer.SubscriptionType;

public class Publisher extends AbstractPublisher {

	@Override
	protected void publishMessage(MessageInformation<Object> information, SubscriptionType type) {
		logger.info("Publishing.");
		for (Subscriber<MessageInformation<Object>> subscriber : getRegistry().getSubscribers(type)) {
			subscriber.update(information);
		}
		logger.info("Published.");
	}

}
