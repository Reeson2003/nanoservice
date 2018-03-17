/*
 * Created by Pavel Gavrilov
 */

package com.fofgroup.test.api;

import java.util.Collection;

/**
 *
 * Represents message to send
 */
public interface Message {
    /**
     *
     * @return collection  of topics
     */
    Collection<? extends Topic> getTopics();
}
