/*
 * Created by Pavel Gavrilov
 */

/*
 * Created by Pavel Gavrilov
 */

package com.fofgroup.test.demo.mock;

import com.fofgroup.test.api.Message;

import java.util.Collection;

public class MockMessage implements Message {
    private Collection<MockTopic> topics;
    private String message;

    public MockMessage(Collection<MockTopic> topics, String message) {
        this.topics = topics;
        this.message = message;
    }

    @Override
    public Collection<MockTopic> getTopics() {
        return topics;
    }

    public String getMessage() {
        return message;
    }
}
