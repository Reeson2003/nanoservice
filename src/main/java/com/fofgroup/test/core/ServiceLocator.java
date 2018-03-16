package com.fofgroup.test.core;

import com.fofgroup.test.storage.InMemorySubscriberStorage;
import com.fofgroup.test.storage.SubscriberStorage;
import com.fofgroup.test.transport.MessageTransportFactory;

public class ServiceLocator {
    private static ServiceLocator instance = new ServiceLocator();

    private SubscriberStorage subscriberStorage = new InMemorySubscriberStorage();
    private static MessageTransportFactory messageTransportFactory;

    private ServiceLocator(){}

    public static ServiceLocator getInstance() {
        return instance;
    }

    public SubscriberStorage getSubscriberStorage() {
        return subscriberStorage;
    }

    public MessageTransportFactory getMessageTransportFactory() {
        return messageTransportFactory;
    }
}
