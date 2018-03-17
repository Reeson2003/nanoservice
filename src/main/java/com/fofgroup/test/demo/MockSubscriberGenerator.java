/*
 * Created by Pavel Gavrilov
 */

package com.fofgroup.test.demo;

import com.fofgroup.test.demo.mock.MockNanoService;
import com.fofgroup.test.demo.mock.MockSubscriber;
import com.fofgroup.test.demo.mock.MockTopic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class MockSubscriberGenerator implements MockTopics, Runnable {
    private static final int PERIOD = 50;
    private static final int SIZE = 200;
    private long counter = 0;
    private Random random = new Random(System.nanoTime());
    private Map<MockSubscriber, MockTopic> subscribers = new ConcurrentHashMap<>();
    private MockNanoService mockNanoService;

    public MockSubscriberGenerator(MockNanoService mockNanoService) {
        this.mockNanoService = mockNanoService;
    }

    public void run() {
        generate();
    }

    private void generate() {
        while (true) {
            if (System.currentTimeMillis() % PERIOD == 0) {
                createSubscriber();
            }
            if (System.currentTimeMillis() % PERIOD == 0 && subscribers.size() > SIZE)
                removeSubscriber();
        }
    }

    private void createSubscriber() {
        MockSubscriber subscriber = new MockSubscriber("Subscriber #" + counter++);
        MockTopic topic = getTopic();
        subscribe(subscriber, topic);
        subscribers.put(subscriber, topic);
    }

    private void removeSubscriber() {
        MockSubscriber subscriber = getRandomSubscriber();
        unsubscribe(subscriber, subscribers.get(subscriber));
        subscribers.remove(subscriber);
    }

    private MockSubscriber getRandomSubscriber() {
        List<MockSubscriber> subscriberList = new ArrayList<>(subscribers.keySet());
        return subscriberList.get(random.nextInt(subscriberList.size()));
    }

    private void subscribe(MockSubscriber subscriber, MockTopic topic) {
        new Thread(() -> mockNanoService.subscribe(subscriber, topic)).run();
    }

    private void unsubscribe(MockSubscriber subscriber, MockTopic topic) {
        new Thread(()-> mockNanoService.unSubscribe(subscriber, topic)).run();
    }
}
