/*
 * Created by Pavel Gavrilov
 */

package com.fofgroup.test.service;

import com.fofgroup.test.api.Message;
import com.fofgroup.test.api.Subscriber;
import com.fofgroup.test.storage.SubscriberStore;
import com.fofgroup.test.storage.TopicSubscriberMap;
import com.fofgroup.test.transport.MessageTransport;

public class ServiceLocator<S extends Subscriber, M extends Message> {
    private static ServiceLocator instance = null;

    private TopicSubscriberMap topicSubscriberMap;
    private MessageTransport<S, M> messageTransport;
    private SubscriberStore<S> subscriberStore;

    private ServiceLocator(TopicSubscriberMap topicSubscriberMap,
                           MessageTransport<S, M> messageTransport,
                           SubscriberStore<S> subscriberStore){
        this.topicSubscriberMap = topicSubscriberMap;
        this.messageTransport = messageTransport;
        this.subscriberStore = subscriberStore;
    }

    public static synchronized <S extends Subscriber, M extends Message> void init(TopicSubscriberMap topicSubscriberMap,
                                                                                   MessageTransport<S, M> messageTransport,
                                                                                   SubscriberStore<S> subscriberStore) {
        if (instance != null)
            return;
        instance = new ServiceLocator<>(topicSubscriberMap, messageTransport, subscriberStore);
    }

    public static ServiceLocator getInstance() {
        if (instance == null)
            throw new RuntimeException("ServiceLocator not initialized");
        return instance;
    }

    public TopicSubscriberMap getTopicSubscriberMap() {
        return topicSubscriberMap;
    }

    public MessageTransport<S, M> getMessageTransport() {
        return messageTransport;
    }

    public SubscriberStore<S> getSubscriberStore() {
        return subscriberStore;
    }
}
