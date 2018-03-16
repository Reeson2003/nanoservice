package com.fofgroup.test.mock;

import com.fofgroup.test.transport.MessageTransport;

public class MockMessageTransport implements MessageTransport<MockMessage> {
    @Override
    public void send(Long subscriberId, MockMessage message) {
        System.out.println("subscriberId = [" + subscriberId + "], message = [" + message + "]");
    }
}
