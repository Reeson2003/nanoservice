package com.fofgroup.test.demo.mock;

import com.fofgroup.test.transport.MessageTransport;
import com.fofgroup.test.transport.MessageTransportFactory;

public class MockMessageTransportFactory implements MessageTransportFactory<MockSubscriber, MockMessage> {
    @Override
    public MessageTransport getTransport() {
        return new MockMessageTransport();
    }
}
