/*
 * Created by Pavel Gavrilov
 */

/*
 * Created by Pavel Gavrilov
 */

/*
 * Created by Pavel Gavrilov
 */

package com.fofgroup.test.api;

import com.fofgroup.test.service.ServiceLocator;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 *
 * Interface to send message from abstract message source
 */
public interface MessageBroker<T extends Message> {
    /**
     * sends message
     * @param message message to send
     */
    default void send(T message) {
        message.getTopics()
                .stream()
                .map(Topic::getId)
                .map(ServiceLocator.getInstance().getTopicSubscriberMap()::getByTopic)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet())
                .parallelStream()
                .forEach(id -> ServiceLocator
                        .getInstance()
                        .getMessageTransport()
                        .send(ServiceLocator.
                                getInstance().
                                getSubscriberStore().
                                getSubscriber(id), message));
    }
}
