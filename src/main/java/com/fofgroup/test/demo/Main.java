/*
 * Created by Pavel Gavrilov
 */

package com.fofgroup.test.demo;

import com.fofgroup.test.demo.mock.MockMessageBroker;
import com.fofgroup.test.demo.mock.MockMessageTransport;
import com.fofgroup.test.demo.mock.MockNanoService;
import com.fofgroup.test.demo.mock.MockSubscriberStore;
import com.fofgroup.test.service.ServiceLocator;
import com.fofgroup.test.storage.InMemoryTopicSubscriberMap;

public class Main {
    public static void main(String[] args) {
        ServiceLocator.init(new InMemoryTopicSubscriberMap(), new MockMessageTransport(), new MockSubscriberStore());
        Thread subscriberThread = new Thread(new MockSubscriberGenerator(new MockNanoService()));
        Thread messageThread = new Thread(new MockMessageGenerator(new MockMessageBroker()));
        subscriberThread.start();
        messageThread.start();
    }
}
