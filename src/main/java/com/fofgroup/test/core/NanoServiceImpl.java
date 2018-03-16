package com.fofgroup.test.core;

import com.fofgroup.test.api.NanoService;
import com.fofgroup.test.storage.SubscriberStorage;

public class NanoServiceImpl implements NanoService {
    private SubscriberStorage storage = ServiceLocator.getInstance().getSubscriberStorage();


    @Override
    public void subscribe(Long topicId, Long subscriberId) {
        storage.addSubscriber(subscriberId, topicId);
    }

    @Override
    public void unSubscribe(Long topicId, Long subscriberId) {
        storage.removeSubscriber(subscriberId, topicId);
    }
}
