package com.fofgroup.test.api;

import com.fofgroup.test.core.ServiceLocator;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Interface to send message from abstract message source
 */
public interface MessageBroker<T extends Message> {
    /**
     * sends message
     * @param message message to send
     */
    default void send(T message) {
        message.getTopicIds()
                .stream()
                .map(ServiceLocator.getInstance().getSubscriberStorage()::getByTopic)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet())
                .forEach(id -> ServiceLocator
                        .getInstance()
                        .getMessageTransportFactory()
                        .getTransport(message.getClass())
                        .send(id, message));
    }
}
