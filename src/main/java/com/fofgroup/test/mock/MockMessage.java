package com.fofgroup.test.mock;

import com.fofgroup.test.api.Message;

import java.util.Collection;

public class MockMessage implements Message {
    private Collection<Long> topicIds;
    private String message;

    public MockMessage(Collection<Long> topicIds, String message) {
        this.topicIds = topicIds;
        this.message = message;
    }

    @Override
    public Collection<Long> getTopicIds() {
        return topicIds;
    }

    public String getMessage() {
        return message;
    }
}
