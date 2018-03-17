package com.fofgroup.test.demo.mock;

import com.fofgroup.test.api.Subscriber;

public class MockSubscriber implements Subscriber {
    private Long id;
    private String name;

    public MockSubscriber(String name) {
        this.name = name;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
