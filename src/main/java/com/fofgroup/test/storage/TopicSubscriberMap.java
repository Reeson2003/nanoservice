/*
 * Created by Pavel Gavrilov
 */

/*
 * Created by Pavel Gavrilov
 */

package com.fofgroup.test.storage;

import java.util.Collection;

/**
 * Storage of subscribers of topics
 */
public interface TopicSubscriberMap {
    /**
     * adds subscriber in storage
     * @param subscriberId id of subscriber
     * @param topicId id of topic
     */
    void addSubscriber(Long subscriberId, Long topicId);

    /**
     * removes subscriber from storage
     * @param subscriberId id of subscriber
     * @param topicId id of topic
     */
    void removeSubscriber(Long subscriberId, Long topicId);

    /**
     *
     * @param topicId id of topic
     * @return collection of ids of subscribers of topic
     */
    Collection<Long> getByTopic(Long topicId);
}
