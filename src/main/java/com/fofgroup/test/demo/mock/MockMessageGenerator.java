package com.fofgroup.test.demo.mock;

import com.fofgroup.test.api.MessageBroker;

import java.util.Random;

public class MockMessageGenerator implements MockTopics, Runnable{
    private static final int DELAY = 1;
    private long counter = 0;
    MessageBroker<MockMessage> messageBroker;
    private Random random = new Random(System.nanoTime());

    public MockMessageGenerator(MessageBroker<MockMessage> messageBroker) {
        this.messageBroker = messageBroker;
    }

    public void run() {
        generate();
    }

    private void generate() {
        while (true) {
            messageBroker.send(getMessage());
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private MockMessage getMessage() {
        String text = "Message #";
        return new MockMessage(getTopics(), text + counter++);
    }
}
