package org.pattern.design.abstracts.observer.publisher;

import java.util.logging.Logger;

import org.pattern.design.contracts.observer.MessageInformation;
import org.pattern.design.contracts.observer.Publisher;
import org.pattern.design.contracts.observer.SubscribersRegistryData;
import org.pattern.design.contracts.observer.SubscriptionType;

public abstract class AbstractPublisher implements Publisher<MessageInformation<Object>> {

	protected Logger logger = Logger.getLogger(this.getClass().getName());

	private SubscribersRegistryData registry;

	@Override
	public void publish(MessageInformation<Object> information, SubscriptionType type) {
		preProcessBeforePublishingMessage(information);
		publishMessage(information, type);
		postProcessAfterPublishingMessage(information);
	}

	protected abstract void publishMessage(MessageInformation<Object> information, SubscriptionType type);

	private void preProcessBeforePublishingMessage(MessageInformation<Object> information) {
		logger.info("Pre processing before publishing message.");
	}

	private void postProcessAfterPublishingMessage(MessageInformation<Object> information) {
		logger.info("post processing after publishing message.");
	}

	public SubscribersRegistryData getRegistry() {
		return registry;
	}

	public void setRegistry(SubscribersRegistryData registry) {
		this.registry = registry;
	}

}
