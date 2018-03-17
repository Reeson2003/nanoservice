package com.fofgroup.test.transport;

import com.fofgroup.test.api.Message;
import com.fofgroup.test.api.Subscriber;

public interface MessageTransportFactory<S extends Subscriber, M extends Message> {
    MessageTransport<S, M> getTransport();
}
