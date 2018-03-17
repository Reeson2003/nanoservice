/*
 * Created by Pavel Gavrilov
 */

/*
 * Created by Pavel Gavrilov
 */

package com.fofgroup.test.storage;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryTopicSubscriberMap implements TopicSubscriberMap {
    /**
     * Map of topic IDs on set of subscriber IDs
     */
    private Map<Long, Set<Long>> storage = new ConcurrentHashMap<>();

    @Override
    public void addSubscriber(Long subscriberId, Long topicId) {
        checkIdIsNull(subscriberId, "Subscriber");
        checkIdIsNull(topicId, "Topic");
        if (storage.containsKey(topicId))
            storage.get(topicId).add(subscriberId);
        else {
            Set<Long> subscribers = ConcurrentHashMap.newKeySet();
            subscribers.add(subscriberId);
            storage.put(topicId, subscribers);
        }
    }

    private void checkIdIsNull(Long id, String name) {
        if (id == null)
            throw new NullPointerException(name + " ID is null");
    }

    @Override
    public void removeSubscriber(Long subscriberId, Long topicId) {
        checkIdIsNull(subscriberId, "Subscriber");
        checkIdIsNull(topicId, "Topic");
        storage.get(topicId).remove(subscriberId);
    }

    @Override
    public Collection<Long> getByTopic(Long topicId) {
        return storage.get(topicId) == null ? Collections.EMPTY_LIST : storage.get(topicId);
    }
}
