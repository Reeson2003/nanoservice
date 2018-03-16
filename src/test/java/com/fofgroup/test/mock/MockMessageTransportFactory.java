package com.fofgroup.test.mock;

import com.fofgroup.test.transport.MessageTransport;
import com.fofgroup.test.transport.MessageTransportFactory;

public class MockMessageTransportFactory implements MessageTransportFactory {
    @Override
    public MessageTransport getTransport(Class<?> tClass) {
        if (!MockMessage.class.equals(tClass))
            throw new RuntimeException("No tarnsport defined for type " + tClass.getName());
        return new MockMessageTransport();
    }
}
