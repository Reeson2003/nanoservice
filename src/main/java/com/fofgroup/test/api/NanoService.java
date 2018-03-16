package com.fofgroup.test.api;

/**
 * Interface for subscribe to and unsubscribe from topic
 */
public interface NanoService {
    /**
     * subscribes to topic
     * @param topicId id of topic
     * @param subscriberId id of subscriber
     */
    void subscribe(Long topicId, Long subscriberId);

    /**
     * unsubscribes from topic
     * @param topicId id of topic
     * @param subscriberId id of subscriber
     */
    void unSubscribe(Long topicId, Long subscriberId);
}
