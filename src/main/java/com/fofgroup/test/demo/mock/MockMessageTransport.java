package com.fofgroup.test.demo.mock;

import com.fofgroup.test.transport.MessageTransport;

public class MockMessageTransport implements MessageTransport<MockSubscriber, MockMessage> {
    @Override
    public void send(MockSubscriber subscriber, MockMessage message) {
        System.out.println("subscriber = [" + subscriber.getName() + "], message = [" + message.getMessage() + "]");
    }
}
