package com.fofgroup.test.transport;

public interface MessageTransport<T> {
    void send(Long subscriberId, T message);
}
