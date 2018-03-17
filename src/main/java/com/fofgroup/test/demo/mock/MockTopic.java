package com.fofgroup.test.demo.mock;

import com.fofgroup.test.api.Topic;

public class MockTopic implements Topic {
    private Long id;
    private String topic;

    public MockTopic(Long id, String topic) {
        this.id = id;
        this.topic = topic;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
