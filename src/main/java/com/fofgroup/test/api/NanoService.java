/*
 * Created by Pavel Gavrilov
 */

package com.fofgroup.test.api;

import com.fofgroup.test.service.ServiceLocator;

/**
 *
 * Interface for subscribe to and unsubscribe from topic
 */
public interface NanoService<S extends Subscriber, T extends Topic> {
    /**
     *
     * subscribes to topic
     * @param subscriber {@link Subscriber} implementation
     * @param topic {@link Topic} implementation
     */
    default void subscribe(S subscriber, T topic) {
        if (subscriber.getId() == null)
            ServiceLocator.getInstance().getSubscriberStore().addSubscriber(subscriber);
        if (ServiceLocator.getInstance().getSubscriberStore().getSubscriber(subscriber.getId()) == null)
            ServiceLocator.getInstance().getSubscriberStore().addSubscriber(subscriber);
        ServiceLocator.getInstance().getTopicSubscriberMap().addSubscriber(subscriber.getId(), topic.getId());
    }

    /**
     *
     * unsubscribes from topic
     * @param subscriber {@link Subscriber} implementation
     * @param topic {@link Topic} implementation
     */
    default void unSubscribe(S subscriber, T topic) {
        ServiceLocator.getInstance().getTopicSubscriberMap().removeSubscriber(subscriber.getId(), topic.getId());
    }
}
