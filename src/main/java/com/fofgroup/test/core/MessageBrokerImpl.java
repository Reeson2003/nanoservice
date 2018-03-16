package com.fofgroup.test.core;

import com.fofgroup.test.api.Message;
import com.fofgroup.test.api.MessageBroker;
import com.fofgroup.test.storage.SubscriberStorage;

import java.util.Collection;
import java.util.stream.Collectors;

public class MessageBrokerImpl implements MessageBroker {
    private SubscriberStorage storage = ServiceLocator.getInstance().getSubscriberStorage();

    @Override
    public void send(Message message) {
        message.getTopicIds()
                .stream()
                .map(storage::getByTopic)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet())
                .forEach(id -> ServiceLocator.getInstance().getMessageTransport().send(id, message));
    }
}
