package com.fofgroup.test.api;

import java.util.Collection;

/**
 * Represents message to send
 */
public interface Message {
    /**
     *
     * @return collection of id of topics
     */
    Collection<Long> getTopicIds();
}
