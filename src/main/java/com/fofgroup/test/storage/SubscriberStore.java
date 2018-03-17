/*
 * Created by Pavel Gavrilov
 */

/*
 * Created by Pavel Gavrilov
 */

package com.fofgroup.test.storage;

import com.fofgroup.test.api.Subscriber;

/**
 *
 * Interface to implement, represents store of subscribers
 * @param <S> {@link Subscriber} implementation
 */
public interface SubscriberStore<S extends Subscriber> {
    /**
     *
     * @param id id of subscriber
     * @return {@link Subscriber} implementation
     */
    S getSubscriber(Long id);

    /**
     *
     * adds subscriber in storage
     * @param subscriber {@link Subscriber} implementation
     * @return id of subscriber
     */
    Long addSubscriber(S subscriber);

    /**
     *
     * removes subscriber from storage
     * @param id id of subscriber
     */
    void removeSubscriber(Long id);
}
