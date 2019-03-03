package org.pattern.design;

import org.pattern.design.contracts.observer.MessageInformation;
import org.pattern.design.contracts.observer.Observer;
import org.pattern.design.contracts.observer.Publisher;
import org.pattern.design.contracts.observer.Subscriber;
import org.pattern.design.contracts.observer.SubscriptionType;
import org.pattern.design.impl.observer.factory.ObserverFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesigneApplication {

	public static void main(String[] args) {
		// SpringApplication.run(DesigneApplication.class, args);
		Observer observer = ObserverFactory.getObserverInstance();
		Publisher<MessageInformation<Object>> publisher = observer.getPublisher();
		Subscriber<MessageInformation<Object>> subscriber = new Subscriber<MessageInformation<Object>>() {

			@Override
			public void update(MessageInformation<Object> message) {
				System.out.println("Recieved message:" + message.getMessage());
			}
		};

		observer.addSubscriber(subscriber, SubscriptionType.BROADCAST);
		publisher.publish(new MessageInformation<Object>() {

			@Override
			public Object getMessage() {
				return "Testing publish and subscription.";
			}
		}, SubscriptionType.BROADCAST);
	}

}
