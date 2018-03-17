/*
 * Created by Pavel Gavrilov
 */

package com.fofgroup.test.demo.mock;

import com.fofgroup.test.storage.SubscriberStore;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class MockSubscriberStore implements SubscriberStore<MockSubscriber> {
    private Map<Long, MockSubscriber> subscribers = new ConcurrentHashMap<>();
    private AtomicLong idGenerator = new AtomicLong(0);

    @Override
    public MockSubscriber getSubscriber(Long id) {
        return subscribers.get(id);
    }

    @Override
    public Long addSubscriber(MockSubscriber subscriber) {
        Long id = generateId();
        subscriber.setId(id);
        subscribers.put(id, subscriber);
        return id;
    }

    @Override
    public void removeSubscriber(Long id) {
        subscribers.remove(id);
    }

    private Long generateId() {
        return idGenerator.getAndIncrement();
    }
}
