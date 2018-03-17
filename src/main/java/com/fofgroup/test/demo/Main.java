package com.fofgroup.test.demo;

import com.fofgroup.test.service.ServiceLocator;
import com.fofgroup.test.demo.mock.*;
import com.fofgroup.test.storage.InMemoryTopicSubscriberMap;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ServiceLocator.init(new InMemoryTopicSubscriberMap(), new MockMessageTransportFactory(), new MockSubscriberStore());
        Thread subscriberThread = new Thread(new MockSubscriberGenerator(new MockNanoService()));
        Thread messageThread = new Thread(new MockMessageGenerator(new MockMessageBroker()));
        subscriberThread.start();
        messageThread.start();
    }
}
