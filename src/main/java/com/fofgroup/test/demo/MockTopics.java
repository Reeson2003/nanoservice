/*
 * Created by Pavel Gavrilov
 */

package com.fofgroup.test.demo;

import com.fofgroup.test.demo.mock.MockTopic;

import java.util.*;

public interface MockTopics {
    List<MockTopic> TOPICS = Arrays.asList(
            new MockTopic(1L, "First topic"),
            new MockTopic(2L, "Second topic"),
            new MockTopic(3L, "Third topic"),
            new MockTopic(4L, "Fourth topic"),
            new MockTopic(5L, "Fifth topic"));


    default MockTopic getTopic() {
        return TOPICS.get(new Random(System.nanoTime()).nextInt(TOPICS.size()));
    }

    default Collection<MockTopic> getTopics() {
        return new HashSet<>(Arrays.asList(getTopic(), getTopic(), getTopic()));
    }
}
