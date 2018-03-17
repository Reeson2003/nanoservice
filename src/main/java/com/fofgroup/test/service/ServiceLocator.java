package com.fofgroup.test.service;

import com.fofgroup.test.api.Message;
import com.fofgroup.test.api.Subscriber;
import com.fofgroup.test.storage.SubscriberStore;
import com.fofgroup.test.storage.TopicSubscriberMap;
import com.fofgroup.test.transport.MessageTransportFactory;

public class ServiceLocator<S extends Subscriber, M extends Message> {
    private static ServiceLocator instance = null;

    private TopicSubscriberMap topicSubscriberMap;
    private MessageTransportFactory<S, M> messageTransportFactory;
    private SubscriberStore<S> subscriberStore;

    private ServiceLocator(TopicSubscriberMap topicSubscriberMap,
                           MessageTransportFactory<S, M> messageTransportFactory,
                           SubscriberStore<S> subscriberStore){
        this.topicSubscriberMap = topicSubscriberMap;
        this.messageTransportFactory = messageTransportFactory;
        this.subscriberStore = subscriberStore;
    }

    public static <S extends Subscriber, M extends Message> void init(TopicSubscriberMap topicSubscriberMap,
                            MessageTransportFactory<S, M> messageTransportFactory,
                            SubscriberStore<S> subscriberStore) {
        if (instance != null)
            return;
        instance = new ServiceLocator<>(topicSubscriberMap, messageTransportFactory, subscriberStore);
    }

    public static ServiceLocator getInstance() {
        if (instance == null)
            throw new RuntimeException("ServiceLocator not initialized");
        return instance;
    }

    public TopicSubscriberMap getTopicSubscriberMap() {
        return topicSubscriberMap;
    }

    public MessageTransportFactory<S, M> getMessageTransportFactory() {
        return messageTransportFactory;
    }

    public SubscriberStore<S> getSubscriberStore() {
        return subscriberStore;
    }
}
