/*
 * Created by Pavel Gavrilov
 */

/*
 * Created by Pavel Gavrilov
 */

package com.fofgroup.test.transport;

import com.fofgroup.test.api.Message;
import com.fofgroup.test.api.Subscriber;

/**
 * interface to implement of real message sending service
 * @param <S> implementation of subscriber
 * @param <M> implementation of message
 */
public interface MessageTransport<S extends Subscriber, M extends Message> {
    /**
     * sends message to subscriber
     * @param subscriber implementation of subscriber
     * @param message implementation of message
     */
    void send(S subscriber, M message);
}
