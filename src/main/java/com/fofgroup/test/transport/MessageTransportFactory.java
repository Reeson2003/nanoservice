package com.fofgroup.test.transport;

import com.fofgroup.test.api.Message;

public interface MessageTransportFactory {
    MessageTransport<? super Message> getTransport(Class<?> tClass);
}
